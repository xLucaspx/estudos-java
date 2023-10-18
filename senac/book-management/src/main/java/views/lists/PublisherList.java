package views.lists;

import static utils.Lists.getSortedList;

import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.PublisherController;
import exceptions.ValidationException;
import factory.ControllerFactory;
import models.Publisher;
import views.constants.Constants;
import views.details.PublisherDetails;
import views.forms.PublisherForm;

public class PublisherList extends javax.swing.JInternalFrame {
	private final ControllerFactory controllerFactory;
	private final PublisherController publisherController;

	private DefaultTableModel tableModel;

	public PublisherList(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
		this.publisherController = controllerFactory.getPublisherController();
		initComponents();
	}

	private void fillTable(Set<Publisher> publishers) {
		tableModel.getDataVector().clear();

		if (publishers.isEmpty()) {
			publisherTable.repaint();
			return;
		}

		var publisherList = getSortedList(publishers);

		publisherList.forEach(p -> tableModel.addRow(new Object[] { p.getId(), p.getName(), p.getBooksOwned() }));
	}

	private void updateView() {
		var publishers = publisherController.getAll();
		this.totalLabel.setText(String.format("Total encontrado: %d", publishers.size()));
		fillTable(publishers);
	}

	private Publisher getSelectedPublisher() {
		int selectedRow = publisherTable.getSelectedRow();

		if (selectedRow == -1 || selectedRow >= tableModel.getRowCount())
			throw new RuntimeException("Você deve selecionar uma editora!");

		var id = (int) tableModel.getValueAt(selectedRow, 0);
		return publisherController.getById(id);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		title = new javax.swing.JLabel();
		tableScrollPane = new javax.swing.JScrollPane();
		var publishers = publisherController.getAll();
		String[] columnNames = { "ID", "Nome", "Livros obtidos" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		publisherTable = new javax.swing.JTable();
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
		setTitle("Lista de editoras");
		setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/publisher-icon.png"))); // NOI18N
		setMinimumSize(new java.awt.Dimension(728, 600));
		setName("Lista de editoras"); // NOI18N
		setNormalBounds(new java.awt.Rectangle(0, 0, 728, 646));
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
		title.setText("Editoras");
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
		tableScrollPane.setMinimumSize(new java.awt.Dimension(480, 500));
		tableScrollPane.setName("Painel da tabela"); // NOI18N

		publisherTable.setBackground(Constants.WHITE);
		publisherTable.setFont(Constants.DEFAULT_FONT);
		publisherTable.setForeground(Constants.FONT_COLOR);
		publisherTable.setModel(tableModel);
		publisherTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		publisherTable.setGridColor(Constants.FONT_COLOR);
		publisherTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
		publisherTable.setMaximumSize(null);
		publisherTable.setMinimumSize(new java.awt.Dimension(480, 500));
		publisherTable.setName("Lista de editoras"); // NOI18N
		publisherTable.setPreferredSize(null);
		publisherTable.setRowHeight(25);
		publisherTable.setSelectionBackground(Constants.DARK_GREEN);
		publisherTable.setSelectionForeground(Constants.WHITE);
		publisherTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		publisherTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		publisherTable.setShowGrid(false);
		publisherTable.setShowHorizontalLines(true);
		publisherTable.getTableHeader().setReorderingAllowed(false);
		TableColumn idColumn = publisherTable.getColumnModel().getColumn(0);
		TableColumn nameColumn = publisherTable.getColumnModel().getColumn(1);
		TableColumn booksOwnedColumn = publisherTable.getColumnModel().getColumn(2);

		idColumn.setPreferredWidth(100);
		nameColumn.setPreferredWidth(255);
		booksOwnedColumn.setPreferredWidth(125);
		tableScrollPane.setViewportView(publisherTable);
		fillTable(publishers);

		detailsButton.setBackground(Constants.BURNT_YELLOW);
		detailsButton.setFont(Constants.LARGE_FONT);
		detailsButton.setForeground(Constants.WHITE);
		detailsButton.setText("Detalhes");
		detailsButton.setToolTipText("Visualizar detalhes da editora");
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
		editBtn.setToolTipText("Abrir formulário de alteração de editora");
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
		newBtn.setText("Nova");
		newBtn.setToolTipText("Abrir formulário de cadastro de editora");
		newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		newBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newBtn.setMaximumSize(new java.awt.Dimension(175, 40));
		newBtn.setMinimumSize(new java.awt.Dimension(175, 40));
		newBtn.setName("Botão nova categoria"); // NOI18N
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
		deleteBtn.setToolTipText("Excluir a editora selecionada");
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
		totalLabel.setText(String.format("Total encontrado: %d", publishers.size()));
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
								.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
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
								.addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(35, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(35, Short.MAX_VALUE)
								.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 489,
												javax.swing.GroupLayout.PREFERRED_SIZE))
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
			var selectedPublisher = getSelectedPublisher();
			var view = new PublisherDetails(controllerFactory, selectedPublisher);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página da editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_detailsButtonActionPerformed

	private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
		try {
			var selectedPublisher = getSelectedPublisher();
			var form = new PublisherForm(controllerFactory, selectedPublisher);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de alteração de editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_editBtnActionPerformed

	private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
		try {
			var form = new PublisherForm(controllerFactory);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de cadastro de editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_newBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
		try {
			var selectedPublisher = getSelectedPublisher();

			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir a editora %s?\nNão é possível desfazer esta ação!",
							selectedPublisher.getName()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			if (selectedPublisher.getBooksOwned() > 0)
				throw new ValidationException("A editora selecionada possui livros cadastrados no sistema!");

			publisherController.delete(selectedPublisher.getId());
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
					String.format("Erro ao tentar atualizar a tabela de editoras:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_formInternalFrameActivated

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton deleteBtn;
	private javax.swing.JButton detailsButton;
	private javax.swing.JButton editBtn;
	private javax.swing.JButton newBtn;
	private javax.swing.JTable publisherTable;
	private javax.swing.JScrollPane tableScrollPane;
	private javax.swing.JLabel title;
	private javax.swing.JLabel totalLabel;
	// End of variables declaration//GEN-END:variables
}
