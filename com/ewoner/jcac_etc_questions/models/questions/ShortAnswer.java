package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.questions.abstracts.Hint;
import com.ewoner.java_etc_questions.models.questions.abstracts.MultipleChoiceQuestion;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;

public class ShortAnswer extends MultipleChoiceQuestion {

    private boolean usecase;

    public ShortAnswer() {
        this( 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public ShortAnswer( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public ShortAnswer( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public ShortAnswer( String name, String text ) {
        this( 0, name, text, "" );
    }

    public ShortAnswer( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public ShortAnswer( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.ShortAnswer, id, name, text, generalFB );
        usecase = false;
    }

    /**
     * @return the usecase
     */
    public boolean isUsecase() {
        return usecase;
    }

    /**
     * @param usecase the usecase to set
     */
    public void setUsecase( boolean usecase ) {
        this.usecase = usecase;
    }

    /**
     *
     * @param hint
     */
    @Override
    public void addHint( Hint hint ) {
        hint.setClearWrong( false );
        hint.setShowSelectedFeedback( false );
        hint.setClearWrong( false );
        super.addHint( hint );
    }

}
