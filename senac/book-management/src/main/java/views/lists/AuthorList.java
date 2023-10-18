package views.lists;

import static utils.Lists.getSortedList;

import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.AuthorController;
import exceptions.ValidationException;
import factory.ControllerFactory;
import models.Author;
import views.constants.Constants;
import views.details.AuthorDetails;
import views.forms.AuthorForm;

public class AuthorList extends javax.swing.JInternalFrame {
	private final ControllerFactory controllerFactory;
	private final AuthorController authorController;

	private DefaultTableModel tableModel;

	public AuthorList(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
		this.authorController = controllerFactory.getAuthorController();
		initComponents();
	}

	private void fillTable(Set<Author> authors) {
		tableModel.getDataVector().clear();

		if (authors.isEmpty()) {
			authorTable.repaint();
			return;
		}

		var authorsList = getSortedList(authors);

		authorsList.forEach(
				a -> tableModel.addRow(new Object[] { a.getId(), a.getName(), a.getNationality(), a.getBooksOwned() }));
	}

	private void updateView() {
		var authors = authorController.getAll();
		totalLabel.setText(String.format("Total encontrado: %d", authors.size()));
		fillTable(authors);
	}

	private Author getSelectedAuthor() {
		int selectedRow = authorTable.getSelectedRow();

		if (selectedRow == -1 || selectedRow >= tableModel.getRowCount())
			throw new RuntimeException("Você deve selecionar um autor!");

		var id = (int) tableModel.getValueAt(selectedRow, 0);
		return authorController.getById(id);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		title = new javax.swing.JLabel();
		tableScrollPane = new javax.swing.JScrollPane();
		var authors = authorController.getAll();
		String[] columnNames = { "ID", "Nome", "Nacionalidade", "Livros obtidos" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		authorTable = new javax.swing.JTable();
		detailsButton = new javax.swing.JButton();
		editBtn = new javax.swing.JButton();
		newBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();
		totalLabel = new javax.swing.JLabel();

		setBackground(Constants.BACKGROUND_COLOR);
		setBorder(new javax.swing.border.LineBorder(Constants.BLACK, 2, true));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Lista de autores");
		setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/author-icon.png"))); // NOI18N
		setMinimumSize(new java.awt.Dimension(932, 671));
		setName("Lista de autores"); // NOI18N
		setNormalBounds(new java.awt.Rectangle(0, 0, 932, 671));
		setVisible(true);
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameActivated(evt);
			}

			public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {}

			public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {}

			public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {}

			public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {}

			public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {}
		});

		title.setFont(Constants.TITLE_FONT);
		title.setForeground(Constants.FONT_COLOR);
		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title.setLabelFor(this);
		title.setText("Autores");
		title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		title.setFocusable(false);
		title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		title.setMaximumSize(new java.awt.Dimension(650, 30));
		title.setMinimumSize(new java.awt.Dimension(650, 30));
		title.setName("Título"); // NOI18N
		title.setPreferredSize(new java.awt.Dimension(650, 30));
		title.setRequestFocusEnabled(false);
		title.setVerifyInputWhenFocusTarget(false);
		title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		tableScrollPane.setBackground(Constants.WHITE);
		tableScrollPane.setForeground(Constants.FONT_COLOR);
		tableScrollPane.setFocusable(false);
		tableScrollPane.setFont(Constants.DEFAULT_FONT);
		tableScrollPane.setMaximumSize(null);
		tableScrollPane.setMinimumSize(new java.awt.Dimension(650, 500));
		tableScrollPane.setName("Painel da tabela"); // NOI18N

		authorTable.setBackground(Constants.WHITE);
		authorTable.setFont(Constants.DEFAULT_FONT);
		authorTable.setForeground(Constants.FONT_COLOR);
		authorTable.setModel(tableModel);
		authorTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		authorTable.setGridColor(Constants.FONT_COLOR);
		authorTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
		authorTable.setMaximumSize(null);
		authorTable.setMinimumSize(new java.awt.Dimension(650, 500));
		authorTable.setName("Lista de autores"); // NOI18N
		authorTable.setPreferredSize(null);
		authorTable.setRowHeight(25);
		authorTable.setSelectionBackground(Constants.DARK_GREEN);
		authorTable.setSelectionForeground(Constants.WHITE);
		authorTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		authorTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		authorTable.setShowGrid(false);
		authorTable.setShowHorizontalLines(true);
		authorTable.getTableHeader().setReorderingAllowed(false);
		TableColumn idColumn = authorTable.getColumnModel().getColumn(0);
		TableColumn nameColumn = authorTable.getColumnModel().getColumn(1);
		TableColumn nationalityColumn = authorTable.getColumnModel().getColumn(2);
		TableColumn booksOwnedColumn = authorTable.getColumnModel().getColumn(3);

		idColumn.setPreferredWidth(105);
		nameColumn.setPreferredWidth(225);
		nationalityColumn.setPreferredWidth(190);
		booksOwnedColumn.setPreferredWidth(130);
		tableScrollPane.setViewportView(authorTable);
		fillTable(authors);

		detailsButton.setBackground(Constants.BURNT_YELLOW);
		detailsButton.setFont(Constants.LARGE_FONT);
		detailsButton.setForeground(Constants.WHITE);
		detailsButton.setText("Detalhes");
		detailsButton.setToolTipText("Visualizar detalhes do autor");
		detailsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		detailsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		detailsButton.setMaximumSize(new java.awt.Dimension(175, 40));
		detailsButton.setMinimumSize(new java.awt.Dimension(175, 40));
		detailsButton.setName("Botão de detalhes"); // NOI18N
		detailsButton.setPreferredSize(new java.awt.Dimension(175, 40));
		detailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				detailsButtonActionPerformed(evt);
			}
		});

		editBtn.setBackground(Constants.DARK_BLUE);
		editBtn.setFont(Constants.LARGE_FONT);
		editBtn.setForeground(Constants.WHITE);
		editBtn.setText("Editar");
		editBtn.setToolTipText("Abrir formulário de edição de autor");
		editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editBtn.setMaximumSize(new java.awt.Dimension(175, 40));
		editBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		editBtn.setName("Botão de editar"); // NOI18N
		editBtn.setPreferredSize(new java.awt.Dimension(175, 40));
		editBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editBtnActionPerformed(evt);
			}
		});

		newBtn.setBackground(Constants.GREEN);
		newBtn.setFont(Constants.LARGE_FONT);
		newBtn.setForeground(Constants.WHITE);
		newBtn.setText("Novo");
		newBtn.setToolTipText("Abrir formulário de cadastro de autor");
		newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		newBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newBtn.setMaximumSize(new java.awt.Dimension(175, 40));
		newBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		newBtn.setName("Botão novo autor"); // NOI18N
		newBtn.setPreferredSize(new java.awt.Dimension(175, 40));
		newBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newBtnActionPerformed(evt);
			}
		});

		deleteBtn.setBackground(Constants.RED);
		deleteBtn.setFont(Constants.LARGE_FONT);
		deleteBtn.setForeground(Constants.WHITE);
		deleteBtn.setText("Excluir");
		deleteBtn.setToolTipText("Excluir o autor selecionado");
		deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deleteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteBtn.setMaximumSize(new java.awt.Dimension(175, 40));
		deleteBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		deleteBtn.setName("Botão de excluir"); // NOI18N
		deleteBtn.setPreferredSize(new java.awt.Dimension(175, 40));
		deleteBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteBtnActionPerformed(evt);
			}
		});

		totalLabel.setBackground(Constants.BACKGROUND_COLOR);
		totalLabel.setFont(Constants.MEDIUM_FONT);
		totalLabel.setForeground(Constants.FONT_COLOR);
		totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		totalLabel.setText(String.format("Total encontrado: %d", authors.size()));
		totalLabel.setFocusable(false);
		totalLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		totalLabel.setMaximumSize(null);
		totalLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		totalLabel.setName("Total registros"); // NOI18N
		totalLabel.setPreferredSize(new java.awt.Dimension(175, 20));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 650,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(detailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(newBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(35, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
						.addContainerGap(45, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void showInternalFrame(JInternalFrame frame) {
		getDesktopPane().add(frame);
		frame.moveToFront();
		frame.requestFocus();
	}

	private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
		try {
			var selectedAuthor = getSelectedAuthor();
			var view = new AuthorDetails(controllerFactory, selectedAuthor);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar abrir a página do autor:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_detailsButtonActionPerformed

	private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
		try {
			var selectedAuthor = getSelectedAuthor();
			var form = new AuthorForm(controllerFactory, selectedAuthor);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de autor:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_editBtnActionPerformed

	private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
		try {
			var form = new AuthorForm(controllerFactory);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de cadastro de autor:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_newBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
		try {
			var selectedAuthor = getSelectedAuthor();

			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o autor %s?\nNão é possível desfazer esta ação!",
							selectedAuthor.getName()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			if (selectedAuthor.getBooksOwned() > 0)
				throw new ValidationException("O autor selecionado possui livros cadastrados no sistema!");

			authorController.delete(selectedAuthor.getId());
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_deleteBtnActionPerformed

	private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
		try {
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar atualizar a tabela de autores:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_formInternalFrameActivated

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable authorTable;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JButton detailsButton;
	private javax.swing.JButton editBtn;
	private javax.swing.JButton newBtn;
	private javax.swing.JScrollPane tableScrollPane;
	private javax.swing.JLabel title;
	private javax.swing.JLabel totalLabel;
	// End of variables declaration//GEN-END:variables
}
