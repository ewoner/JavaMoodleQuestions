package com.ewoner.java_etc_questions.models.answers;

import com.ewoner.java_etc_questions.models.answers.abstracts.Answer;
import com.ewoner.java_etc_questions.models.answers.abstracts.AnswerTypeEnum;

/**
 *
 * @author ewone
 */
public class Subquestion extends Answer {

    private String question;

    public Subquestion( String question, String answer ) {
        super( AnswerTypeEnum.Subquestion, answer );
        if ( question == null ) {
            question = "";
        } this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestin( String question ) {
        if ( question == null ) {
            question = "";
        }
        this.question = question;
    }

}
