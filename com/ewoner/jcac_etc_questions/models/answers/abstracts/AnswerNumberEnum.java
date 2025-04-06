
package com.ewoner.java_etc_questions.models.answers.abstracts;

/**
 *
 * @author student
 */
public enum AnswerNumberEnum {
    none,
    abc,
    ABCD,
    _123("123");
    
    private final String xmlValue;
    private AnswerNumberEnum(){
        xmlValue = this.name();
    }
    private AnswerNumberEnum( String value ) {
        xmlValue = value;
    }
}
