/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.AuthorController;
import javax.swing.JOptionPane;
import models.dto.AuthorDto;
import models.Author;

public class AuthorForm extends javax.swing.JFrame {

  private final AuthorController authorController;
  private Author author;

  public AuthorForm() {
    this.authorController = new AuthorController();
    initComponents();
  }

  public AuthorForm(Author author) {
    this.authorController = new AuthorController();
    this.author = author;
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    nameInput = new javax.swing.JTextField();
    nationalityLabel = new javax.swing.JLabel();
    nationalityInput = new javax.swing.JTextField();
    saveBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(author != null ? "Edição de autor" : "Cadastro de autor");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(new java.awt.Font("Source Code Pro Light", 0, 14)); // NOI18N
    setForeground(java.awt.Color.white);
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(600, 400));
    setSize(new java.awt.Dimension(600, 400));

    title.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 24)); // NOI18N
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText(author != null ? "Editar autor" : "Cadastrar autor");
    title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    title.setFocusable(false);
    title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    title.setName("Título"); // NOI18N
    title.setRequestFocusEnabled(false);
    title.setVerifyInputWhenFocusTarget(false);
    title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    nameLabel.setFont(new java.awt.Font("Source Code Pro Medium", 0, 14)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setLabelFor(nationalityInput);
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
    nameInput.setText(author != null ? author.getName() : "");
    nameInput.setToolTipText("Insira o nome do autor");
    nameInput.setMinimumSize(new java.awt.Dimension(220, 25));
    nameInput.setName("Nome do autor"); // NOI18N
    nameInput.setNextFocusableComponent(nationalityInput);
    nameInput.setPreferredSize(new java.awt.Dimension(220, 25));

    nationalityLabel.setFont(new java.awt.Font("Source Code Pro Medium", 0, 14)); // NOI18N
    nationalityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nationalityLabel.setLabelFor(nationalityInput);
    nationalityLabel.setText("Nacionalidade");
    nationalityLabel.setFocusable(false);
    nationalityLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    nationalityLabel.setName("Label nacionalidade"); // NOI18N
    nationalityLabel.setRequestFocusEnabled(false);
    nationalityLabel.setVerifyInputWhenFocusTarget(false);

    nationalityInput.setBackground(new java.awt.Color(255, 255, 255));
    nationalityInput.setColumns(25);
    nationalityInput.setFont(new java.awt.Font("Source Code Pro Medium", 0, 14)); // NOI18N
    nationalityInput.setForeground(new java.awt.Color(30, 30, 30));
    nationalityInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    nationalityInput.setText(author != null ? author.getNationality() : "");
    nationalityInput.setToolTipText("Insira a nacionalidade do autor");
    nationalityInput.setMinimumSize(new java.awt.Dimension(220, 25));
    nationalityInput.setName("Nacionalidade do autor"); // NOI18N
    nationalityInput.setNextFocusableComponent(saveBtn);
    nationalityInput.setPreferredSize(new java.awt.Dimension(220, 25));

    saveBtn.setBackground(new java.awt.Color(0, 153, 202));
    saveBtn.setFont(new java.awt.Font("Source Code Pro Medium", 0, 18)); // NOI18N
    saveBtn.setForeground(new java.awt.Color(255, 255, 255));
    saveBtn.setText(author != null ? "Editar" : "Cadastrar");
    saveBtn.setToolTipText(author != null ? String.format("Editar o autor %s", author.getName()) : "Cadastrar novo autor");
    saveBtn.setActionCommand("Salvar");
    saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    saveBtn.setLabel(author != null ? "Editar" : "Cadastrar");
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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(192, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addComponent(nameLabel))
          .addGroup(layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(nationalityLabel))
          .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nationalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(190, 190, 190))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(209, 209, 209)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(title)
        .addGap(27, 27, 27)
        .addComponent(nameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29)
        .addComponent(nationalityLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(nationalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(26, 26, 26)
        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(76, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informaões do autor");

    getAccessibleContext().setAccessibleName("Formulário de autores");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    AuthorDto authorData = new AuthorDto(nameInput.getText(), nationalityInput.getText());
    String msg;

    try {
      if (author != null) {
        authorController.update(author.getId(), authorData);
        msg = "Autor atualizado com sucesso!";
      } else {
        authorController.create(authorData);
        msg = "Autor cadastrado com sucesso!";
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
  private javax.swing.JTextField nationalityInput;
  private javax.swing.JLabel nationalityLabel;
  private javax.swing.JButton saveBtn;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
