package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

import com.ewoner.jcac_etc_questions.models.text.Text;

/**
 * @author Brion Lang
 * @date 20 July 2022
 * @version 0.0.0
 */
public abstract class Question implements QuestionParser {

    private Text name;
    private Text questiontext;
    private QuestionTypeEnum type;
    private String idnumber;
    private double defaultgrade;
    private double penalty;
    private boolean hidden;
    private boolean showstandardinstruction;

    private Question( QuestionTypeEnum type ) {
        this( type, new Text(), new Text() );
    }

    /**
     *
     * @param type
     * @param name
     * @param questiontext
     */
    public Question( QuestionTypeEnum type, Text name, Text questiontext ) {
        this.type = type;
        this.name = name;
        this.questiontext = questiontext;

        this.idnumber = "";
        defaultgrade = 0.0;
        penalty = 1.0;
        hidden = true;
    }

    private Question() {
        this( QuestionTypeEnum.NONE, new Text(), new Text() );

    }

    /**
     *
     * @return
     */
    public Text getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName( Text name ) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Text getQuestiontext() {
        return questiontext;
    }

    /**
     *
     * @param questiontext
     */
    public void setQuestiontext( Text questiontext ) {
        this.questiontext = questiontext;
    }

    /**
     *
     * @return
     */
    public QuestionTypeEnum getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType( QuestionTypeEnum type ) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     *
     * @param idnumber
     */
    public void setIdnumber( String idnumber ) {
        this.idnumber = idnumber;
    }

    /**
     *
     * @return
     */
    public double getPenalty() {
        return penalty;
    }

    /**
     *
     * @param penalty
     */
    public void setPenalty( double penalty ) {
        this.penalty = penalty;
    }

    /**
     *
     * @return
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     *
     * @param hidden
     */
    public void setHidden( boolean hidden ) {
        this.hidden = hidden;
    }

    /**
     * @return the defaultgrade
     */
    public double getDefaultgrade() {
        return defaultgrade;
    }

    /**
     * @param defaultgrade the defaultgrade to set
     */
    public void setDefaultgrade( double defaultgrade ) {
        this.defaultgrade = defaultgrade;
    }

    /**
     * @return the showstandardinstruction
     */
    public boolean isShowstandardinstruction() {
        return showstandardinstruction;
    }

    /**
     * @param showstandardinstruction the showstandardinstruction to set
     */
    public void setShowstandardinstruction( boolean showstandardinstruction ) {
        this.showstandardinstruction = showstandardinstruction;
    }

}
