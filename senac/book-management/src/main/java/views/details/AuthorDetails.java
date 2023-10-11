/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.details;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.AuthorController;
import controller.BookController;
import exceptions.ValidationException;
import factory.ControllerFactory;
import models.Author;
import models.Book;
import views.constants.Constants;
import views.forms.AuthorForm;
import views.forms.BookForm;

public class AuthorDetails extends javax.swing.JFrame {
	private ControllerFactory controllerFactory;

	private AuthorController authorController;
	private BookController bookController;
	private DefaultTableModel tableModel;

	private Author author;
	private Set<Book> books;

	public AuthorDetails(ControllerFactory controllerFactory, Author author) {
		this.controllerFactory = controllerFactory;
		initControllers(controllerFactory);
		this.author = author;
		this.books = bookController.getByAuthor(author);
		initComponents();
		fillTable();
	}

	private void initControllers(ControllerFactory controllerFactory) {
		this.authorController = controllerFactory.getAuthorController();
		this.bookController = controllerFactory.getBookController();
	}

	private void fillTable() {
		tableModel.getDataVector().clear();

		if (books.isEmpty()) {
			bookTable.repaint();
			return;
		}

		var booksList = new ArrayList<>(books);
		Collections.sort(booksList);

		booksList.forEach(b -> tableModel.addRow(new Object[] { b.getId(), b.getTitle(), b.getFormat(), b.getPublisher(),
				b.getPages(), b.isRead() ? "Lido" : "Não lido" }));
	}

