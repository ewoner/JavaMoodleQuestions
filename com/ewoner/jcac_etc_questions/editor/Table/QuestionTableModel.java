package com.ewoner.java_etc_questions.editor.Table;

import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Created on $(date), $(time)
 *
 * @author Brion
 */
public class QuestionTableModel extends DefaultTableModel {

    private final List<Question> questions;
    private final String[] columnNames = new String[]{ "Key", "Name", "Text", "Feedback", "ID Number" };
    private int ID = 0;

    public QuestionTableModel() {
        this( new ArrayList<>() );
    }

    public QuestionTableModel( List<Question> qs ) {
        this.questions = qs;
    }

    @Override
    public String getColumnName( int column ) {
        return columnNames[ column ];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable( int row, int column ) {
        return false;
    }

    @Override
    public Class<?> getColumnClass( int column ) {
        if ( column == 0 ) {
            return int.class;
        } else {
            return String.class;
        }
    }

    public void addRow( Question q ) {
        q.setId( ID++ );
        questions.add( q );
        addRow( new Object[]{ q.getId(), q.getName(), q.getText(), q.getGeneralFB(), q.getIdNumber() } );

    }

    public Question getQuestion( int row ) {
        return this.questions.get( row );
    }

}
