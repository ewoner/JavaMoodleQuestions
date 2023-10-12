package com.ewoner.jcac_etc_questions.models.questions.types;

import com.ewoner.jcac_etc_questions.NewXMLParser;
import com.ewoner.jcac_etc_questions.models.answers.Answer;
import com.ewoner.jcac_etc_questions.models.feedback.Feedback;
import com.ewoner.jcac_etc_questions.models.feedback.FeedbackTypeEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.AnswerNumberingEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.QuestionTypeEnum;
import com.ewoner.jcac_etc_questions.models.text.Text;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author student
 */
public class QuestionMultipleChoice extends QuestionMultipleChoiceSet {

    private boolean single;
    private Feedback partiallycorrectfeedback;
    private boolean shownumcorrect;

    /**
     *
     */
    public QuestionMultipleChoice() {
        this( new Text(), new Text(), new Feedback(), new Feedback() );
    }

    /**
     *
     * @param name
     * @param text
     */
    public QuestionMultipleChoice( Text name, Text text ) {
        this( name, text, new Feedback(), new Feedback() );
    }

    /**
     *
     * @param name
     * @param text
     * @param correctfeedback
     */
    public QuestionMultipleChoice( Text name, Text text, Feedback correctfeedback ) {
        this( name, text, correctfeedback, new Feedback() );
    }

    /**
     *
     * @param name
     * @param text
     * @param correctfeedback
     * @param incorrectfeedback
     */
    public QuestionMultipleChoice( Text name, Text text,
            Feedback correctfeedback, Feedback incorrectfeedback ) {
        super( name, text, correctfeedback, incorrectfeedback );
        this.setType( QuestionTypeEnum.MultipleChoice);
        this.single = true;
        this.partiallycorrectfeedback = new Feedback();
        this.shownumcorrect = false;

    }

    /**
     * @return the single
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * @param single the single to set
     */
    public void setSingle( boolean single ) {
        this.single = single;
    }

    /**
     * @return the partiallycorrectfeedback
     */
    public Feedback getPartiallycorrectfeedback() {
        return partiallycorrectfeedback;
    }

    /**
     * @param partiallycorrectfeedback the partiallycorrectfeedback to set
     */
    public void setPartiallycorrectfeedback( Feedback partiallycorrectfeedback ) {
        this.partiallycorrectfeedback = partiallycorrectfeedback;
    }

    /**
     * @return the shownumcorrect
     */
    public boolean isShownumcorrect() {
        return shownumcorrect;
    }

    /**
     *
     * @param reader
     * @return
     * @throws XMLStreamException
     */
    @Override
    public Question parseXMLQuestion( XMLEventReader reader ) throws XMLStreamException {
        QuestionMultipleChoice q = new QuestionMultipleChoice();
        XMLEvent event = reader.nextEvent();
        while( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
            if( event.isStartElement() ) {
                StartElement ele = event.asStartElement();
                switch( ele.getName().getLocalPart() ) {
                    case "name":
                        q.setName( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "questiontext":
                        q.setQuestiontext( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "generalfeedback":
                        q.getGeneralfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "defaultgrade":
                        q.setDefaultgrade( NewXMLParser.parseNumberData( reader ) );
                        break;
                    case "penalty":
                        q.setPenalty( NewXMLParser.parseNumberData( reader ) );
                        break;
                    case "hidden":
                        q.setHidden( NewXMLParser.parseBooleanDataAsNumber( reader ) );
                        break;
                    case "single":
                        q.setSingle( NewXMLParser.parseBooleanData( reader ) );
                        break;
                    case "shownumcorrect":
                        q.setShownumcorrect( true );
                        break;
                    case "idnumber":
                        q.setIdnumber( NewXMLParser.parseStringData( reader ) );
                        break;
                    case "shuffleanswers":
                        q.setShuffeanswers(NewXMLParser.parseBooleanData( reader ) );
                        break;
                    case "correctfeedback":
                        q.getCorrectfeedback().setType( FeedbackTypeEnum.Correct );
                        q.getCorrectfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "partiallycorrectfeedback":
                        q.getPartiallycorrectfeedback().setType( FeedbackTypeEnum.Partial );
                        q.getPartiallycorrectfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "incorrectfeedback":
                        q.getIncorrectfeedback().setType( FeedbackTypeEnum.Incorrect );
                        q.getIncorrectfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "answernumbering":
                        try {
                        q.setAnswernumbering( AnswerNumberingEnum.valueOf( NewXMLParser.parseStringData( reader ) ) );
                    } catch( IllegalArgumentException illegalArgumentException ) {
                        q.setAnswernumbering( AnswerNumberingEnum.none );
                        Logger.getLogger( QuestionMultipleChoiceSet.class.getName() ).log( Level.WARNING, "AnswerNumbering not excepted, set to 'none'" );
                    }
                    break;
                    case "showstandardinstruction":
                        q.setShowstandardinstruction( NewXMLParser.parseBooleanDataAsNumber( reader ) );
                        break;
                    case "answer":
                        q.addAnswer( new Answer().parseXMLAnswer(reader, ele));
                        break;
                    default:
                        Logger.getLogger( QuestionMultipleChoice.class.getName() ).log( Level.WARNING, "Unknow tag " + ele.getName().getLocalPart() + " in Parsing question" );
                        break;
                }
            }
            event = reader.nextEvent();
        }
        return q;
    }

    /**defaultgrade
     * @param shownumcorrect the shownumcorrect to set
     */
    public void setShownumcorrect( boolean shownumcorrect ) {
        this.shownumcorrect = shownumcorrect;
    }

}
