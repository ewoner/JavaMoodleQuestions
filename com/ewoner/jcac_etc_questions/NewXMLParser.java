/*
 * The MIT License
 *
 * Copyright 2020 Brion Lang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ewoner.jcac_etc_questions;

import com.ewoner.JavaLoggers.TextAreaLogger.TextAreaLogger;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import com.ewoner.jcac_etc_questions.models.questions.types.QuestionMultipleChoice;
import com.ewoner.jcac_etc_questions.models.questions.types.QuestionMultipleChoiceSet;
import com.ewoner.jcac_etc_questions.models.text.Text;
import com.ewoner.jcac_etc_questions.models.text.TextFormatEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Brion Lang
 */
public class NewXMLParser {

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    static private Logger logger = Logger.getLogger(NewXMLParser.class.getName());
    static public void configerLogger( JTextArea textArea ) {
        logger = Logger.getLogger(TextAreaLogger.class.getName());
    }
    static public boolean parseBooleanDataAsNumber( XMLEventReader reader ) throws XMLStreamException {
        int intData;
        try {
            intData = Integer.parseInt( reader.nextEvent().asCharacters().getData() );
        } catch( NumberFormatException | NullPointerException ex ) {
            intData = 0;
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.WARNING, "Cannot parse an interager as an Boolean, using '0' aka FALSE" );
        }
        return ( 0 != intData );
    }

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    static public boolean parseBooleanData( XMLEventReader reader ) throws XMLStreamException {
        boolean data;
        try {
            data = Boolean.parseBoolean( reader.nextEvent().asCharacters().getData() );
        } catch( NumberFormatException | NullPointerException ex ) {
            data = true;
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.WARNING, "Cannot parse an Boolean, using 'FALSE'" );
        }
        return data;
    }

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    static public Double parseNumberData( XMLEventReader reader ) throws XMLStreamException {
        double data;
        try {
            data = Double.parseDouble( reader.nextEvent().asCharacters().getData() );
        } catch( NumberFormatException | NullPointerException ex ) {
            data = 0.0;
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.WARNING, "Cannot parse a number/double, using '0.0'" );
        }
        return data;
    }

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    static public String parseStringData( XMLEventReader reader ) throws XMLStreamException {
        String data = "";
        XMLEvent event = reader.nextEvent();
        if( event.isCharacters() ) {
            data = event.asCharacters().getData();
        }
        return data;
    }

    /**
     *
     * @param ele
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    static public Text parseTextXML( StartElement ele, XMLEventReader reader ) throws XMLStreamException {
        Text t = new Text();
        XMLEvent event;
        TextFormatEnum formatType;
        try {
            //ele.getAttributeByName() will be NULL if there is no attribute namded "format".
            formatType = TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() );
        } catch( NullPointerException ex ) {
            formatType = TextFormatEnum.NONE;
        }
        t.setFormat( formatType );
        reader.nextTag();
        event = reader.nextEvent();
        if( event.isCharacters() ) {
            t.setText( event.asCharacters().getData() );
        }
        return t;
    }

    static private Method getSetterMethod( Question q, String dataMemberName ) {
        Method setterMethod = null;
        String methodName = "set" + dataMemberName.substring( 0, 1 ).toUpperCase() + dataMemberName.substring( 1 );
        for( Method method : q.getClass().getMethods() ) {
            if( method.getName().equals( methodName ) ) {
                setterMethod = method;
                break;
            }
        }
        if( setterMethod == null ) {
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, "Cannot find setter {0}", methodName );
        }
        return setterMethod;
    }

    static private void runSetterMethod( Question q, String dataMemberName, boolean value ) {
        Method methodToRun = getSetterMethod( q, dataMemberName );
        if( methodToRun != null ) {
            try {
                methodToRun.invoke( value );
            } catch( IllegalAccessException | InvocationTargetException ex ) {
                Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, "Tried to Run a method that does not exists or is private!" );
            }
        }
    }

    private static void runSetterMethod( Question q, String dataMemberName, double value ) {
        Method methodToRun = getSetterMethod( q, dataMemberName );
        if( methodToRun != null ) {
            try {
                methodToRun.invoke( value );
            } catch( IllegalAccessException | InvocationTargetException ex ) {
                Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, "Tried to Run a method that does not exists or is private!" );
            }
        }
    }

    private static void runSetterMethod( Question q, String dataMemberName, String value ) {
        Method methodToRun = getSetterMethod( q, dataMemberName );
        if( methodToRun != null ) {
            try {
                methodToRun.invoke( value );
            } catch( IllegalAccessException | InvocationTargetException ex ) {
                Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, "Tried to Run a method that does not exists or is private!" );
            }
        }
    }

    /**
     *
     * @param filename
     * @return
     */
    public static List<Question> parseXMLfile( String filename ) {
        File file = new File( filename );
        if( file.exists() ) {
            return parseXMLfile( file );
        } else {
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, null, "Could not open XML file to Parse." );
        }
        return null;
    }

    /**
     *
     * @param file
     * @return
     */
    public static List<Question> parseXMLfile( File file ) {
        List<Question> questions = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader( new FileInputStream( file ) );
            while( reader.hasNext() ) {
                if( reader.peek().isStartElement() ) {
                    if( reader.peek().asStartElement().getName().getLocalPart().equals( "question" ) ) {
                        String attType = reader.nextEvent().asStartElement().getAttributeByName( new QName( "type" ) ).getValue();
                        switch( attType ) {
                            case "category":
                                break;
                            case "truefalse":
                                break;
                            case "multichoice":
                                questions.add( new QuestionMultipleChoice().parseXMLQuestion( reader ) );
                                break;
                            case "multichoiceset":
                                questions.add( new QuestionMultipleChoiceSet().parseXMLQuestion( reader ) );
                                break;
                            default:
                                break;
                        }
                    }
                }
                reader.next();
            }
        } catch( FileNotFoundException | XMLStreamException ex ) {
            Logger.getLogger( NewXMLParser.class.getName() ).log( Level.SEVERE, null, ex );
            return null;
        }
        return questions;
    }

    /**
     *
     * @param tagName
     * @param value
     * @return
     */
    public static String doubleToXML( String tagName, Double value ) {
        return "<" + tagName + ">" + value + "</" + tagName + ">";
    }

    /**
     *
     * @param tagName
     * @param value
     * @return
     */
    public static String boolNumberToXML( String tagName, boolean value ) {
        int numValue = value ? 1 : 0;
        return "<" + tagName + ">" + numValue + "</" + tagName + ">";
    }

    /**
     *
     * @param tagName
     * @param value
     * @return
     */
    public static String boolToXML( String tagName, boolean value ) {
        return "<" + tagName + ">" + value + "</" + tagName + ">";
    }

    /**
     *
     * @param tagName
     * @param value
     * @return
     */
    public static String stringToXML( String tagName, String value ) {
        return "<" + tagName + ">" + value + "</" + tagName + ">";
    }

    private NewXMLParser() {

    }
}
