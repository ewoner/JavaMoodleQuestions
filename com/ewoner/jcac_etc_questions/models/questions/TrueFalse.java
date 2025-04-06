package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;

/**
 *
 * @author student
 */
public class TrueFalse extends Question {

    private boolean answer = true;
    private String trueFB;
    private String falseFB;
    
    public TrueFalse() {
        this( 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public TrueFalse( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public TrueFalse(  int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public TrueFalse( String name, String text ) {
        this( 0, name, text, "" );
    }

    public TrueFalse( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public TrueFalse( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.TrueFalse, id, name, text, generalFB );
        answer = true;
        trueFB = "";
        falseFB = "";
    }

    /**
     * @return the answer
     */
    public boolean getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer( boolean answer ) {
        this.answer = answer;
    }

    public void setAnswerFalse() {
        setAnswer( false );
    }

    public void setAnswerTrue() {
        setAnswer( true );
    }
    
    public String getTrueFB() {
        return trueFB;
    }
    
    public void setTrueFB( String answerFB ) {
        this.trueFB = answerFB;
    }
    
    public String getFalseFB() {
        return falseFB;
    }
    
    public void setFalseFB( String falseFB ) {
        this.falseFB = falseFB;
    }
}
