package com.ewoner.java_etc_questions.models.answers.abstracts;

import java.util.List;

public interface MultiAnswerQuestion<A extends Answer> {

    public boolean addAnswer( A a );

    public void clearAllAnswers();

    public boolean containsAnswer( A a );

    public A getAnswer( int index );

    public int indexOfAnswer( A a );

    public boolean hasAnswers();

    public boolean remove( A a );

    public int numAnswers();

    public List<A> getAnswers();
}
