package views.forms;

import javax.swing.JOptionPane;

import controller.AuthorController;
import factory.ControllerFactory;
import models.Author;
import models.dto.AuthorDto;
import views.constants.Constants;

public class AuthorForm extends javax.swing.JInternalFrame {
	private final AuthorController authorController;
	private Author author;

	public AuthorForm(ControllerFactory controllerFactory) {
		this.authorController = controllerFactory.getAuthorController();
		initComponents();
	}

	public AuthorForm(ControllerFactory controllerFactory, Author author) {
		this.authorController = controllerFactory.getAuthorController();
		this.author = author;
		initComponents();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		title = new javax.swing.JLabel();
		nameLabel = new javax.swing.JLabel();
		nameInput = new javax.swing.JTextField();
		nationalityLabel = new javax.swing.JLabel();
		nationalityInput = new javax.swing.JTextField();
		buttonsPanel = new javax.swing.JPanel();
		saveBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();

		setBackground(Constants.BACKGROUND_COLOR);
		setBorder(new javax.swing.border.LineBorder(Constants.BLACK, 2, true));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle(author != null ? "Edição de autor" : "Cadastro de autor");
		setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/author-icon.png"))); // NOI18N
		setMinimumSize(new java.awt.Dimension(512, 425));
		setName("Formulário de autor"); // NOI18N
		setNormalBounds(new java.awt.Rectangle(0, 0, 512, 425));
		setVisible(true);

		title.setFont(Constants.TITLE_FONT);
		title.setForeground(Constants.FONT_COLOR);
		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title.setLabelFor(this);
		title.setText(author != null ? "Editar autor" : "Cadastrar autor");
		title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		title.setFocusable(false);
		title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		title.setMaximumSize(null);
		title.setMinimumSize(new java.awt.Dimension(270, 30));
		title.setName("Título"); // NOI18N
		title.setPreferredSize(null);
		title.setRequestFocusEnabled(false);
		title.setVerifyInputWhenFocusTarget(false);
		title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		nameLabel.setFont(Constants.DEFAULT_FONT);
		nameLabel.setForeground(Constants.FONT_COLOR);
		nameLabel.setLabelFor(nameInput);
		nameLabel.setText("Nome");
		nameLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		nameLabel.setFocusable(false);
		nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		nameLabel.setMaximumSize(null);
		nameLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		nameLabel.setName("Nome"); // NOI18N
		nameLabel.setPreferredSize(null);
		nameLabel.setRequestFocusEnabled(false);
		nameLabel.setVerifyInputWhenFocusTarget(false);
		nameLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		nameInput.setBackground(Constants.WHITE);
		nameInput.setColumns(25);
		nameInput.setFont(Constants.DEFAULT_FONT);
		nameInput.setForeground(Constants.FONT_COLOR);
		nameInput.setText(author != null ? author.getName() : "");
		nameInput.setToolTipText("Insira o nome do autor");
		nameInput.setCaretColor(Constants.FONT_COLOR);
		nameInput.setMaximumSize(null);
		nameInput.setMinimumSize(new java.awt.Dimension(270, 30));
		nameInput.setName("Nome do autor"); // NOI18N
		nameInput.setPreferredSize(null);
		nameInput.setSelectedTextColor(Constants.WHITE);
		nameInput.setSelectionColor(Constants.DARK_BLUE);

		nationalityLabel.setFont(Constants.DEFAULT_FONT);
		nationalityLabel.setForeground(Constants.FONT_COLOR);
		nationalityLabel.setLabelFor(nationalityInput);
		nationalityLabel.setText("Nacionalidade");
		nationalityLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		nationalityLabel.setFocusable(false);
		nationalityLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		nationalityLabel.setMaximumSize(null);
		nationalityLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		nationalityLabel.setName("Nome"); // NOI18N
		nationalityLabel.setPreferredSize(null);
		nationalityLabel.setRequestFocusEnabled(false);
		nationalityLabel.setVerifyInputWhenFocusTarget(false);
		nationalityLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		nationalityInput.setBackground(Constants.WHITE);
		nationalityInput.setColumns(25);
		nationalityInput.setFont(Constants.DEFAULT_FONT);
		nationalityInput.setForeground(Constants.FONT_COLOR);
		nationalityInput.setText(author != null ? author.getNationality() : "");
		nationalityInput.setToolTipText("Insira a nacionalidade do autor");
		nationalityInput.setCaretColor(Constants.FONT_COLOR);
		nationalityInput.setMaximumSize(null);
		nationalityInput.setMinimumSize(new java.awt.Dimension(270, 30));
		nationalityInput.setName("Nacionalidade do autor"); // NOI18N
		nationalityInput.setPreferredSize(null);
		nationalityInput.setSelectedTextColor(Constants.WHITE);
		nationalityInput.setSelectionColor(Constants.DARK_BLUE);

		buttonsPanel.setBackground(null);
		buttonsPanel.setForeground(Constants.FONT_COLOR);
		buttonsPanel.setFocusable(false);
		buttonsPanel.setFont(Constants.DEFAULT_FONT);
		buttonsPanel.setMaximumSize(new java.awt.Dimension(270, 110));
		buttonsPanel.setMinimumSize(new java.awt.Dimension(270, 110));
		buttonsPanel.setName("Painel de botões"); // NOI18N

		saveBtn.setBackground(Constants.BLUE);
		saveBtn.setFont(Constants.LARGE_FONT);
		saveBtn.setForeground(Constants.WHITE);
		saveBtn.setText(author != null ? "Editar" : "Cadastrar");
		saveBtn
				.setToolTipText(author != null ? String.format("Editar o autor %s", author.getName()) : "Cadastrar novo autor");
		saveBtn.setActionCommand("Salvar");
		saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		saveBtn.setMaximumSize(null);
		saveBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		saveBtn.setName("Botão salvar"); // NOI18N
		saveBtn.setPreferredSize(null);
		saveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveBtnActionPerformed(evt);
			}
		});

		cancelBtn.setBackground(Constants.RED);
		cancelBtn.setFont(Constants.LARGE_FONT);
		cancelBtn.setForeground(Constants.WHITE);
		cancelBtn.setText("Cancelar");
		cancelBtn.setToolTipText("Descartar alterações e fechar a janela");
		cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		cancelBtn.setMaximumSize(null);
		cancelBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		cancelBtn.setName("Botão cancelar"); // NOI18N
		cancelBtn.setPreferredSize(null);
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
		buttonsPanel.setLayout(buttonsPanelLayout);
		buttonsPanelLayout
				.setHorizontalGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(buttonsPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		buttonsPanelLayout.setVerticalGroup(buttonsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buttonsPanelLayout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20)
						.addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		saveBtn.getAccessibleContext().setAccessibleName("Botão salvar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(120, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(nationalityInput, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(nationalityLabel, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(120, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20)
						.addComponent(nationalityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nationalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(45, Short.MAX_VALUE)));

		nameInput.getAccessibleContext().setAccessibleName("Nome do autor");
		nationalityInput.getAccessibleContext().setAccessibleName("Nacionalidade do autor");

		getAccessibleContext().setAccessibleName("Formulário de autor");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void createAuthor(AuthorDto data) {
		authorController.create(data);
		JOptionPane.showMessageDialog(this, "Autor cadastrado com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}

	private void updateAuthor(int id, AuthorDto data) {
		authorController.update(id, data);
		JOptionPane.showMessageDialog(this, "Autor atualizado com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}

	private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
		try {
			AuthorDto authorData = new AuthorDto(nameInput.getText(), nationalityInput.getText());

			if (author != null) updateAuthor(author.getId(), authorData);
			else createAuthor(authorData);

			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_saveBtnActionPerformed

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		dispose();
	}//GEN-LAST:event_cancelBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel buttonsPanel;
	private javax.swing.JButton cancelBtn;
	private javax.swing.JTextField nameInput;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nationalityInput;
	private javax.swing.JLabel nationalityLabel;
	private javax.swing.JButton saveBtn;
	private javax.swing.JLabel title;
	// End of variables declaration//GEN-END:variables
}
