package com.ewoner.java_etc_questions.models.questions.abstracts;

import com.ewoner.java_etc_questions.models.answers.abstracts.Answer;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author student
 * @param <T>
 */
public interface MultiAnswerContainer<T extends Answer> {

    boolean addAnswer( T answer );

    boolean addAllAnswers( Collection<? extends T> c );

    void clear();

    T getAnswer( int index );

    boolean hasAnswers();

    T removeAnswer( int index );

    int numAnswers();

    T[] answersToArray();

    List<T> AnswersToList();
    
}
