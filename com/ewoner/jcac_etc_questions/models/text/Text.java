package com.ewoner.java_etc_questions.models.text;

public class Text {
    private String tagName;
    private String text;
    private TextFormatEnum format;

    
    public Text(){
        this("TAG NAME", "TEXT STRING", TextFormatEnum.html);
    }
    public Text( String tagName ){
        this(tagName, "TEXT STRING", TextFormatEnum.html);
    }
    public Text( String tagName, String text ){
        this(tagName, text, TextFormatEnum.html);
    }
    public Text(String tagName, String text, TextFormatEnum format ){
        this.tagName = tagName;
        this.text = text;
        this.format = format;
    }
    /**
     * @return the tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName the tagName to set
     */
    public void setTagName( String tagName ) {
        this.tagName = tagName;
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
     * @param format the format to set
     */
    public void setFormat( TextFormatEnum format ) {
        this.format = format;
    }
}
