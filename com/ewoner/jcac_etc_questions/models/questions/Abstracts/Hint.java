package com.ewoner.java_etc_questions.models.questions.abstracts;

public class Hint {

    private String text;
    private boolean showNumCorrect;
    private boolean clearWrong;
    private boolean showSelectedFeedback;

    public Hint() {
        this( "HINT TEXT", false, false );
    }

    public Hint( String text ) {
        this( text, false, false );
    }

    public Hint( String text, boolean showNumCorrect, boolean clearWrong ) {
        this.text = text;
        this.showNumCorrect = showNumCorrect;
        this.clearWrong = clearWrong;
        this.showSelectedFeedback = false;

    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText( String text ) {
        this.text = text;
    }

    /**
     * @return the showNumCorrect
     */
    public boolean isShowNumCorrect() {
        return showNumCorrect;
    }

    /**
     * @param showNumCorrect the showNumCorrect to set
     */
    public void setShowNumCorrect( boolean showNumCorrect ) {
        this.showNumCorrect = showNumCorrect;
    }

    /**
     * @return the clearWrong
     */
    public boolean isClearWrong() {
        return clearWrong;
    }

    /**
     * @param clearWrong the clearWrong to set
     */
    public void setClearWrong( boolean clearWrong ) {
        this.clearWrong = clearWrong;
    }

    /**
     * @return the showSelectedFeedback
     */
    public boolean isShowSelectedFeedback() {
        return showSelectedFeedback;
    }

    /**
     * @param showSelectedFeedback the showSelectedFeedback to set
     */
    public void setShowSelectedFeedback( boolean showSelectedFeedback ) {
        this.showSelectedFeedback = showSelectedFeedback;
    }
}
