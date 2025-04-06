package com.ewoner.java_etc_questions.converters;

import com.ewoner.java_etc_questions.models.answers.abstracts.AnswerNumberEnum;
import com.ewoner.java_etc_questions.models.answers.abstracts.Answer_Feedback;
import com.ewoner.java_etc_questions.models.questions.MultiChoice;
import com.ewoner.java_etc_questions.models.questions.MultiChoiceSet;
import com.ewoner.java_etc_questions.models.questions.ShortAnswer;
import com.ewoner.java_etc_questions.models.questions.TrueFalse;
import com.ewoner.java_etc_questions.models.questions.abstracts.MultiAnswerContainer;
import com.ewoner.java_etc_questions.models.questions.abstracts.MultipleChoiceQuestion;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class QuestionXMLConverter {

    private XMLEventReader reader;
    private String filename;
    private File file;
    public int numQuestions = 0;
    public int numCategories = 0;

    public List<Question> parseXMLFile() {
        List<Question> questions = new ArrayList<>();
        Set<String> attTypesNotSupported = new TreeSet<>();
        if (reader != null) {
            try {
                while (reader.hasNext()) {
                    var peeked = reader.peek();
                    if (peeked.isStartElement()) {
                        if (peeked.asStartElement().getName().getLocalPart().equals("question")) {
                            numQuestions++;
                            String attType = reader.nextEvent().asStartElement().getAttributeByName(new QName("type")).getValue();
                            switch (attType) {
                                case "category":
                                    Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.INFO, "Parsing not yet supported: {0}", attType);
                                    attTypesNotSupported.add(attType);
                                    numCategories++;
                                    break;
                                case "truefalse":
                                    questions.add(parseXMLQuestion(QuestionTypeEnum.TrueFalse));
                                    break;
                                case "multichoice":
                                    questions.add(parseXMLQuestion(QuestionTypeEnum.MultipleChoice));
                                    break;
                                case "multichoiceset":
                                    questions.add(parseXMLQuestion(QuestionTypeEnum.MultipleChoice));
                                    break;
                                case "shortanswer":
                                    questions.add(parseXMLQuestion(QuestionTypeEnum.ShortAnswer));
                                    break;
                                default:
                                    Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.INFO, "Parsing not yet supported: {0}", attType);
                                    attTypesNotSupported.add(attType);
                                    break;
//                                    Logger.getLogger( QuestionXMLConverter.class.getName() ).log( Level.SEVERE, "Unknown Question type: {0}", attType );
//                                    break;
                            }
                        }
                    }
                    reader.next();

                }
            } catch (XMLStreamException ex) {

            }
        } else {
            return null;
        }
