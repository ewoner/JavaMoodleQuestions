package com.ewoner.java_etc_questions.models.questions;

import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;

public class DragAndDropMatching extends Matching {
    public DragAndDropMatching() {
        this( 0 );
    }

    public DragAndDropMatching( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public DragAndDropMatching( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public DragAndDropMatching( String name, String text ) {
        this( 0, name, text, "" );
    }

    public DragAndDropMatching( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public DragAndDropMatching( int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.DragAndDropMatching, id, name, text, generalFB );
        
    }
}
