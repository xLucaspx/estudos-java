package views.details;

import static utils.Lists.getSortedList;

import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.BookController;
import controller.PublisherController;
import exceptions.ValidationException;
import factory.ControllerFactory;
import models.Book;
import models.Publisher;
import views.constants.Constants;
import views.forms.BookForm;
import views.forms.PublisherForm;

public class PublisherDetails extends javax.swing.JInternalFrame {
	private final ControllerFactory controllerFactory;
	private final PublisherController publisherController;
	private final BookController bookController;

	private Publisher publisher;

	private DefaultTableModel tableModel;

	public PublisherDetails(ControllerFactory controllerFactory, Publisher publisher) {
		this.controllerFactory = controllerFactory;
		this.publisherController = controllerFactory.getPublisherController();
		this.bookController = controllerFactory.getBookController();
		this.publisher = publisher;
		initComponents();
	}

	private void fillTable(Set<Book> books) {
		tableModel.getDataVector().clear();

		if (books.isEmpty()) {
			bookTable.repaint();
			return;
		}

		var booksList = getSortedList(books);

		booksList.forEach(b -> tableModel.addRow(new Object[] { b.getId(), b.getTitle(), b.getAuthor(), b.getFormat(),
				b.getPages(), b.isRead() ? "Lido" : "Não lido" }));
	}

	private void updateView() {
		this.publisher = publisherController.getById(publisher.getId());
		var books = bookController.getByPublisher(publisher);

		setTitle(String.format("%s - Editora", publisher.getName()));
		publisherName.setText(publisher.getName());
		totalLabel.setText(String.format("Total encontrado: %d", books.size()));
		deletePublisherBtn.setToolTipText(String.format("Excluir a editora %s", publisher.getName()));
		fillTable(books);

		boolean enabled = !books.isEmpty();
		bookDetailsButton.setEnabled(enabled);
		editBookBtn.setEnabled(enabled);
		deleteBookBtn.setEnabled(enabled);
	}

