/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.forms;

import javax.swing.JOptionPane;

import controller.CategoryController;
import models.Category;
import views.constants.Constants;

public class CategoryForm extends javax.swing.JFrame {

	private final CategoryController categoryController;
	private Category category;

	public CategoryForm() {
		this.categoryController = new CategoryController();
		initComponents();
	}

	public CategoryForm(Category category) {
		this.categoryController = new CategoryController();
		this.category = category;
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
    setTitle(category != null ? "Edição de categoria" : "Cadastro de categoria");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(new java.awt.Dimension(600, 320));
    setMinimumSize(new java.awt.Dimension(600, 320));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(600, 320));
    setResizable(false);
    setSize(new java.awt.Dimension(600, 320));

    title.setBackground(Constants.BACKGROUND_COLOR);
    title.setFont(Constants.TITLE_FONT);
    title.setForeground(Constants.FONT_COLOR);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText(category != null ? "Editar categoria" : "Cadastrar categoria");
    title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    title.setFocusable(false);
    title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    title.setMaximumSize(new java.awt.Dimension(295, 30));
    title.setMinimumSize(new java.awt.Dimension(295, 30));
    title.setName("Título"); // NOI18N
    title.setPreferredSize(new java.awt.Dimension(295, 30));
    title.setRequestFocusEnabled(false);
    title.setVerifyInputWhenFocusTarget(false);
    title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    nameLabel.setBackground(Constants.BACKGROUND_COLOR);
    nameLabel.setFont(Constants.DEFAULT_FONT);
    nameLabel.setForeground(Constants.FONT_COLOR);
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setLabelFor(nameInput);
    nameLabel.setText("Nome");
    nameLabel.setFocusable(false);
    nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    nameLabel.setName("Label nome"); // NOI18N
    nameLabel.setRequestFocusEnabled(false);
    nameLabel.setVerifyInputWhenFocusTarget(false);

    nameInput.setBackground(Constants.WHITE);
    nameInput.setColumns(25);
    nameInput.setFont(Constants.DEFAULT_FONT);
    nameInput.setForeground(Constants.FONT_COLOR);
    nameInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    nameInput.setText(category != null ? category.getName() : "");
    nameInput.setToolTipText("Insira o nome da categoria");
    nameInput.setCaretColor(Constants.FONT_COLOR);
    nameInput.setMaximumSize(new java.awt.Dimension(295, 30));
    nameInput.setMinimumSize(new java.awt.Dimension(295, 30));
    nameInput.setName("Nome da categoria"); // NOI18N
    nameInput.setNextFocusableComponent(saveBtn);
    nameInput.setPreferredSize(new java.awt.Dimension(295, 30));
    nameInput.setSelectedTextColor(Constants.WHITE);
    nameInput.setSelectionColor(Constants.DARK_BLUE);

    saveBtn.setBackground(Constants.BLUE);
    saveBtn.setFont(Constants.MEDIUM_FONT);
    saveBtn.setForeground(Constants.WHITE);
    saveBtn.setText(category != null ? "Editar" : "Cadastrar");
    saveBtn.setToolTipText(category != null ? String.format("Editar a categoria %s", category.getName()) : "Cadastrar nova categoria");
    saveBtn.setActionCommand("Salvar");
    saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    saveBtn.setLabel(category != null ? "Editar" : "Cadastrar");
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

    cancelBtn.setBackground(Constants.RED);
    cancelBtn.setFont(Constants.MEDIUM_FONT);
    cancelBtn.setForeground(Constants.WHITE);
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
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(208, 208, 208)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGap(153, 153, 153)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(nameLabel))))
        .addContainerGap(152, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(nameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(39, 39, 39)
        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(43, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleName("Título");
    title.getAccessibleContext().setAccessibleDescription("");
    nameInput.getAccessibleContext().setAccessibleName("Nome");
    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informações da categoria");

    getAccessibleContext().setAccessibleName("Formulário de categorias");
    getAccessibleContext().setAccessibleDescription("");

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveBtnActionPerformed
		String name = nameInput.getText();
		String msg;

		try {

			if (category != null) {
				categoryController.update(category.getId(), name);
				msg = "Categoria atualizada com sucesso!";
			} else {
				categoryController.create(name);
				msg = "Categoria cadastrada com sucesso!";
			}

			JOptionPane.showMessageDialog(this, msg, getTitle(), JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_saveBtnActionPerformed

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		this.dispose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	@Override
	public void dispose() {
		categoryController.closeConnection();
		super.dispose();
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelBtn;
  private javax.swing.JTextField nameInput;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JButton saveBtn;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
