package com.ewoner.java_etc_questions.models.questions.abstracts;

import com.ewoner.java_etc_questions.models.answers.FractionalAnswer;
import com.ewoner.java_etc_questions.models.answers.abstracts.MultiAnswerQuestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MultipleChoiceQuestion extends Question_PartialCredit implements MultiAnswerQuestion<FractionalAnswer> {

    private List<FractionalAnswer> answers;
    private boolean shuffleAnswers;
    private boolean showCorrect;

    private MultipleChoiceQuestion() {
        this( QuestionTypeEnum.NONE, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type ) {
        this( type, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type, int id ) {
        this( type, id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type, int id, String name, String text ) {
        this( type, id, name, text, "" );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type, String name, String text ) {
        this( type, 0, name, text, "" );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type, String name, String text, String generalFB ) {
        this( type, 0, name, text, generalFB );
    }

    public MultipleChoiceQuestion( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        super( type, id, name, text, generalFB );
        answers = new ArrayList<>();
        this.shuffleAnswers = true;
        this.showCorrect = true;
    }

    /**
     * @return the shuffleAnswers
     */
    public boolean isShuffleAnswers() {
        return shuffleAnswers;
    }

    /**
     * @param shuffleAnswers the shuffleAnswers to set
     */
    public void setShuffleAnswers( boolean shuffleAnswers ) {
        this.shuffleAnswers = shuffleAnswers;
    }

    /**
     * @param partiallyFB the partiallyFB to set
     */
    public void setPartiallyFB( String partiallyFB ) {
        throw new java.lang.IllegalArgumentException( "This class does support partiacl credit." );
    }

    @Override
    public FractionalAnswer getAnswer( int index ) {
        return answers.get( index );
    }

    @Override
    public boolean hasAnswers() {
        return answers.isEmpty() == false;
    }

    @Override
    public int numAnswers() {
        return answers.size();
    }

    @Override
    public boolean addAnswer( FractionalAnswer a ) {
        return answers.add( a );
    }

    @Override
    public void clearAllAnswers() {
        answers.clear();
    }

    @Override
    public boolean containsAnswer( FractionalAnswer a ) {
        return answers.contains( a );
    }

    @Override
    public int indexOfAnswer( FractionalAnswer a ) {
        return answers.indexOf( a );
    }

    @Override
    public boolean remove( FractionalAnswer a ) {
        return answers.remove( a );
    }

    @Override
    public List<FractionalAnswer> getAnswers() {
        return Collections.unmodifiableList( answers );
    }

    /**
     * @return the showCorrect
     */
    public boolean isShowCorrect() {
        return showCorrect;
    }

    /**
     * @param showCorrect the showCorrect to set
     */
    public void setShowCorrect( boolean showCorrect ) {
        this.showCorrect = showCorrect;
    }

}
