package com.ewoner.java_etc_questions.models.questions.abstracts;

public enum QuestionTypeEnum {
    MultipleChoice( "Mutliple Choice (old)" ),
    MultipleChoice_AllorNothing( "Multiple Choice", "multichoiceset" ),
    TrueFalse( "True or False" ),
    ShortAnswer( "Short Answer" ),
    CodeRunner( "Code Runnder" ),
    GapSelect( "Gap Select" ),
    Numerical_ShortAnser( "Numerical", "numerical" ),
    Calculated( "Calculated" ),
    Calculated_MultipleChoice( "Calculated MC", "calculatedmulti" ),
    Matching( "Matching", "ddmatch" ),
    DragAndDropIntoText( "Drag and Drop into Text", "ddwtos" ),
    DragAndDropMatching( "Drag and Drop Matching", "ddmatch" ),
    Essay( "Essay" ),
    Cloze( "Cloze" ),
    DescriptionResponse( "Description Response" ),
    RandomMathing( "Random Mathing", "randommatch" ),
    NONE( "<NONE>" );

    private final String xmlString;
    private final String uiName;

    private QuestionTypeEnum( String uiName ) {
        this.uiName = uiName;
        this.xmlString = this.name().toLowerCase();
    }

    private QuestionTypeEnum( String uiName, String xmlString ) {
        this.uiName = uiName;
        this.xmlString = xmlString;
    }

    public String uiName() {
        return uiName;
    }

    public String asXMLString() {
        return xmlString;
    }
}
