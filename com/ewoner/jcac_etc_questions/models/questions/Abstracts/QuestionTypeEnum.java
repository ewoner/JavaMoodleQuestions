package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

/**
 *
 * @author student
 */
public enum QuestionTypeEnum {

    /**
     *
     */
    MultipleChoice, 

    /**
     *
     */
    MultipleChoiceSet( "multichoiceset" ),/* Done */

    /**
     *
     */

    TrueFalse,

    /**
     *
     */
    ShortAnswer,

    /**
     *
     */
    NumericalResponse,

    /**
     *
     */
    Matching,

    /**
     *
     */
    Essay,

    /**
     *
     */
    Cloze,

    /**
     *
     */
    DescriptionResonse,

    /**
     *
     */
    RandomMatching,

    /**
     *
     */
    Category,

    /**
     *
     */
    NONE;

    private final String xmlString;

    private QuestionTypeEnum() {
        xmlString = this.name().toLowerCase();
    }

    private QuestionTypeEnum( String xmlString ) {
        this.xmlString = xmlString.toLowerCase();
    }

    /**
     *
     * @return
     */
    public String getXMLString() {
        return this.xmlString;
    }
}
