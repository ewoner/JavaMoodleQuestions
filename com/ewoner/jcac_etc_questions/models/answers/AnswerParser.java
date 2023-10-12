package com.ewoner.jcac_etc_questions.models.answers;

import com.ewoner.jcac_etc_questions.models.answers.Answer;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author student
 */
public interface AnswerParser{

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    public Answer parseXMLAnswer( XMLEventReader reader ) throws XMLStreamException;

    /**
     *
     * @return
     */
    public String toXMLString();
}
