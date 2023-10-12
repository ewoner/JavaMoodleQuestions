package com.ewoner.jcac_etc_questions.utilities.MCConverter;

import com.ewoner.JavaLoggers.TextAreaLogger;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*  MIT License
 * 
 * Copyright (c) 2022 Brion Lang
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
/**
 *
 * @author Brion Lang
 * @version 0.0.0
 */
public class MCController {

    private MainFrame view;
    private JFileChooser fc;
    private MCConverter model;

    static public Logger getLogger() {
        return MCConverter.getLogger();
    }

    /**
     *
     */
    public MCController() {
        this( null );
    }

    public MCController( MCConverter model ) {
        this.model = model;
        this.fc = null;
        this.view = null;
    }

    /**
     * @return the fc
     */
    public JFileChooser getFC() {
        return this.fc;
    }

    /**
     * @param newfc
     */
    public void setFC( JFileChooser newfc ) {
        this.fc = newfc;
        this.fc.setCurrentDirectory( new File( "/home/student/git-projects/newMoodleXML/src/main" ) );

    }

    /**
     *
     * @param view
     */
    public void setView( MainFrame view ) {
        this.view = view;
    }

    /**
     *
     */
    public void changeFile() {
        if( getFC() == null ) {
            System.err.print( "MCModel.fileButtonPressed( ActionEvent ) ran into an error.  MCModel's fc is set to null.  Program terminated." );
            System.exit( 1 );
        }
        if( getFC().showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            setFile( getFC().getSelectedFile() );
            setSaveFile( model.getFile().getParent() + File.separator + "new_" + model.getFile().getName() );
        }
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        String name = "";
        if( getFile() != null ) {
            name = getFile().getName();
        }
        return name;
    }

    /**
     * @return the saveFileName
     */
    public String getSaveFileName() {
        String name = "";
        if( getSaveFile() != null ) {
            name = getSaveFile().getName();
        }
        return name;
    }

    /**
     *
     */
    public void changeSaveFile() {
        if( getFC() == null ) {
            System.err.print( "MCModel.fileButtonPressed( ActionEvent ) ran into an error.  MCModel's fc is set to null.  Program terminated." );
            System.exit( 1 );
        }
        if( getFC().showSaveDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            setSaveFile( fc.getSelectedFile().getAbsolutePath() );
        }
    }

    public void setSaveFile( String newSaveFileName ) {
        model.setSaveFile( new File( newSaveFileName ) );
        try {
            TextAreaLogger.getLogger().log( Level.INFO, "Createed file:" + model.getSaveFile().getName() + "  " + model.getFile().exists() );
        } catch( Exception ex ) {
            Logger.getLogger( MCController.class.getName() ).log( Level.SEVERE, null, ex );
        }
        if( model.getSaveFile().exists() == false && model.getSaveFile().getName().endsWith( ".xml" ) == false ) {
            model.setSaveFile( new File( model.getSaveFile().getAbsolutePath() + ".xml" ) );
        }
    }

    /**
     *
     */
    public void convertFile() {
        if( model.getFile() == null || model.getFile().exists() == false ) {
            showError( "There is no file selected to load questions from.", "No File" );
            return;
        }
        if( this.model.getSaveFile() == null ) {
            showError( "There is no file selected to save question to.", "No Save File" );
            return;
        }
        int result = showOptionDialog( "This will overwrite any questions in " + getSaveFile().getName() + ".\n\nAre you sure you wish to continue?", "Overwrite File Information", JOptionPane.YES_NO_OPTION );
        if( result != JOptionPane.OK_OPTION ) {
            MCController.getLogger().info( "Operation cancelled.  No save performed." );
            return;
        }
        model.parseQuestions();
        MCController.getLogger().info( "Found " + model.getQuestions().size() + " questions to parse." );
        model.changeQuestionTypes();
        MCController.getLogger().info( "" + model.getNewQuestions().size() + " questions types changed." );

        PrintWriter fout;
        try {
            fout = new PrintWriter( new BufferedWriter( new FileWriter( model.getSaveFile() ) ) );
        } catch( FileNotFoundException ex ) {
            Logger.getLogger( MCController.class.getName() ).log( Level.SEVERE, null, ex );
            return;
        } catch( IOException ex ) {
            Logger.getLogger( MCController.class.getName() ).log( Level.SEVERE, null, ex );
            return;
        }
        fout.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<quiz>");
        for( Question q : model.getNewQuestions() ) {
            fout.println( q.toXMLString() );
        }
        fout.println("</quiz>");
        fout.close();
        getLogger().log(Level.INFO, "File: {1} saved.", model.getSaveFile().getAbsolutePath());
    }

    /**
     *
     * @param message
     * @param title
     */
    public void showError( String message, String title ) {
        showMessageDialog( message, title, JOptionPane.ERROR_MESSAGE );
    }

    public void showMessageDialog( String message, String title, int type ) {
        JOptionPane.showMessageDialog( null, message, title, type );
    }

    public int showOptionDialog( String message, String title, int type ) {
        return JOptionPane.showConfirmDialog( null, message, title, type );
    }

    public void setFile( File selectedFile ) {
        model.setFile( selectedFile );
        TextAreaLogger.getLogger().info( "Createed file:" + getFile().getName() + "  " + getFile().exists() );
    }

    public File getFile() {
        return model.getFile();
    }

    public File getSaveFile() {
        return model.getSaveFile();
    }

    void initLogger( JTextArea infoTextArea ) {
        MCConverter.setLogger( TextAreaLogger.initLogger( infoTextArea ) );
    }

}
