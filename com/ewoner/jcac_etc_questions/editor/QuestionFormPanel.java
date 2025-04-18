package com.ewoner.java_etc_questions.editor;

import com.ewoner.java_etc_questions.editor.Table.QuestionTableModel;
import com.ewoner.java_etc_questions.models.questions.MultiChoiceSet;
import com.ewoner.java_etc_questions.models.questions.ShortAnswer;
import com.ewoner.java_etc_questions.models.questions.TrueFalse;
import com.ewoner.java_etc_questions.models.questions.abstracts.Question;
import com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum;
import static com.ewoner.java_etc_questions.models.questions.abstracts.QuestionTypeEnum.MultipleChoice_AllorNothing;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class QuestionFormPanel extends javax.swing.JPanel {

    private final EditorController controller;

    /**
     * Creates new form QuestionFormPanel
     *
     */
    public QuestionFormPanel() {
        this( null );
    }

    public QuestionFormPanel( EditorController controller ) {
        initComponents();
        this.controller = controller;
        cbQuestionType.removeAllItems();
        for ( var t : controller.getSupportTypes() ) {
            cbQuestionType.addItem( t.uiName() );
        }
        cbQuestionType.setSelectedItem( controller.getSupportTypeAt( 0 ).uiName() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgQuestionType = new javax.swing.ButtonGroup();
        javax.swing.JLabel lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        javax.swing.JLabel lbText = new javax.swing.JLabel();
        javax.swing.JScrollPane scpText = new javax.swing.JScrollPane();
        epText = new javax.swing.JEditorPane();
        javax.swing.JScrollPane scpGenFB = new javax.swing.JScrollPane();
        epGenFB = new javax.swing.JEditorPane();
        javax.swing.JLabel lbCategory = new javax.swing.JLabel();
        javax.swing.JLabel lbGenFB = new javax.swing.JLabel();
        javax.swing.JLabel lbIdNumber = new javax.swing.JLabel();
        tfIdNumber = new javax.swing.JTextField();
        javax.swing.JComboBox<String> cbCategory = new javax.swing.JComboBox<>();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnMore = new javax.swing.JButton();
        javax.swing.JButton btnClear = new javax.swing.JButton();
        javax.swing.JPanel questionTypePanel = new javax.swing.JPanel();
        cbQuestionType = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        lbName.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbName.setText("Question Name");

        tfName.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        lbText.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbText.setText("Question Text");

        epText.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        scpText.setViewportView(epText);

        epGenFB.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        scpGenFB.setViewportView(epGenFB);

        lbCategory.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbCategory.setText("Category");

        lbGenFB.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbGenFB.setText("General Feedback");

        lbIdNumber.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        lbIdNumber.setText("ID Number");

        tfIdNumber.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        cbCategory.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Supported Yet." }));
        cbCategory.setEnabled(false);

        btnSave.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnSave.setText("Add/Save");
        btnSave.setMaximumSize(new java.awt.Dimension(100, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(100, 23));
        btnSave.setPreferredSize(new java.awt.Dimension(100, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnMore.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnMore.setText("More...");
        btnMore.setMaximumSize(new java.awt.Dimension(100, 23));
        btnMore.setMinimumSize(new java.awt.Dimension(100, 23));
        btnMore.setPreferredSize(new java.awt.Dimension(100, 23));
        btnMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setMaximumSize(new java.awt.Dimension(100, 23));
        btnClear.setMinimumSize(new java.awt.Dimension(100, 23));
        btnClear.setPreferredSize(new java.awt.Dimension(100, 23));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        questionTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Question Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Open Sans", 1, 14))); // NOI18N

        cbQuestionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<NONE>", "Short Answer", "True or False", "Multiple Choice" }));
        cbQuestionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuestionTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questionTypePanelLayout = new javax.swing.GroupLayout(questionTypePanel);
        questionTypePanel.setLayout(questionTypePanelLayout);
        questionTypePanelLayout.setHorizontalGroup(
            questionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbQuestionType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        questionTypePanelLayout.setVerticalGroup(
            questionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionTypePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbQuestionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfIdNumber)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfName)
                    .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpText, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                    .addComponent(lbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIdNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGenFB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpGenFB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questionTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpText, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGenFB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpGenFB, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIdNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(questionTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        controller.saveAction();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreActionPerformed
        controller.moreAction();

    }//GEN-LAST:event_btnMoreActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        controller.clearEditorAction();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbQuestionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuestionTypeActionPerformed
        int result;
        controller.setType( controller.getSupportTypeAt( cbQuestionType.getSelectedIndex() ) );
        if ( controller.getQuestion() == null ) {
            controller.newQuestion();
        } else if ( controller.getQuestion().getType() != controller.getType() ) {
            result = JOptionPane.showConfirmDialog( this, "Changing the question Type can result in loss of data as not all question are compatible.\n\nDo you wish to change this question's type?", "Change Question Type", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if ( result == JOptionPane.NO_OPTION ) {
                controller.setType( controller.getQuestion().getType() );
                cbQuestionType.setSelectedItem( controller.getType().uiName() );
            } else {
                controller.newQuestion();
            }
        }
    }//GEN-LAST:event_cbQuestionTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgQuestionType;
    private javax.swing.JComboBox<String> cbQuestionType;
    private javax.swing.JEditorPane epGenFB;
    private javax.swing.JEditorPane epText;
    private javax.swing.JTextField tfIdNumber;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
private void updateQuestionFields() {
        if ( controller.getQuestion() != null ) {
            setQuestionNameField( controller.getQuestion().getName() );
            setQuestionTextField( controller.getQuestion().getText() );
            setIdNumberField( controller.getQuestion().getIdNumber() );
            setGenFBField( controller.getQuestion().getGeneralFB() );

        } else {
            setQuestionNameField( "" );
            setQuestionTextField( "" );
            setIdNumberField( "" );
            setGenFBField( "" );
        }
    }

    public String getGenFBField() {
        return epGenFB.getText();
    }

    public void setGenFBField( String newText ) {
        epGenFB.setText( newText );
    }

    public String getQuestionTextField() {
        return epText.getText();
    }

    public void setQuestionTextField( String newText ) {
        epText.setText( newText );
    }

    public String getIdNumberField() {
        return tfIdNumber.getText();
    }

    public void setIdNumberField( String newText ) {
        tfIdNumber.setText( newText );
    }

    public String getQuestionNameField() {
        return tfName.getText();
    }

    public void setQuestionNameField( String newText ) {
        tfName.setText( newText );
    }

    private String getCategoryField() {
        return "";
    }

    public void clearFields() {
        this.tfName.setText( "" );
        this.tfIdNumber.setText( "" );
        this.epText.setText( "" );
        this.epGenFB.setText( "" );
        this.cbQuestionType.setSelectedItem( controller.getType().uiName() );

    }
}
