package com.ewoner.java_etc_questions.editor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ewone
 */
public class NewQuestionDialog extends javax.swing.JDialog {

    private final EditorController controller;

    /**
     * Creates new form NewQuestionDialog
     */
    public NewQuestionDialog( JFrame frame, boolean model, EditorController controller ) {
        super( frame, model );
        initComponents();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        javax.swing.JPanel questionTypePanel = new javax.swing.JPanel();
        cbQuestionType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(400, 150));
        setMinimumSize(new java.awt.Dimension(400, 150));
        setPreferredSize(new java.awt.Dimension(400, 150));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 40));

        jButton1.setText("Select");
        jPanel1.add(jButton1);

        questionTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "New Question Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Open Sans", 1, 14))); // NOI18N
        questionTypePanel.setMaximumSize(new java.awt.Dimension(400, 60));
        questionTypePanel.setMinimumSize(new java.awt.Dimension(400, 60));
        questionTypePanel.setPreferredSize(new java.awt.Dimension(400, 60));

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
                .addComponent(cbQuestionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(questionTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JComboBox<String> cbQuestionType;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
