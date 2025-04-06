
package com.ewoner.java_etc_questions.models.answers.abstracts;

public abstract class Answer {

    private AnswerTypeEnum type;
    private String text;
    
    private Answer(){
        this( AnswerTypeEnum.NONE);
    }
    public Answer( AnswerTypeEnum type){
        this( type, "ANSWER TEXT");
    }
    public Answer( AnswerTypeEnum type, String text ){
        this.type = type;
        this.text = text;
    }

    /**
     * @return the type
     */
    public AnswerTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( AnswerTypeEnum type ) {
        this.type = type;
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
}
