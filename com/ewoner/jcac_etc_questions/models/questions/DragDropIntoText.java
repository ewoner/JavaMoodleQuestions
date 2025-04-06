package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.answers.DragBox;
import com.ewoner.java_etc_questions.models.answers.abstracts.MultiAnswerQuestion;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question_PartialCredit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DragDropIntoText extends Question_PartialCredit implements MultiAnswerQuestion<DragBox> {

    List<DragBox> answers;

    public DragDropIntoText() {
        this( 0 );
    }

    public DragDropIntoText( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public DragDropIntoText( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public DragDropIntoText( String name, String text ) {
        this( 0, name, text, "" );
    }

    public DragDropIntoText( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public DragDropIntoText( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.DragAndDropIntoText, id, name, text, generalFB );
        answers = new ArrayList<>();
    }

    @Override
    public boolean addAnswer( DragBox a ) {
        return answers.add( a );
    }

    @Override
    public void clearAllAnswers() {
        answers.clear();
    }

    @Override
    public boolean containsAnswer( DragBox a ) {
        return answers.contains( a );
    }

    @Override
    public DragBox getAnswer( int index ) {
        return answers.get( index );
    }

    @Override
    public int indexOfAnswer( DragBox a ) {
        return answers.indexOf( a );
    }

    @Override
    public boolean hasAnswers() {
        return !answers.isEmpty();
    }

    @Override
    public boolean remove( DragBox a ) {
        return answers.remove( a );
    }

    @Override
    public int numAnswers() {
        return answers.size();
    }

    @Override
    public List<DragBox> getAnswers() {
        return Collections.unmodifiableList( answers );
    }

}
