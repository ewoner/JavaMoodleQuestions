package com.ewoner.java_etc_questions.editor;

import com.ewoner.java_etc_questions.editor.Table.QuestionTableModel;
import com.ewoner.java_etc_questions.models.questions.MultiChoiceSet;
import com.ewoner.java_etc_questions.models.questions.ShortAnswer;
import com.ewoner.java_etc_questions.models.questions.TrueFalse;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import static com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum.MultipleChoice_AllorNothing;
import java.util.Arrays;
import javax.swing.JOptionPane;

public final class EditorController {

    final private QuestionTypeEnum[] supportedTypes = { QuestionTypeEnum.NONE, QuestionTypeEnum.TrueFalse, QuestionTypeEnum.MultipleChoice_AllorNothing, QuestionTypeEnum.ShortAnswer };

    private Question question;
    private QuestionTypeEnum type;

    private final QuestionEditor mainFrame;
    private final QuestionEditDialog editDialog;
    private final NewQuestionDialog newDialog;

    private final QuestionTableModel model;

    public EditorController() {
        type = QuestionTypeEnum.NONE;
        model = new QuestionTableModel();
        mainFrame = new QuestionEditor( this );
        editDialog = new QuestionEditDialog( getMainFrame(), false, this );
        newDialog = new NewQuestionDialog( getMainFrame(), true, this );

    }

    public QuestionTypeEnum[] getSupportTypes() {
        return Arrays.copyOf( getSupportedTypes(), getSupportedTypes().length );
    }

    public QuestionTypeEnum getSupportTypeAt( int index ) {
        if ( index < 0 || index >= getSupportedTypes().length ) {
            throw new java.lang.IndexOutOfBoundsException( index );
        } else {
            return getSupportedTypes()[ index ];
        }
    }

    /**
     * @return the supportedTypes
     */
    public QuestionTypeEnum[] getSupportedTypes() {
        return supportedTypes;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @return the type
     */
    public QuestionTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( QuestionTypeEnum type ) {
        this.type = type;
    }

    /**
     * @return the mainFrame
     */
    public QuestionEditor getMainFrame() {
        return mainFrame;
    }

    /**
     * @return the editDialog
     */
    public QuestionEditDialog getEditDialog() {
        return editDialog;
    }

    /**
     * @return the newDialog
     */
    public NewQuestionDialog getNewDialog() {
        return newDialog;
    }

    /**
     * @return the model
     */
    public QuestionTableModel getModel() {
        return model;
    }

    public void saveAction() {
        if ( getQuestion() == null ) {
            JOptionPane.showMessageDialog( getMainFrame(), "You must choose a question Type before saving.", "No Question Type", JOptionPane.ERROR_MESSAGE );
            return;
        }
        newQuestion();
        getQuestion().setText( getEditDialog().getQuestionTextField() );
        getQuestion().setName( getEditDialog().getQuestionNameField() );
        getQuestion().setIdNumber( getEditDialog().getIdNumberField() );
        getQuestion().setGeneralFB( getEditDialog().getGenFBField() );
        if ( getQuestion().getName().isBlank() || getQuestion().getText().isBlank() ) {
            JOptionPane.showMessageDialog( getEditDialog(), "One or both of the NAME or TEXT field is blank.\n\nPlease input at least one non-whitespace character and try again.", "Blank Name or Text", JOptionPane.ERROR_MESSAGE );
            return;
        }
        getModel().addRow( getQuestion() );
    }

    public void newQuestion() {
        switch ( type ) {
            case TrueFalse:
                question = new TrueFalse( editDialog.getQuestionNameField(), editDialog.getQuestionTextField(), editDialog.getGenFBField() );
                break;
            case MultipleChoice_AllorNothing:
                question = new MultiChoiceSet( editDialog.getQuestionNameField(), editDialog.getQuestionTextField(), editDialog.getGenFBField() );
                break;
            case ShortAnswer:
                question = new ShortAnswer( editDialog.getQuestionNameField(), editDialog.getQuestionTextField(), editDialog.getGenFBField() );
                break;
        }
        if ( question != null ) {
            question.setIdNumber( editDialog.getIdNumberField() );
        }
    }

    public void moreAction() {
        JOptionPane.showMessageDialog( mainFrame, "Open a new Dialog with all other options based on Question Type.", "More Settings Action", JOptionPane.INFORMATION_MESSAGE );
    }

    public void clearEditorAction() {
        if ( question == null ) {
            JOptionPane.showMessageDialog( mainFrame, "Question not saved, can not clear yet.  Please choose a QUestion Type to initiall siave.", "Not saved.", JOptionPane.WARNING_MESSAGE );

        } else if ( question.getName().isBlank() && question.getText().isBlank() && question.getIdNumber().isBlank() && question.getGeneralFB().isBlank() ) {
            JOptionPane.showMessageDialog( mainFrame, "Question is already empty.  Please add information and hit the 'ADD/SAVE' button when done.", "Question is Blank.", JOptionPane.WARNING_MESSAGE );
        } else if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog( mainFrame, "Do you wish to clear/blank all fields?", "Clear All?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ) ) {
            if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog( mainFrame, "Are you sure?  This will delete all prsent question information.", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE ) ) {
                editDialog.getEditForm().clearFields();
                question = null;
                type = QuestionTypeEnum.NONE;
            }
        }
    }

    public void newAction() {
        newDialog.setLocationRelativeTo( mainFrame );
        newDialog.setVisible( true );
    }

    void editAction() {
        int row = mainFrame.getSelectedIndex();
        if ( row < 0 ) {
            JOptionPane.showMessageDialog( mainFrame, "No question is selected! Please select a question", "Select Question", JOptionPane.ERROR_MESSAGE );
        } else {
//            Question q = controller.getModel().getQuestion( row );
            System.out.println( "Editing a question..." );
//            this.questionFormPanel1.setQuestion( q );
        }
    }

    void deleteAction() {
        throw new UnsupportedOperationException( "Not supported yet." ); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
