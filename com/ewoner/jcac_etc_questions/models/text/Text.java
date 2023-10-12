package com.ewoner.jcac_etc_questions.models.text;

/**
 *
 * @author student
 */
public class Text {

    private String text;
    private TextFormatEnum format;

    /**
     *
     */
    public Text() {
        this( "", TextFormatEnum.plain_text );
    }

    /**
     *
     * @param text
     */
    public Text( String text ) {
        this( text, TextFormatEnum.html );
    }

    /**
     *
     * @param text
     * @param format
     */
    public Text( String text, TextFormatEnum format ) {
        this.text = text;
        this.format = format;
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
     * @return the format
     */
    public TextFormatEnum getFormat() {
        return format;
    }

    /**
     * type
     *
     * @param format the format to set
     */
    public void setFormat( TextFormatEnum format ) {
        this.format = format;
    }

    private String getTextFormat() {
        String rv = new String();
        switch( getFormat() ) {
            case plain_text:
            case NONE:
                rv = this.getText();
                break;
            case html:
                if( getText().isEmpty() == false ) {
                    rv = "<![CDATA[" + getText() + "]]>";
                } else {
                    rv = "";
                }
                break;

        }
        return rv;
    }

    /**
     *
     * @return
     */
    public String toXML() {

        return "<text>" + getTextFormat() + "</text>";
    }

    /**
     *
     * @param tagName
     * @param printType
     * @return
     */
    public String toXML( String tagName, boolean printType ) {
        if( printType ) {
            return "<" + tagName + " format=\"" + getFormat() + "\">\n"
                    + "<text>" + getTextFormat() + "</text>\n"
                    + "</" + tagName + ">";
        } else {
            return "<" + tagName + ">\n"
                    + "<text>" + getTextFormat() + "</text>\n"
                    + "</" + tagName + ">";
        }
    }

    /**
     *
     * @param tagName
     * @return
     */
    public String toXML( String tagName ) {
        return this.toXML( tagName, true );
    }
}
