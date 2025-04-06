package com.ewoner.java_etc_questions.converters;

import com.ewoner.java_etc_questions.models.answers.abstracts.Answer;
import com.ewoner.java_etc_questions.models.answers.abstracts.Answer_Feedback;
import com.ewoner.java_etc_questions.models.questions.MultiChoice;
import com.ewoner.java_etc_questions.models.questions.MultiChoiceSet;
import com.ewoner.java_etc_questions.models.questions.ShortAnswer;
import com.ewoner.java_etc_questions.models.questions.TrueFalse;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class QuestionCSVConverter {

    private String filename;
    private File file;
    private FileReader reader;

    public QuestionCSVConverter() {
        this( null );
    }

    public QuestionCSVConverter( String filename ) {
        this.filename = filename;
        setReader();
    }

    public boolean saveCSVFile( String filename, QuestionTypeEnum type, List<Question> questions ) {
        boolean itWorked = true;
        File saveFile = null;
        boolean badFilename = true;
        while ( badFilename ) {
            badFilename = false;
            if ( !( filename == null || filename.isBlank() ) ) {
                saveFile = new File( filename );
            }
            if ( saveFile == null || saveFile.exists() ) {
                int result = JOptionPane.showConfirmDialog( null, "File '" + filename + "' already exists.  Overwrite?" );
                if ( result == JOptionPane.NO_OPTION ) {
                    filename = JOptionPane.showInputDialog( "Eneter filename for save file: " );
                    badFilename = true;
                } else if ( result == JOptionPane.CANCEL_OPTION ) {
                    return false;
                }
            }
        }
        PrintWriter writer;
        try {
            writer = new PrintWriter( new FileOutputStream( saveFile ) );
        } catch ( FileNotFoundException ex ) {
            Logger.getLogger( QuestionCSVConverter.class.getName() ).log( Level.SEVERE, null, ex );
            return false;
        }
        writer.println( getCSVHeader( type ) );
        for ( Question q : questions ) {
            if ( q.getType() == type ) {
                writer.println( toCSV( type, q ) );
            }
        }
        writer.close();
        return itWorked;
    }

    private void setReader() {
        if ( filename == null || filename.isBlank() ) {
            reader = null;
        } else {
            file = new File( filename );
            if ( file.exists() ) {
                try {
                    reader = new FileReader( file );
                } catch ( FileNotFoundException ex ) {
                    Logger.getLogger( QuestionCSVConverter.class.getName() ).log( Level.SEVERE, "Cound not open file to read: {0}", filename );
                }
            }
        }
    }

    public String toCSV( Question question ) {
        String csvStr = addComma( question.getId() );
        csvStr += addComma( question.getName() );
        csvStr += addComma( question.getText() );
        csvStr += addComma( question.getGeneralFB() );
        csvStr += addComma( question.getDefaultGrade() );
        csvStr += addComma( question.getPenalty() );
        csvStr += addComma( question.isHidden() );
        csvStr += addComma( question.getIdNumber() );
        return csvStr;
    }

    public String getCSVHeader( Question question ) {
        String csvStr = addComma( "MODDLE ID" );
        csvStr += addComma( "NAME" );
        csvStr += addComma( "QUESTION TEXT" );
        csvStr += addComma( "GENERAL FEEDBACK" );
        csvStr += addComma( "DEFAULT GRADE" );
        csvStr += addComma( "PENLTY" );
        csvStr += addComma( "IS HIDDEN" );
        csvStr += addComma( "JCAC ID" );
        return csvStr;
    }

    public String getCSVHeader( TrueFalse question ) {
        String csvStr = getCSVHeader( ( Question ) question );
        csvStr += addComma( "QUESTION ANSWER" );
        csvStr += addComma( "FEEDBACK FOR TRUE" );
        csvStr += addComma( "FEEDBACK FOR FALSE" );
        return csvStr;
    }

    public String toCSV( TrueFalse question ) {
        String csvStr = toCSV( ( Question ) question );
        csvStr += addComma( question.getAnswer() );
        csvStr += addComma( question.getTrueFB() );
        csvStr += addComma( question.getFalseFB() );
        return csvStr;
    }

    public String toCSV( ShortAnswer question ) {
        String csvStr = toCSV( ( Question ) question );
        csvStr += addComma( question.isUsecase() );
        csvStr += addComma( question.numAnswers() );
        for ( Answer a : question.getAnswers() ) {
            Answer_Feedback answer = ( Answer_Feedback ) a;
            csvStr += addComma( answer.getText() );
            csvStr += addComma( answer.getFraction() );
            csvStr += addComma( answer.getFeedback() );
        }
        return csvStr;
    }

    public String getCSVHeader( ShortAnswer question ) {
        String csvStr = getCSVHeader( ( Question ) question );
        csvStr += addComma( "CASE SENSITIVITY" );
        csvStr += addComma( "NUM OF ANSWERS" );
        for ( int count = 1; count <= 10; count++ ) {
            csvStr += addComma( "ANSWER " + count + " TEXT" );
            csvStr += addComma( "ANSWER " + count + " FRACTION" );
            csvStr += addComma( "ANSWER " + count + " FEEDBACK" );
        }
        return csvStr;
    }

    private String addComma( Object obj ) {
        return String.format( "%s,", "" + obj );
    }

    private String addComma( String str ) {
        return String.format( "\"%s\",", str );
    }

    private String toCSV( QuestionTypeEnum type, Question q ) {
        switch ( type ) {
            case ShortAnswer:
                return toCSV( ( ShortAnswer ) q );
            case MultipleChoice:
                return toCSV( ( MultiChoice ) q );
            case MultipleChoice_AllorNothing:
                return toCSV( ( MultiChoiceSet ) q );
            case TrueFalse:
                return toCSV( ( TrueFalse ) q );
        }
        return null;
    }

    private String getCSVHeader( QuestionTypeEnum type ) {
        switch ( type ) {
            case TrueFalse:
                return getCSVHeader( new TrueFalse() );
            case ShortAnswer:
                return getCSVHeader( new ShortAnswer() );
            default:
                return getCSVHeader( ( Question ) new TrueFalse() );
        }
    }
}
