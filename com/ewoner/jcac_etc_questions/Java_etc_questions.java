package com.ewoner.java_etc_questions;

import com.ewoner.java_etc_questions.converters.QuestionCSVConverter;
import com.ewoner.java_etc_questions.converters.QuestionXMLConverter;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import java.io.File;
import java.util.List;

/**
 *
 * @author student
 */
public class Java_etc_questions {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        File file = new File( "src/test2.xml" );
        QuestionXMLConverter qc = new QuestionXMLConverter( file.getAbsolutePath() );
        QuestionCSVConverter qCSVc = new QuestionCSVConverter();
        List<Question> questions = qc.parseXMLFile();
        System.out.println( "It worked!\n" + file.getAbsolutePath() );
        System.out.println( "Questions is size: " + questions.size() );
        System.out.println( "Quesitons to still parse in File: " + ( qc.numQuestions - qc.numCategories - questions.size() ) );
        System.out.println( "Total Quesitons in File: " + ( qc.numQuestions - qc.numCategories ) );
        System.out.println( "Total Categories in file: " + qc.numCategories );
        System.out.println( "\n\n" );
        qCSVc.saveCSVFile( "shortanswer.csv", QuestionTypeEnum.ShortAnswer, questions );
        qCSVc.saveCSVFile( "mc.csv", QuestionTypeEnum.MultipleChoice, questions );
        qCSVc.saveCSVFile( "truefalse.csv", QuestionTypeEnum.TrueFalse, questions );
    }

}
