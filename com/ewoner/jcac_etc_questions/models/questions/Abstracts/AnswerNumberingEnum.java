package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

/**
 *
 * @author student
 */
public enum AnswerNumberingEnum {

    /**
     *
     */
    none( "none" ),

    /**
     *
     */
    abc( "abc" ),

    /**
     *
     */
    ABCD( "ABCD" ),

    /**
     *
     */
    numbers( "123" );

    AnswerNumberingEnum( String xmlValue ) {
        this.xmlValue = xmlValue;
    }

    private final String xmlValue;

    /**
     *
     * @return
     */
    public String getXML() {
        return xmlValue;
    }
}