/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ewoner.java_etc_questions.models.questions.abstracts;

import java.util.ArrayList;

/**
 *
 * @author ewone
 */
public abstract class Question_PartialCredit extends Question_MultipleTries {

    private boolean shuffleanswers;
    private String CorrectFB;
    private String partialFB;
    private String incorrectFB;
    private boolean showNumCorrect;

    public Question_PartialCredit() {
        this( 0 );
    }

    public Question_PartialCredit( int id ) {
        this( id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question_PartialCredit( int id, String name, String text ) {
        this( id, name, text, "" );
    }

    public Question_PartialCredit( String name, String text ) {
        this( 0, name, text, "" );
    }

    public Question_PartialCredit( String name, String text, String generalFB ) {
        this( 0, name, text, generalFB );
    }

    public Question_PartialCredit( int id, String name, String text, String generalFB ) {
        this( QuestionTypeEnum.NONE, id, name, text, generalFB );
    }

    public Question_PartialCredit( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        super( QuestionTypeEnum.Matching, id, name, text, generalFB );
        shuffleanswers = true;
        CorrectFB = "Your answer is correct.";
        partialFB = "Your answer is partially correct.";
        incorrectFB = "Your answer is incorrect.";
        showNumCorrect = true;
    }

    /**
     * @return the shuffleanswers
     */
    public boolean isShuffleanswers() {
        return shuffleanswers;
    }

    /**
     * @param shuffleanswers the shuffleanswers to set
     */
    public void setShuffleanswers( boolean shuffleanswers ) {
        this.shuffleanswers = shuffleanswers;
    }

    /**
     * @return the CorrectFB
     */
    public String getCorrectFB() {
        return CorrectFB;
    }

    /**
     * @param CorrectFB the CorrectFB to set
     */
    public void setCorrectFB( String CorrectFB ) {
        this.CorrectFB = CorrectFB;
    }

    /**
     * @return the partialFB
     */
    public String getPartialFB() {
        return partialFB;
    }

    /**
     * @param partialFB the partialFB to set
     */
    public void setPartialFB( String partialFB ) {
        this.partialFB = partialFB;
    }

    /**
     * @return the incorrectFB
     */
    public String getIncorrectFB() {
        return incorrectFB;
    }

    /**
     * @param incorrectFB the incorrectFB to set
     */
    public void setIncorrectFB( String incorrectFB ) {
        this.incorrectFB = incorrectFB;
    }

    /**
     * @return the showNumCorrect
     */
    public boolean isShowNumCorrect() {
        return showNumCorrect;
    }

    /**
     * @param showNumCorrect the showNumCorrect to set
     */
    public void setShowNumCorrect( boolean showNumCorrect ) {
        this.showNumCorrect = showNumCorrect;
    }
}
