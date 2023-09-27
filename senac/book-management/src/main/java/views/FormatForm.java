/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.FormatController;
import javax.swing.JOptionPane;
import models.Format;

public class FormatForm extends javax.swing.JFrame {

  private final FormatController formatController;
  private Format format;

  public FormatForm() {
    this.formatController = new FormatController();
    initComponents();
  }

  public FormatForm(Format format) {
    this.formatController = new FormatController();
    this.format = format;
    initComponents();
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    nameInput = new javax.swing.JTextField();
    saveBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(format != null ? "Edição de formato" : "Cadastro de formato");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(new java.awt.Font("Source Code Pro Light", 0, 14)); // NOI18N
    setForeground(java.awt.Color.white);
    setMaximumSize(new java.awt.Dimension(600, 300));
    setMinimumSize(new java.awt.Dimension(600, 300));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(600, 300));
    setResizable(false);
    setSize(new java.awt.Dimension(600, 300));

    title.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 24)); // NOI18N
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText(format != null ? "Editar formato" : "Cadastrar formato");
    title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    title.setFocusable(false);
    title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    title.setName("Título"); // NOI18N
    title.setRequestFocusEnabled(false);
    title.setVerifyInputWhenFocusTarget(false);
    title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    nameLabel.setFont(new java.awt.Font("Source Code Pro Medium", 0, 14)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("Nome");
    nameLabel.setFocusable(false);
    nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    nameLabel.setName("Label nome"); // NOI18N
    nameLabel.setRequestFocusEnabled(false);
    nameLabel.setVerifyInputWhenFocusTarget(false);

    nameInput.setBackground(new java.awt.Color(255, 255, 255));
    nameInput.setColumns(25);
    nameInput.setFont(new java.awt.Font("Source Code Pro Medium", 0, 14)); // NOI18N
    nameInput.setForeground(new java.awt.Color(30, 30, 30));
    nameInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    nameInput.setText(format != null ? format.getName() : "");
    nameInput.setToolTipText("Insira o nome do formato");
    nameInput.setMaximumSize(new java.awt.Dimension(220, 30));
    nameInput.setMinimumSize(new java.awt.Dimension(220, 30));
    nameInput.setName("Nome do formato"); // NOI18N
    nameInput.setNextFocusableComponent(saveBtn);
    nameInput.setPreferredSize(new java.awt.Dimension(220, 30));

    saveBtn.setBackground(new java.awt.Color(0, 153, 202));
    saveBtn.setFont(new java.awt.Font("Source Code Pro Medium", 0, 18)); // NOI18N
    saveBtn.setForeground(new java.awt.Color(255, 255, 255));
    saveBtn.setText(format != null ? "Editar" : "Cadastrar");
    saveBtn.setToolTipText(format != null ? String.format("Editar o formato %s", format.getName()) : "Cadastrar novo formato");
    saveBtn.setActionCommand("Salvar");
    saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    saveBtn.setLabel(format != null ? "Editar" : "Cadastrar");
    saveBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    saveBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    saveBtn.setName("Botão salvar"); // NOI18N
    saveBtn.setNextFocusableComponent(cancelBtn);
    saveBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    saveBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveBtnActionPerformed(evt);
      }
    });

    cancelBtn.setBackground(new java.awt.Color(220, 20, 20));
    cancelBtn.setFont(new java.awt.Font("Source Code Pro Medium", 0, 18)); // NOI18N
    cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
    cancelBtn.setText("Cancelar");
    cancelBtn.setToolTipText("Descartar alterações e voltar para o menu");
    cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cancelBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    cancelBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    cancelBtn.setName("Botão de cancelar"); // NOI18N
    cancelBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    cancelBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 155, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(nameLabel))
                  .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(title)
        .addGap(18, 18, 18)
        .addComponent(nameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28)
        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(54, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleName("Título");
    title.getAccessibleContext().setAccessibleDescription("");
    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informaões do formato");

    getAccessibleContext().setAccessibleName("Formulário de formatos");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    String name = nameInput.getText();
    String msg;

    try {
      if (format != null) {
        formatController.update(format.getId(), name);
        msg = "Formato atualizado com sucesso!";
      } else {
        formatController.create(name);
        msg = "Formato cadastrado com sucesso!";
      }

      JOptionPane.showMessageDialog(this, msg, getTitle(), JOptionPane.INFORMATION_MESSAGE);
      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_saveBtnActionPerformed

  private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
    this.dispose();
  }//GEN-LAST:event_cancelBtnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelBtn;
  private javax.swing.JTextField nameInput;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JButton saveBtn;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
