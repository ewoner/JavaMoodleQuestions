package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;


public class MultiChoice extends MultiChoiceSet {
    
    private boolean single;
    
    public MultiChoice() {
        this( 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultiChoice( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultiChoice( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public MultiChoice( String name, String text ) {
        this( 0, name, text, "" );
    }

    public MultiChoice( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public MultiChoice( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.MultipleChoice, id, name, text, generalFB );
       single = false;
    }

    /**
     * @return the single
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * @param single the single to set
     */
    public void setSingle( boolean single ) {
        this.single = single;
    }
    
}
