package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.answers.Subquestion;
import com.ewoner.java_etc_questions.models.answers.abstracts.MultiAnswerQuestion;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question_PartialCredit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matching extends Question_PartialCredit implements MultiAnswerQuestion<Subquestion> {

    private List<Subquestion> answers;

    public Matching() {
        this( 0 );
    }

    public Matching( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Matching( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public Matching( String name, String text ) {
        this( 0, name, text, "" );
    }

    public Matching( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public Matching( int id, String name, String text, String generalFB ) {
        this( QuestionTypeEnum.Matching, id, name, text, generalFB );

    }

    protected Matching( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        super( type, id, name, text, generalFB );
        answers = new ArrayList<>();
    }

    @Override
    public boolean addAnswer( Subquestion answer ) {
        return this.answers.add( answer );
    }

    @Override
    public void clearAllAnswers() {
        answers.clear();
    }

    @Override
    public boolean containsAnswer( Subquestion answer ) {
        return answers.contains( answer );
    }

    @Override
    public Subquestion getAnswer( int index ) {
        return answers.get( index );
    }

    @Override
    public int indexOfAnswer( Subquestion answer ) {
        return answers.indexOf( answer );
    }

    @Override
    public boolean hasAnswers() {
        return !answers.isEmpty();
    }

    @Override
    public boolean remove( Subquestion answer ) {
        return answers.remove( answer );
    }

    @Override
    public int numAnswers() {
        return answers.size();
    }

    @Override
    public List<Subquestion> getAnswers() {
        return Collections.unmodifiableList( answers );
    }

}