	private Book getSelectedBook() {
		int selectedRow = bookTable.getSelectedRow();

		if (selectedRow == -1 || selectedRow >= tableModel.getRowCount())
			throw new RuntimeException("Você deve selecionar um livro!");

		var id = (int) tableModel.getValueAt(selectedRow, 0);
		return bookController.getById(id);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		title = new javax.swing.JLabel();
		booksLabel = new javax.swing.JLabel();
		totalLabel = new javax.swing.JLabel();
		publisherMenuPanel = new javax.swing.JPanel();
		publisherMenuLabel = new javax.swing.JLabel();
		editPublisherBtn = new javax.swing.JButton();
		deletePublisherBtn = new javax.swing.JButton();
		tableScrollPane = new javax.swing.JScrollPane();
		var books = bookController.getByPublisher(publisher);
		String[] columnNames = { "ID", "Título", "Autor", "Formato", "Nº páginas", "Status" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		bookTable = new javax.swing.JTable();
		bookMenuPanel = new javax.swing.JPanel();
		bookMenuLabel = new javax.swing.JLabel();
		bookDetailsButton = new javax.swing.JButton();
		editBookBtn = new javax.swing.JButton();
		deleteBookBtn = new javax.swing.JButton();
		publisherName = new javax.swing.JTextField();

		setBackground(Constants.BACKGROUND_COLOR);
		setBorder(new javax.swing.border.LineBorder(Constants.BLACK, 2, true));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle(String.format("%s - Editora", publisher.getName()));
		setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/publisher-icon.png"))); // NOI18N
		setMinimumSize(new java.awt.Dimension(867, 497));
		setName("Detalhes editora"); // NOI18N
		setNormalBounds(new java.awt.Rectangle(0, 0, 867, 497));
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

		title.setFont(Constants.LARGE_FONT);
		title.setForeground(Constants.FONT_COLOR);
		title.setLabelFor(this);
		title.setText("Página de editora");
		title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		title.setFocusable(false);
		title.setName("Página de editora"); // NOI18N
		title.setPreferredSize(new java.awt.Dimension(650, 30));
		title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		booksLabel.setFont(Constants.MEDIUM_FONT);
		booksLabel.setForeground(Constants.FONT_COLOR);
		booksLabel.setLabelFor(bookTable);
		booksLabel.setText("Livros");
		booksLabel.setFocusable(false);
		booksLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		booksLabel.setMaximumSize(null);
		booksLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		booksLabel.setName("Livros"); // NOI18N
		booksLabel.setPreferredSize(null);

		totalLabel.setFont(Constants.MEDIUM_FONT);
		totalLabel.setForeground(Constants.FONT_COLOR);
		totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		totalLabel.setText(String.format("Total encontrado: %d", books.size()));
		totalLabel.setFocusable(false);
		totalLabel.setMaximumSize(null);
		totalLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		totalLabel.setName("Total registros"); // NOI18N
		totalLabel.setPreferredSize(null);

		publisherMenuPanel.setBackground(null);
		publisherMenuPanel.setForeground(Constants.FONT_COLOR);
		publisherMenuPanel.setFocusable(false);
		publisherMenuPanel.setFont(Constants.DEFAULT_FONT);
		publisherMenuPanel.setMinimumSize(new java.awt.Dimension(135, 150));
		publisherMenuPanel.setPreferredSize(new java.awt.Dimension(115, 150));
		publisherMenuPanel.setRequestFocusEnabled(false);
		publisherMenuPanel.setVerifyInputWhenFocusTarget(false);

		publisherMenuLabel.setFont(Constants.MEDIUM_FONT);
		publisherMenuLabel.setForeground(Constants.FONT_COLOR);
		publisherMenuLabel.setLabelFor(publisherMenuPanel);
		publisherMenuLabel.setText("Menu editora");
		publisherMenuLabel.setFocusable(false);
		publisherMenuLabel.setMinimumSize(new java.awt.Dimension(105, 20));
		publisherMenuLabel.setName("Menu editora"); // NOI18N
		publisherMenuLabel.setPreferredSize(new java.awt.Dimension(105, 20));

		editPublisherBtn.setBackground(Constants.DARK_BLUE);
		editPublisherBtn.setFont(Constants.MEDIUM_FONT);
		editPublisherBtn.setForeground(Constants.WHITE);
		editPublisherBtn.setText("Editar");
		editPublisherBtn.setToolTipText("Abrir formulário de alteração de editora");
		editPublisherBtn.setActionCommand("Alterar editora");
		editPublisherBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		editPublisherBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editPublisherBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		editPublisherBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		editPublisherBtn.setName("Botão de alterar editora"); // NOI18N
		editPublisherBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		editPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editPublisherBtnActionPerformed(evt);
			}
		});

		deletePublisherBtn.setBackground(Constants.RED);
		deletePublisherBtn.setFont(Constants.MEDIUM_FONT);
		deletePublisherBtn.setForeground(Constants.WHITE);
		deletePublisherBtn.setText("Excluir");
		deletePublisherBtn.setToolTipText(String.format("Excluir a editora %s", publisher.getName()));
		deletePublisherBtn.setActionCommand("Excluir editora");
		deletePublisherBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deletePublisherBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deletePublisherBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		deletePublisherBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		deletePublisherBtn.setName("Botão de excluir editora"); // NOI18N
		deletePublisherBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		deletePublisherBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deletePublisherBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout publisherMenuPanelLayout = new javax.swing.GroupLayout(publisherMenuPanel);
		publisherMenuPanel.setLayout(publisherMenuPanelLayout);
		publisherMenuPanelLayout
				.setHorizontalGroup(publisherMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(publisherMenuPanelLayout.createSequentialGroup()
								.addGap(15, 15, 15)
								.addGroup(publisherMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(editPublisherBtn, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(deletePublisherBtn, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(15, Short.MAX_VALUE))
						.addGroup(publisherMenuPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(publisherMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		publisherMenuPanelLayout
				.setVerticalGroup(publisherMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								publisherMenuPanelLayout.createSequentialGroup()
										.addGap(0, 0, 0)
										.addComponent(publisherMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(editPublisherBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deletePublisherBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tableScrollPane.setBackground(Constants.WHITE);
		tableScrollPane.setForeground(Constants.FONT_COLOR);
		tableScrollPane.setFocusable(false);
		tableScrollPane.setFont(Constants.DEFAULT_FONT);
		tableScrollPane.setMaximumSize(null);
		tableScrollPane.setMinimumSize(new java.awt.Dimension(600, 200));
		tableScrollPane.setName("Painel da tabela"); // NOI18N

		bookTable.setBackground(Constants.WHITE);
		bookTable.setFont(Constants.DEFAULT_FONT);
		bookTable.setForeground(Constants.FONT_COLOR);
		bookTable.setModel(tableModel);
		bookTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		bookTable.setGridColor(Constants.FONT_COLOR);
		bookTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
		bookTable.setMaximumSize(null);
		bookTable.setMinimumSize(new java.awt.Dimension(600, 200));
		bookTable.setName("Lista de livros"); // NOI18N
		bookTable.setPreferredSize(null);
		bookTable.setRowHeight(25);
		bookTable.setSelectionBackground(Constants.DARK_GREEN);
		bookTable.setSelectionForeground(Constants.WHITE);
		bookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		bookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		bookTable.setShowGrid(false);
		bookTable.setShowHorizontalLines(true);
		bookTable.getTableHeader().setReorderingAllowed(false);
		TableColumn idColumn = bookTable.getColumnModel().getColumn(0);
		TableColumn titleColumn = bookTable.getColumnModel().getColumn(1);
		TableColumn authorColumn = bookTable.getColumnModel().getColumn(2);
		TableColumn formatColumn = bookTable.getColumnModel().getColumn(3);
		TableColumn pagesColumn = bookTable.getColumnModel().getColumn(4);
		TableColumn statusColumn = bookTable.getColumnModel().getColumn(5);

		idColumn.setPreferredWidth(50);
		titleColumn.setPreferredWidth(175);
		authorColumn.setPreferredWidth(175);
		formatColumn.setPreferredWidth(90);
		pagesColumn.setPreferredWidth(80);
		statusColumn.setPreferredWidth(80);
		tableScrollPane.setViewportView(bookTable);
		fillTable(books);

		bookMenuPanel.setBackground(null);
		bookMenuPanel.setForeground(Constants.FONT_COLOR);
		bookMenuPanel.setFocusable(false);
		bookMenuPanel.setFont(Constants.DEFAULT_FONT);
		bookMenuPanel.setMinimumSize(new java.awt.Dimension(135, 150));
		bookMenuPanel.setPreferredSize(new java.awt.Dimension(115, 150));
		bookMenuPanel.setRequestFocusEnabled(false);
		bookMenuPanel.setVerifyInputWhenFocusTarget(false);

		bookMenuLabel.setFont(Constants.MEDIUM_FONT);
		bookMenuLabel.setForeground(Constants.FONT_COLOR);
		bookMenuLabel.setLabelFor(bookMenuPanel);
		bookMenuLabel.setText("Menu livro");
		bookMenuLabel.setFocusable(false);
		bookMenuLabel.setMinimumSize(new java.awt.Dimension(105, 20));
		bookMenuLabel.setName("Menu livro"); // NOI18N
		bookMenuLabel.setPreferredSize(new java.awt.Dimension(105, 20));

		bookDetailsButton.setBackground(Constants.BURNT_YELLOW);
		bookDetailsButton.setFont(Constants.MEDIUM_FONT);
		bookDetailsButton.setForeground(Constants.WHITE);
		bookDetailsButton.setText("Detalhes");
		bookDetailsButton.setToolTipText("Visualizar detalhes do livro");
		bookDetailsButton.setActionCommand("Detalhes do livro");
		bookDetailsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bookDetailsButton.setEnabled(!books.isEmpty());
		bookDetailsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bookDetailsButton.setMaximumSize(new java.awt.Dimension(105, 30));
		bookDetailsButton.setMinimumSize(new java.awt.Dimension(105, 30));
		bookDetailsButton.setName("Botão de detalhes do livro"); // NOI18N
		bookDetailsButton.setPreferredSize(new java.awt.Dimension(105, 30));
		bookDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bookDetailsButtonActionPerformed(evt);
			}
		});

		editBookBtn.setBackground(Constants.DARK_GREEN);
		editBookBtn.setFont(Constants.MEDIUM_FONT);
		editBookBtn.setForeground(Constants.WHITE);
		editBookBtn.setText("Editar");
		editBookBtn.setToolTipText("Abrir formulário de edição de livro");
		editBookBtn.setActionCommand("Editar livro");
		editBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		editBookBtn.setEnabled(!books.isEmpty());
		editBookBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editBookBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		editBookBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		editBookBtn.setName("Botão de editar livro"); // NOI18N
		editBookBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		editBookBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editBookBtnActionPerformed(evt);
			}
		});

		deleteBookBtn.setBackground(Constants.DARK_RED);
		deleteBookBtn.setFont(Constants.MEDIUM_FONT);
		deleteBookBtn.setForeground(Constants.WHITE);
		deleteBookBtn.setText("Excluir");
		deleteBookBtn.setToolTipText("Excluir o livro selecionado");
		deleteBookBtn.setActionCommand("Excluir livro");
		deleteBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deleteBookBtn.setEnabled(!books.isEmpty());
		deleteBookBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteBookBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		deleteBookBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		deleteBookBtn.setName("Botão de excluir livro"); // NOI18N
		deleteBookBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		deleteBookBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteBookBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout bookMenuPanelLayout = new javax.swing.GroupLayout(bookMenuPanel);
		bookMenuPanel.setLayout(bookMenuPanelLayout);
		bookMenuPanelLayout
				.setHorizontalGroup(bookMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(bookMenuPanelLayout.createSequentialGroup()
								.addGap(15, 15, 15)
								.addGroup(bookMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(deleteBookBtn, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(editBookBtn, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bookDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(15, Short.MAX_VALUE))
						.addGroup(bookMenuPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(bookMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		bookMenuPanelLayout
				.setVerticalGroup(bookMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								bookMenuPanelLayout.createSequentialGroup()
										.addGap(0, 0, 0)
										.addComponent(bookMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(bookDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(editBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deleteBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		publisherName.setEditable(false);
		publisherName.setBackground(null);
		publisherName.setFont(Constants.TITLE_FONT);
		publisherName.setForeground(Constants.FONT_COLOR);
		publisherName.setText(publisher.getName());
		publisherName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		publisherName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		publisherName.setMargin(new java.awt.Insets(0, 0, 3, 0));
		publisherName.setMinimumSize(new java.awt.Dimension(10, 30));
		publisherName.setName("Nome da categoria"); // NOI18N
		publisherName.setPreferredSize(null);
		publisherName.setSelectedTextColor(Constants.WHITE);
		publisherName.setSelectionColor(Constants.DARK_BLUE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(booksLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
								.addComponent(publisherName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(publisherMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(bookMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(35, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(publisherName, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(publisherMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(bookMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 149,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(booksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
												.addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(20, 20, 20)
										.addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(45, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void showInternalFrame(JInternalFrame frame) {
		getDesktopPane().add(frame);
		frame.moveToFront();
		frame.requestFocus();
	}

	private void editPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPublisherBtnActionPerformed
		try {
			var form = new PublisherForm(controllerFactory, publisher);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de alteração de editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_editPublisherBtnActionPerformed

	private void deletePublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePublisherBtnActionPerformed
		try {
			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir a editora %s?\nNão é possível desfazer esta ação!",
							publisher.getName()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			if (publisher.getBooksOwned() > 0)
				throw new ValidationException("A editora possui livros cadastrados no sistema!");

			publisherController.delete(publisher.getId());
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_deletePublisherBtnActionPerformed

	private void bookDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookDetailsButtonActionPerformed
		try {
			var selectedBook = getSelectedBook();
			var view = new BookDetails(controllerFactory, selectedBook);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar abrir a página do livro:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_bookDetailsButtonActionPerformed

	private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();
			var form = new BookForm(controllerFactory, selectedBook);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de livro:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_editBookBtnActionPerformed

	private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();

			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o livro %s?\nNão é possível desfazer esta ação!",
							selectedBook.getTitle()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			bookController.delete(selectedBook.getId());
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_deleteBookBtnActionPerformed

	private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
		try {
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar atualizar a página:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
			dispose();
		}
	}//GEN-LAST:event_formInternalFrameActivated

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton bookDetailsButton;
	private javax.swing.JLabel bookMenuLabel;
	private javax.swing.JPanel bookMenuPanel;
	private javax.swing.JTable bookTable;
	private javax.swing.JLabel booksLabel;
	private javax.swing.JButton deleteBookBtn;
	private javax.swing.JButton deletePublisherBtn;
	private javax.swing.JButton editBookBtn;
	private javax.swing.JButton editPublisherBtn;
	private javax.swing.JLabel publisherMenuLabel;
	private javax.swing.JPanel publisherMenuPanel;
	private javax.swing.JTextField publisherName;
	private javax.swing.JScrollPane tableScrollPane;
	private javax.swing.JLabel title;
	private javax.swing.JLabel totalLabel;
	// End of variables declaration//GEN-END:variables
}
