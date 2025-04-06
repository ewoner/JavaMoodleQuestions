package com.ewoner.java_etc_questions.models.answers;

import com.ewoner.java_etc_questions.models.answers.abstracts.Answer;
import com.ewoner.java_etc_questions.models.answers.abstracts.AnswerTypeEnum;

public class DragBox extends Answer {

    private int group;
    private boolean infinite;

    public DragBox() {
        this( "ANSWER TEXT" );
    }
    public DragBox(String text ){
        this(text, 1 );
    }
    public DragBox(String text, int group){
        this( text, group, false);
    }
    public DragBox(String text, int group, boolean infinite){
        super(AnswerTypeEnum.DragBox, text);
        this.group = group;
        this.infinite = infinite;
    }

    /**
     * @return the group
     */
    public int getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup( int group ) {
        this.group = group;
    }

    /**
     * @return the infinite
     */
    public boolean isInfinite() {
        return infinite;
    }

    /**
     * @param infinite the infinite to set
     */
    public void setInfinite( boolean infinite ) {
        this.infinite = infinite;
    }
}
