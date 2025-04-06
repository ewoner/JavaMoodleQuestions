/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewoner.java_etc_questions.editor;

import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on $(date), $(time)
 *
 * @author Brion
 * @param <Q>
 */
public class QuestionList<Q extends Question> {

    private ArrayList<Q> questionList;

    public QuestionList() {
        questionList = new ArrayList<>();
    }

    @SuppressWarnings( "unchecked" )
    public QuestionList( List<Question> list, QuestionTypeEnum type ) {
        this();
        for ( Question q : list ) {
            if ( q.getType() == type ) {
                this.add(( Q ) q);
            }
        }
    }

    public Question[] getList() {
        @SuppressWarnings( "unchecked" )
        Question a[] = ( new Question[ questionList.size() ] );
        questionList.toArray( a );
        return a;
    }

    public int indexOf( Q question ) {
        return questionList.indexOf( question );
    }

    public int size() {
        return questionList.size();
    }

    public void add( Q question ) {
        for ( var m : questionList ) {
            if ( m.equals( question ) ) {
                return;
            }
        }
        questionList.add( question );
    }

}
