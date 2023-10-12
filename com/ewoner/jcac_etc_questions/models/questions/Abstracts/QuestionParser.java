package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author student
 */
public interface QuestionParser {

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    public Question parseXMLQuestion( XMLEventReader reader ) throws XMLStreamException;

    /**
     *
     * @return
     */
    public String toXMLString();
}
