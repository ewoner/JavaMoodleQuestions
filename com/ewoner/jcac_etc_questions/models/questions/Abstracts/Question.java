package com.ewoner.java_etc_questions.models.questions.abstracts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Question {

    private QuestionTypeEnum type;

    private int id;

    private double defaultGrade;
    private String generalFB;
    private boolean hidden;
    private String idNumber;
    private String name;
    private double penalty;
    private String text;
    private List<String> tags;

    private Question() {
        this( QuestionTypeEnum.NONE, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question( QuestionTypeEnum type ) {
        this( type, 0, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question( QuestionTypeEnum type, int id ) {
        this( type, id, "QUESTION NAME", "QUESTION TEXT", "GENERALFEEDBACK TEXT" );
    }

    public Question( QuestionTypeEnum type, int id, String name, String text ) {
        this( type, id, name, text, "" );
    }

    public Question( QuestionTypeEnum type, String name, String text ) {
        this( type, 0, name, text, "" );
    }

    public Question( QuestionTypeEnum type, String name, String text, String generalFB ) {
        this( type, 0, name, text, generalFB );
    }

    public Question( QuestionTypeEnum type, int id, String name, String text, String generalFB ) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.text = text;
        this.generalFB = generalFB;
        this.hidden = false;
        this.idNumber = "";
        this.penalty = 1.0;
        this.defaultGrade = 1.0;
        this.tags = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText( String text ) {
        this.text = text;
    }

    /**
     * @return the generalFB
     */
    public String getGeneralFB() {
        return generalFB;
    }

    /**
     * @param generalFB the generalFB to set
     */
    public void setGeneralFB( String generalFB ) {
        this.generalFB = generalFB;
    }

    /**
     * @return the defaultGrade
     */
    public double getDefaultGrade() {
        return defaultGrade;
    }

    /**
     * @param defaultGrade the defaultGrade to set
     */
    public void setDefaultGrade( double defaultGrade ) {
        this.defaultGrade = defaultGrade;
    }

    /**
     * @return the penalty
     */
    public double getPenalty() {
        return penalty;
    }

    /**
     * @param penalty the penalty to set
     */
    public void setPenalty( double penalty ) {
        this.penalty = penalty;
    }

    /**
     * @return the hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden the hidden to set
     */
    public void setHidden( boolean hidden ) {
        this.hidden = hidden;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber( String idNumber ) {
        this.idNumber = idNumber;
    }

    /**
     * @return the type
     */
    public QuestionTypeEnum getType() {
        return type;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
        return Collections.unmodifiableList( tags );
    }

    /**
     * s to set
     *
     * @param tag
     */
    public void addTag( String tag ) {
        tags.add( tag );
    }

    public void removeTag( String tag ) {
        tags.remove( tag );
    }

    public void clearAllTags() {
        tags.clear();
    }

    public boolean containsTag( String tag ) {
        return tags.contains( tag );
    }

    public String getTag( int index ) {
        return tags.get( index );
    }

    public int getTagIndex( String tag ) {
        return tags.indexOf( tag );
    }
    public boolean hasTags(){
        return ! tags.isEmpty();
    }
    public int numOfTags(){
        return tags.size();
    }
}
