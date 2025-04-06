package com.ewoner.java_etc_questions.models.answers.abstracts;

/**
 *
 * @author student
 */
public class Answer_Feedback extends Answer{

    private double fraction;
    private String feedback;

    public Answer_Feedback(){
        this("", 100.0, "");
    }
    public Answer_Feedback(String text ){
        this(text, 100.0, "");
    }
    public Answer_Feedback (String text, double fraction ){
        this( text, fraction , "" );
    }
    public Answer_Feedback( String text, double fraction, String feedback ){
        super( AnswerTypeEnum.WithFeedback, text);
        this.fraction = fraction;
        this.feedback = feedback;
    }

    /**
     * @return the fraction
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * @param fraction the fraction to set
     */
    public void setFraction( double fraction ) {
        this.fraction = fraction;
    }

    /**
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback( String feedback ) {
        this.feedback = feedback;
    }

}