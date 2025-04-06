package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.answers.abstracts.AnswerNumberEnum;
import com.ewoner.java_etc_questions.models.questions.abstracts.MultipleChoiceQuestion;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;

public class MultiChoiceSet extends MultipleChoiceQuestion {

    private AnswerNumberEnum numbering;
    private boolean showInstructions;

    public MultiChoiceSet() {
        this( 0 );
    }

    public MultiChoiceSet( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultiChoiceSet( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public MultiChoiceSet( String name, String text ) {
        this( 0, name, text, "" );
    }

    public MultiChoiceSet( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public MultiChoiceSet( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.MultipleChoice_AllorNothing, id, name, text, generalFB );
        showInstructions = true;
        numbering = AnswerNumberEnum.ABCD;
    }

    protected MultiChoiceSet( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.MultipleChoice_AllorNothing, id, name, text, generalFB );
        showInstructions = true;
        numbering = AnswerNumberEnum.ABCD;
    }

    /**
     * @return the numbering
     */
    public AnswerNumberEnum getNumbering() {
        return numbering;
    }

    /**
     * @param numbering the numbering to set
     */
    public void setNumbering( AnswerNumberEnum numbering ) {
        this.numbering = numbering;
    }

    /**
     * @return the showInstructions
     */
    public boolean isShowInstructions() {
        return showInstructions;
    }

    /**
     * @param showInstructions the showInstructions to set
     */
    public void setShowInstructions( boolean showInstructions ) {
        this.showInstructions = showInstructions;
    }

}
