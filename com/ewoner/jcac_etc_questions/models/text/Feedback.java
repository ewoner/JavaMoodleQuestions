
package com.ewoner.java_etc_questions.models.text;

/**
 *
 * @author student
 */
public class Feedback extends Text {
    private FeedbackTypeEnum type;

    public Feedback() {
      this("FEEDBACK TEXT", FeedbackTypeEnum.general);
    }
    public Feedback(String text ){
        this( text, FeedbackTypeEnum.general);
    }
    public Feedback(String text, FeedbackTypeEnum type ){
        setText( text );
        this.type = type;
        setTagName(type.toString().toLowerCase() );
    }
    
    public FeedbackTypeEnum getType(){
        return this.type;
    }
}