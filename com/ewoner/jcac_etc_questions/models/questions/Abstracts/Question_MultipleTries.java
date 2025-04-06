package com.ewoner.java_etc_questions.models.questions.abstracts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ewone
 */
public abstract class Question_MultipleTries extends Question {

    private List<Hint> hints;

    private Question_MultipleTries() {
        this( QuestionTypeEnum.NONE, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question_MultipleTries( QuestionTypeEnum type ) {
        this( type, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question_MultipleTries( QuestionTypeEnum type, int id ) {
        this( type, id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question_MultipleTries( QuestionTypeEnum type, int id, String name, String text ) {
        this( type, id, name, text, "" );
    }

    public Question_MultipleTries( QuestionTypeEnum type, String name, String text ) {
        this( type, 0, name, text, "" );
    }

    public Question_MultipleTries( QuestionTypeEnum type, String name, String text, String generalFB ) {
        this( type, 0, name, text, generalFB );
    }

    public Question_MultipleTries( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        super( type, 0, name, text, generalFB );
        hints = new ArrayList<>();
    }

    public List<Hint> getHints() {
        return Collections.unmodifiableList( hints );
    }

    /**
     * s to set
     *
     * @param hint
     */
    public void addHint( Hint hint ) {
        hints.add( hint );
    }

    public void removeHint( Hint hint ) {
        hints.remove( hint );
    }

    public void clearAllHints() {
        hints.clear();
    }

    public boolean containsHint( Hint hint ) {
        return hints.contains( hint );
    }

    public Hint getHint( int index ) {
        return hints.get( index );
    }

    public int getHintIndex( String hint ) {
        return hints.indexOf( hint );
    }

    public boolean hasHints() {
        return !hints.isEmpty();
    }

    public int numOfHints() {
        return hints.size();
    }
}