//        System.out.println( "------------------------------------------------" );
//        for ( String att : attTypesNotSupported ) {
//            System.out.println( att );
//        }
//        System.out.println( "------------------------------------------------" );
        return questions;
    }

    public QuestionXMLConverter() {
        this(null);
    }

    public QuestionXMLConverter(String filename) {
        this.filename = filename;
        setReader();
    }

    private void setReader() {
        if (filename == null || filename.isBlank()) {
            this.file = null;
            this.reader = null;
        } else {
            file = new File(filename);
            if (file.exists()) {
                XMLInputFactory factory = XMLInputFactory.newInstance();
                try {
                    reader = factory.createXMLEventReader(new FileInputStream(file));
                } catch (FileNotFoundException | XMLStreamException ex) {
                    Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String toXML(Question question) {
        return "xml";
    }

    public String toXML(MultiChoice question) {
        return "xml";
    }

    public String toXML(MultiChoiceSet question) {
        return "xml";
    }

    private Question parseXMLQuestion(QuestionTypeEnum qType) {
        Question q = null;
        MultipleChoiceQuestion maq = null;
        MultiChoiceSet msq = null;
        try {
            switch (qType) {
                case ShortAnswer:
                    q = new ShortAnswer();
                    break;
                case TrueFalse:
                    q = new TrueFalse();
                    break;
                case MultipleChoice:
                    q = new MultiChoice();
                    maq = (MultiChoice) q;
                    break;
                case MultipleChoice_AllorNothing:
                    q = new MultiChoiceSet();
                    maq = (MultiChoiceSet) q;
                    
                    break;
            }
            if (q == null) {
                Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.SEVERE, "Question type not reconized in paseXMLQuestion().");
                return null;
            }
            XMLEvent event = reader.nextEvent();
            while (!(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("question"))) {
                if (event.isStartElement()) {
                    StartElement ele = event.asStartElement();
                    switch (ele.getName().getLocalPart()) {
                        case "name":
                            q.setName(parseTextBlock(ele));
                            break;
                        case "questiontext":
                            q.setText(parseTextBlock(ele));
                            break;
                        case "generalfeedback":
                            q.setGeneralFB(parseTextBlock(ele));
                            break;
                        case "defaultgrade":
                            q.setDefaultGrade(parseNumberData());
                            break;
                        case "penalty":
                            q.setPenalty(parseNumberData());
                            break;
                        case "hidden":
                            q.setHidden(parseBooleanData());
                            break;
                        case "idnumber":
                            q.setIdNumber(parseStringData());
                            break;
                        /* ======> MULTIANSWER QUESTIONS ONLY <====================================== */
                        case "shuffleanswers":
                            if (maq != null) {
                                maq.setShuffleAnswers(parseBooleanData());
                            }
                            break;
                        case "pariallycorrectfeedback":
                            if (maq != null) {
                                maq.setPartiallyFB(parseTextBlock(ele));
                            }
                            break;
                        case "correctfeedback":
                            if (q.getType() == QuestionTypeEnum.MultipleChoice || q.getType() == QuestionTypeEnum.MultipleChoice_AllorNothing) {
                                if (maq != null) {
                                    maq.setCorrectFB(parseTextBlock(ele));
                                }
                            }
                            break;
                        case "incorrectfeedback":
                            if (maq != null) {
                                maq.setIncorrectFB(parseTextBlock(ele));
                            }
                            break;
                        case "shownumcorrect":
                            if (maq != null) {
                                maq.setShowCorrect(true);
                            }
                            break;
                        /* ======> MULTICHOICESET QUESTIONS ONLY <====================================== */
                        case "answernumbering":
                            
                            if (msq != null) {
                                msq = (MultiChoiceSet) maq;
                            }
                            try {
                                if (msq != null) {
                                    msq.setNumbering(AnswerNumberEnum.valueOf(parseStringData()));
                                }
                            } catch (IllegalArgumentException ex) {
                                if (msq != null) {
                                    msq.setNumbering(AnswerNumberEnum.none);
                                    Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.WARNING, "AnswerNumbering not type not excepts, set to 'non'");
                                }
                            }
                            break;
                        case "showstandardinstruction":
                            if (msq != null) {
                                msq = (MultiChoiceSet) maq;
                                msq.setShowInstructions(parseBooleanData());
                            }
                            break;
                        /* ======> MULTICHOICE QUESTION ONLY <======================================= */
                        case "single":
                            MultiChoice mcq = (MultiChoice) q;
                            mcq.setSingle(parseBooleanData());
                            break;
                        /* ======> SHORTANSWER QUESTION ONLY <======================================= */
                        case "usecase":
                            ShortAnswer saq = (ShortAnswer) q;
                            saq.setUsecase(parseBooleanData());
                            break;
                        /* ========================================================================== */
 /* ======> SHORTANSWER QUESTION ONLY <======================================= */
                        case "answer":
                            parseXMLAnswer(q, ele);
                            break;
                    }
                }
                event = reader.nextEvent();
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(QuestionXMLConverter.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return q;
    }

    private String parseStringData() throws XMLStreamException {
        String data = "";
        XMLEvent event = reader.nextEvent();
        if (event.isCharacters()) {
            data = event.asCharacters().getData();
        }
        data = fromHTMLtoPlainText(data);
        return data;
    }

    public String fromHTMLtoPlainText(String htmlStr) {
        String text = htmlStr;
        text = text.replaceAll("&nbsp;", " ");
        text = text.replaceAll("<p>", "");
        text = text.replaceAll("</p>", "<br><br>");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&amp;", "&");
        text = text.replaceAll("</?pre>", "");
        while (text.endsWith("<br>")) {
            int index = text.lastIndexOf("<br>");
            if (index != -1) {
                text = text.substring(0, index);
            }
        }
        return text;
    }

    private String parseTextBlock(StartElement ele) throws XMLStreamException {
        String rv = "";
        XMLEvent event;
        /*TextFormatEnum format;
        try {
            format = TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() );
        } catch ( NullPointerException e ) {
            format = TextFormatEnum.NONE;
        }*/
        reader.nextTag();
        return parseStringData();
    }

    private double parseNumberData() throws XMLStreamException {
        double data;
        try {
            data = Double.parseDouble(reader.nextEvent().asCharacters().getData());
        } catch (NumberFormatException | NullPointerException ex) {
            data = 0.0;
            Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.WARNING, "Cannot parse a number/double, using 0.0");
        }
        return data;
    }

    private boolean parseBooleanData() throws XMLStreamException {
        boolean rv;
        int asInt;
        String data = reader.nextEvent().asCharacters().getData();
        try {
            asInt = Integer.parseInt(data);
        } catch (NumberFormatException | NullPointerException ex) {
            Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.INFO, "Parsing Boolean is not 0/1 formated.");
            asInt = -1;
        }
        if (asInt == -1) {
            try {
                rv = Boolean.parseBoolean(data);
            } catch (NumberFormatException | NullPointerException ex) {
                rv = true;
                Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.WARNING, "Cannot parse a Boolean, using TRUE");
            }
            return rv;
        } else {
            return (0 != asInt);
        }
    }

    @SuppressWarnings("unchecked")
    private void parseXMLAnswer(Question q, StartElement element) throws XMLStreamException {
        switch (q.getType()) {
            case TrueFalse:
                paswerXMLTrueFalseAnswers((TrueFalse) q, element);
                break;
            case ShortAnswer:
            case MultipleChoice:
            case MultipleChoice_AllorNothing:
                Answer_Feedback answer = new Answer_Feedback();
                answer.setFraction(Double.parseDouble(element.getAttributeByName(new QName("fraction")).getValue()));
                try {
                    XMLEvent event = element.asStartElement();
                    while (!(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("answer"))) {
                        if (event.isStartElement()) {
                            StartElement ele = event.asStartElement();
                            switch (ele.getName().getLocalPart()) {
                                case "text":
                                    answer.setText(this.parseStringData());
                                    break;
                                case "feedback":
                                    answer.setFeedback(this.parseTextBlock(ele));
                                    break;
                            }
                        }
                        event = reader.nextEvent();
                    }
                } catch (XMLStreamException ex) {
                    Logger.getLogger(QuestionXMLConverter.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((MultiAnswerContainer) q).addAnswer(answer);
                break;

        }
    }

    private void paswerXMLTrueFalseAnswers(TrueFalse trueFalse, StartElement startElement) throws XMLStreamException {
        // set numAnswers to 1
        // while parseing element is not last answer end element ( numAnswer > 2 )
        // parse fraction
        // if first answer, set TRUE/FALSE answer
        // parse text and ignore
        // parse FB
        // if current fraction == 100, set TRUE FB
        // else set FALSE FB
        //get next element to parse

        int numAnswers = 1;
        double fraction = -1.0;
        XMLEvent event = startElement.asStartElement();
        while (numAnswers <= 2) {
            if (event.isStartElement()) {
                StartElement ele = event.asStartElement();
                switch (ele.getName().getLocalPart()) {
                    case "answer":
                        fraction = Double.parseDouble(ele.getAttributeByName(new QName("fraction")).getValue());
                        if (numAnswers == 1) {
                            if (fraction == 0.0) {
                                trueFalse.setAnswerFalse();
                            } else {
                                trueFalse.setAnswerTrue();
                            }
                        }
                        break;
                    case "text":
                        break;
                    case "feedback":
                        if (fraction == 100.0) {
                            trueFalse.setTrueFB(parseTextBlock(ele));
                        } else {
                            trueFalse.setFalseFB(parseTextBlock(ele));
                        }
                        break;
                }
            }
            event = reader.nextEvent();
            if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart().equals("answer")) {
                    numAnswers++;
                }
            }
        }
    }
}
