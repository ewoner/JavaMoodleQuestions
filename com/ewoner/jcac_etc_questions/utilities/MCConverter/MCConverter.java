package com.ewoner.jcac_etc_questions.utilities.MCConverter;

import com.ewoner.jcac_etc_questions.NewXMLParser;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.QuestionTypeEnum;
import com.ewoner.jcac_etc_questions.models.questions.types.QuestionMultipleChoice;
import com.ewoner.jcac_etc_questions.models.questions.types.QuestionMultipleChoiceSet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.*;

/*
 * MIT License
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
 */
public class MCConverter {

    static public void setLogger( Logger initLogger ) {
        MCConverter.logger = initLogger;
    }

    private File file, saveFile;
    private List<Question> oldQuestions, newQuestions;
    private static Logger logger;

    /**
     *
     */
    public MCConverter() {
        oldQuestions = null;
        newQuestions = null;
    }

    /**
     *
     * @param args
     */
    public static void main( String[] args ) {
        MCConverter model = new MCConverter();
        MCController controller = new MCController( model );
        MainFrame main = new MainFrame( controller );
        controller.setView( main );
        main.pack();
        main.setLocationRelativeTo( null );
        main.setVisible( true );
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile( File file ) {
        this.file = file;
    }

    /**
     * @return the saveFile
     */
    public File getSaveFile() {
        return saveFile;
    }

    /**
     * @param saveFile the saveFile to set
     */
    public void setSaveFile( File saveFile ) {
        this.saveFile = saveFile;
    }

    /**
     *
     */
    public void changeQuestionTypes() {
        Iterator<Question> itr = oldQuestions.iterator();
        newQuestions = new ArrayList<>( oldQuestions.size() );
        while( itr.hasNext() ) {
            QuestionMultipleChoice oldQ = ( QuestionMultipleChoice ) itr.next();
            itr.remove();
            newQuestions.add( new QuestionMultipleChoiceSet( oldQ ) );
        }
    }

    /**
     *
     */
    public void parseQuestions() {
        oldQuestions = new ArrayList<>( NewXMLParser.parseXMLfile( file ) );
        ArrayList<Question> keepList = new ArrayList<>();
        for( Question q : oldQuestions ) {
            if( ( q.getType() == QuestionTypeEnum.MultipleChoice ) && ( ( ( QuestionMultipleChoice ) q ).isSingle() == false ) ) {
                keepList.add( q );
            }
        }
        oldQuestions = keepList;
    }

    List<Question> getQuestions() {
        return this.oldQuestions;
    }

    List<Question> getNewQuestions() {
        return this.newQuestions;
    }

    static public Logger getLogger() {
        return logger;
    }
}