	private void updateView() {
		this.author = authorController.getById(author.getId());
		this.books = bookController.getByAuthor(author);

		this.nameLabel.setText(author.getName());
		this.nationalityLabel.setText(author.getNationality());
		this.totalLabel.setText(String.format("Total encontrado: %d", books.size()));
		fillTable();

		boolean enabled = !books.isEmpty();
		this.bookDetailsButton.setEnabled(enabled);
		this.editBookBtn.setEnabled(enabled);
		this.deleteBookBtn.setEnabled(enabled);
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
		nameLabel = new javax.swing.JLabel();
		nationalityLabel = new javax.swing.JLabel();
		booksLabel = new javax.swing.JLabel();
		totalLabel = new javax.swing.JLabel();
		authorMenuPanel = new javax.swing.JPanel();
		authorMenuLabel = new javax.swing.JLabel();
		editAuthorBtn = new javax.swing.JButton();
		refreshBtn = new javax.swing.JButton();
		deleteAuthorBtn = new javax.swing.JButton();
		tableScrollPane = new javax.swing.JScrollPane();
		String[] columnNames = { "ID", "Título", "Formato", "Editora", "Nº páginas", "Status" };
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

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(String.format("Autor - %s", author.getName()));
		setBackground(Constants.BACKGROUND_COLOR);
		setMinimumSize(new java.awt.Dimension(875, 470));
		setName("Detalhes autor"); // NOI18N
		setSize(new java.awt.Dimension(875, 470));

		title.setBackground(Constants.BACKGROUND_COLOR);
		title.setFont(Constants.LARGE_FONT);
		title.setForeground(Constants.FONT_COLOR);
		title.setLabelFor(this);
		title.setText("Página de autor");
		title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		title.setFocusable(false);
		title.setName("Página de autor"); // NOI18N
		title.setPreferredSize(new java.awt.Dimension(650, 30));
		title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		nameLabel.setBackground(Constants.BACKGROUND_COLOR);
		nameLabel.setFont(Constants.TITLE_FONT);
		nameLabel.setForeground(Constants.FONT_COLOR);
		nameLabel.setText(author.getName());
		nameLabel.setName("Nome do autor"); // NOI18N
		nameLabel.setPreferredSize(new java.awt.Dimension(650, 30));
		nameLabel.setRequestFocusEnabled(false);
		nameLabel.setVerifyInputWhenFocusTarget(false);
		nameLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		nationalityLabel.setBackground(Constants.BACKGROUND_COLOR);
		nationalityLabel.setFont(Constants.LARGE_FONT);
		nationalityLabel.setForeground(Constants.FONT_COLOR);
		nationalityLabel.setText(author.getNationality());
		nationalityLabel.setMaximumSize(null);
		nationalityLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		nationalityLabel.setName("Nacionalidade do autor"); // NOI18N
		nationalityLabel.setPreferredSize(new java.awt.Dimension(650, 20));
		nationalityLabel.setRequestFocusEnabled(false);
		nationalityLabel.setVerifyInputWhenFocusTarget(false);
		nationalityLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		booksLabel.setBackground(Constants.BACKGROUND_COLOR);
		booksLabel.setFont(Constants.MEDIUM_FONT);
		booksLabel.setForeground(Constants.FONT_COLOR);
		booksLabel.setLabelFor(bookTable);
		booksLabel.setText("Livros");
		booksLabel.setFocusable(false);
		booksLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		booksLabel.setMaximumSize(null);
		booksLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		booksLabel.setName(""); // NOI18N
		booksLabel.setPreferredSize(new java.awt.Dimension(175, 20));

		totalLabel.setBackground(Constants.BACKGROUND_COLOR);
		totalLabel.setFont(Constants.MEDIUM_FONT);
		totalLabel.setForeground(Constants.FONT_COLOR);
		totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		totalLabel.setText(String.format("Total encontrado: %d", books.size()));
		totalLabel.setFocusable(false);
		totalLabel.setMaximumSize(null);
		totalLabel.setMinimumSize(new java.awt.Dimension(70, 20));
		totalLabel.setName("Total registros"); // NOI18N
		totalLabel.setPreferredSize(new java.awt.Dimension(175, 20));

		authorMenuPanel.setBackground(null);
		authorMenuPanel.setForeground(Constants.FONT_COLOR);
		authorMenuPanel.setFocusable(false);
		authorMenuPanel.setFont(Constants.DEFAULT_FONT);
		authorMenuPanel.setMinimumSize(new java.awt.Dimension(115, 150));
		authorMenuPanel.setName(""); // NOI18N
		authorMenuPanel.setPreferredSize(new java.awt.Dimension(115, 150));
		authorMenuPanel.setRequestFocusEnabled(false);
		authorMenuPanel.setVerifyInputWhenFocusTarget(false);

		authorMenuLabel.setBackground(Constants.BACKGROUND_COLOR);
		authorMenuLabel.setFont(Constants.MEDIUM_FONT);
		authorMenuLabel.setForeground(Constants.FONT_COLOR);
		authorMenuLabel.setLabelFor(authorMenuPanel);
		authorMenuLabel.setText("Menu autor");
		authorMenuLabel.setFocusable(false);
		authorMenuLabel.setMinimumSize(new java.awt.Dimension(105, 20));
		authorMenuLabel.setName(""); // NOI18N
		authorMenuLabel.setPreferredSize(new java.awt.Dimension(105, 20));

		editAuthorBtn.setBackground(Constants.BLUE);
		editAuthorBtn.setFont(Constants.MEDIUM_FONT);
		editAuthorBtn.setForeground(Constants.WHITE);
		editAuthorBtn.setText("Editar");
		editAuthorBtn.setToolTipText("Abrir formulário de edição de autor");
		editAuthorBtn.setActionCommand("Editar autor");
		editAuthorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		editAuthorBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editAuthorBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		editAuthorBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		editAuthorBtn.setName("Botão de editar autor"); // NOI18N
		editAuthorBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		editAuthorBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editAuthorBtnActionPerformed(evt);
			}
		});

		refreshBtn.setBackground(Constants.GREEN);
		refreshBtn.setFont(Constants.MEDIUM_FONT);
		refreshBtn.setForeground(Constants.WHITE);
		refreshBtn.setText("Atualizar");
		refreshBtn.setToolTipText("Atualizar a página");
		refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		refreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		refreshBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		refreshBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		refreshBtn.setName("Botão de atualizar"); // NOI18N
		refreshBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		refreshBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				refreshBtnActionPerformed(evt);
			}
		});

		deleteAuthorBtn.setBackground(Constants.RED);
		deleteAuthorBtn.setFont(Constants.MEDIUM_FONT);
		deleteAuthorBtn.setForeground(Constants.WHITE);
		deleteAuthorBtn.setText("Excluir");
		deleteAuthorBtn.setToolTipText(String.format("Excluir o autor %s", author.getName()));
		deleteAuthorBtn.setActionCommand("Excluir autor");
		deleteAuthorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deleteAuthorBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteAuthorBtn.setMaximumSize(new java.awt.Dimension(105, 30));
		deleteAuthorBtn.setMinimumSize(new java.awt.Dimension(105, 30));
		deleteAuthorBtn.setName("Botão de excluir autor"); // NOI18N
		deleteAuthorBtn.setPreferredSize(new java.awt.Dimension(105, 30));
		deleteAuthorBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteAuthorBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout authorMenuPanelLayout = new javax.swing.GroupLayout(authorMenuPanel);
		authorMenuPanel.setLayout(authorMenuPanelLayout);
		authorMenuPanelLayout
				.setHorizontalGroup(authorMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(authorMenuPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(authorMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(authorMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(deleteAuthorBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(editAuthorBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		authorMenuPanelLayout
				.setVerticalGroup(authorMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								authorMenuPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(authorMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(15, 15, 15)
										.addComponent(editAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deleteAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(7, Short.MAX_VALUE)));

		editAuthorBtn.getAccessibleContext().setAccessibleName("Editar autor");
		deleteAuthorBtn.getAccessibleContext().setAccessibleName("Excluir autor");
		deleteAuthorBtn.getAccessibleContext().setAccessibleDescription("Excluir o autor");

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
		TableColumn formatColumn = bookTable.getColumnModel().getColumn(2);
		TableColumn publisherColumn = bookTable.getColumnModel().getColumn(3);
		TableColumn pagesColumn = bookTable.getColumnModel().getColumn(4);
		TableColumn statusColumn = bookTable.getColumnModel().getColumn(5);

		idColumn.setPreferredWidth(50);
		titleColumn.setPreferredWidth(175);
		formatColumn.setPreferredWidth(90);
		publisherColumn.setPreferredWidth(175);
		pagesColumn.setPreferredWidth(80);
		statusColumn.setPreferredWidth(80);
		tableScrollPane.setViewportView(bookTable);
		bookTable.getAccessibleContext().setAccessibleName("Lista de livros");

		bookMenuPanel.setBackground(null);
		bookMenuPanel.setForeground(Constants.FONT_COLOR);
		bookMenuPanel.setFocusable(false);
		bookMenuPanel.setFont(Constants.DEFAULT_FONT);
		bookMenuPanel.setMinimumSize(new java.awt.Dimension(115, 150));
		bookMenuPanel.setName(""); // NOI18N
		bookMenuPanel.setPreferredSize(new java.awt.Dimension(115, 150));
		bookMenuPanel.setRequestFocusEnabled(false);
		bookMenuPanel.setVerifyInputWhenFocusTarget(false);

		bookMenuLabel.setBackground(Constants.BACKGROUND_COLOR);
		bookMenuLabel.setFont(Constants.MEDIUM_FONT);
		bookMenuLabel.setForeground(Constants.FONT_COLOR);
		bookMenuLabel.setLabelFor(bookMenuPanel);
		bookMenuLabel.setText("Menu livro");
		bookMenuLabel.setFocusable(false);
		bookMenuLabel.setMinimumSize(new java.awt.Dimension(105, 20));
		bookMenuLabel.setName(""); // NOI18N
		bookMenuLabel.setPreferredSize(new java.awt.Dimension(105, 20));

		bookDetailsButton.setBackground(Constants.DARK_BLUE);
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
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(bookMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(deleteBookBtn, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(editBookBtn, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bookDetailsButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(bookMenuPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(bookMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bookMenuPanelLayout
				.setVerticalGroup(bookMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								bookMenuPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(bookMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(15, 15, 15)
										.addComponent(bookDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(editBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deleteBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		bookDetailsButton.getAccessibleContext().setAccessibleName("Detalhes do livro");
		editBookBtn.getAccessibleContext().setAccessibleName("Editar livro");
		deleteBookBtn.getAccessibleContext().setAccessibleName("Excluir livro");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(booksLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
										.addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(nationalityLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(authorMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bookMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(35, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(30, 30, 30)
										.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addComponent(nationalityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(25, 25, 25))
								.addGroup(layout.createSequentialGroup()
										.addComponent(authorMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(booksLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(20, 20, 20)
										.addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(bookMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 149,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(45, Short.MAX_VALUE)));

		nameLabel.getAccessibleContext().setAccessibleName("Nome do autor");
		nameLabel.getAccessibleContext().setAccessibleDescription("");
		nationalityLabel.getAccessibleContext().setAccessibleName("Nacionalidade do autor");

		getAccessibleContext().setAccessibleName("Página de autor");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void bookDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookDetailsButtonActionPerformed
		try {
			var selectedBook = getSelectedBook();
			var view = new BookDetails(selectedBook);
			view.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página de detalhes:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_bookDetailsButtonActionPerformed

	private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editBookBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();
			var form = new BookForm(controllerFactory, selectedBook);
			form.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de livro:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_editBookBtnActionPerformed

	private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBookBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();

			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o livros %s?\nNão é possível desfazer esta ação!",
							selectedBook.getTitle()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			bookController.delete(selectedBook.getId());
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_deleteBookBtnActionPerformed

	private void editAuthorBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editAuthorBtnActionPerformed
		try {
			var form = new AuthorForm(controllerFactory, author);
			form.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de autor:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_editAuthorBtnActionPerformed

	private void deleteAuthorBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteAuthorBtnActionPerformed
		try {
			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o autor %s?\nNão é possível desfazer esta ação!",
							author.getName()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			if (author.getBooksOwned() > 0) throw new ValidationException("O autor possui livros cadastrados no sistema!");

			authorController.delete(author.getId());
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_deleteAuthorBtnActionPerformed

	private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshBtnActionPerformed
		try {
			updateView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar atualizar a página:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_refreshBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel authorMenuLabel;
	private javax.swing.JPanel authorMenuPanel;
	private javax.swing.JButton bookDetailsButton;
	private javax.swing.JLabel bookMenuLabel;
	private javax.swing.JPanel bookMenuPanel;
	private javax.swing.JTable bookTable;
	private javax.swing.JLabel booksLabel;
	private javax.swing.JButton deleteAuthorBtn;
	private javax.swing.JButton deleteBookBtn;
	private javax.swing.JButton editAuthorBtn;
	private javax.swing.JButton editBookBtn;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JLabel nationalityLabel;
	private javax.swing.JButton refreshBtn;
	private javax.swing.JScrollPane tableScrollPane;
	private javax.swing.JLabel title;
	private javax.swing.JLabel totalLabel;
	// End of variables declaration//GEN-END:variables
}