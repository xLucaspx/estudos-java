package views.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.BookController;
import factory.ControllerFactory;
import models.Book;
import views.constants.Constants;
import views.forms.BookForm;

public class BookList extends javax.swing.JFrame {
	private ControllerFactory controllerFactory;

	private final BookController bookController;
	private Set<Book> books;

	private DefaultTableModel tableModel;

	public BookList(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
		this.bookController = controllerFactory.getBookController();
		this.books = bookController.getAll();
		initComponents();
		fillTable();
	}

	private void fillTable() {
		tableModel.getDataVector().clear();

		var bookList = new ArrayList<>(books);
		Collections.sort(bookList);

		bookList.forEach(b -> tableModel.addRow(new Object[] { b.getId(), b.getTitle(), b.getAuthor(), b.getFormat(),
				b.getPublisher(), b.getPages(), b.isRead() ? "Lido" : "Não lido" }));
	}

	private void updateView(Set<Book> books) {
		this.books = books;
		this.totalLabel.setText(String.format("Total encontrado: %d", books.size()));
		fillTable();
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
    tableScrollPane = new javax.swing.JScrollPane();
    String[] columnNames = {
      "ID",
      "Título",
      "Autor",
      "Formato",
      "Editora",
      "Nº páginas",
      "Status"
    };
    tableModel = new DefaultTableModel(columnNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    bookTable = new javax.swing.JTable();
    detailsButton = new javax.swing.JButton();
    editBtn = new javax.swing.JButton();
    statusBtn = new javax.swing.JButton();
    newBtn = new javax.swing.JButton();
    refreshBtn = new javax.swing.JButton();
    deleteBtn = new javax.swing.JButton();
    totalLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Lista de livros");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(null);
    setMinimumSize(new java.awt.Dimension(1090, 625));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(1120, 625));
    setSize(new java.awt.Dimension(975, 625));

    title.setBackground(Constants.BACKGROUND_COLOR);
    title.setFont(Constants.TITLE_FONT);
    title.setForeground(Constants.FONT_COLOR);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText("Livros");
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
    tableScrollPane.setMinimumSize(new java.awt.Dimension(840, 500));
    tableScrollPane.setName("Painel da tabela"); // NOI18N

    bookTable.setBackground(Constants.WHITE);
    bookTable.setFont(Constants.DEFAULT_FONT);
    bookTable.setForeground(Constants.FONT_COLOR);
    bookTable.setModel(tableModel);
    bookTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    bookTable.setGridColor(Constants.FONT_COLOR);
    bookTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
    bookTable.setMaximumSize(null);
    bookTable.setMinimumSize(new java.awt.Dimension(840, 500));
    bookTable.setName("Lista de livros"); // NOI18N
    bookTable.setNextFocusableComponent(detailsButton);
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
    TableColumn publisherColumn = bookTable.getColumnModel().getColumn(4);
    TableColumn pagesColumn = bookTable.getColumnModel().getColumn(5);
    TableColumn statusColumn = bookTable.getColumnModel().getColumn(6);

    idColumn.setPreferredWidth(45);
    titleColumn.setPreferredWidth(202);
    authorColumn.setPreferredWidth(188);
    formatColumn.setPreferredWidth(105);
    publisherColumn.setPreferredWidth(160);
    pagesColumn.setPreferredWidth(67);
    statusColumn.setPreferredWidth(73);
    tableScrollPane.setViewportView(bookTable);
    bookTable.getAccessibleContext().setAccessibleName("Lista de livros");

    detailsButton.setBackground(Constants.BLUE);
    detailsButton.setFont(Constants.LARGE_FONT);
    detailsButton.setForeground(Constants.WHITE);
    detailsButton.setText("Detalhes");
    detailsButton.setToolTipText("Visualizar detalhes do livro");
    detailsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    detailsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    detailsButton.setMaximumSize(new java.awt.Dimension(175, 40));
    detailsButton.setMinimumSize(new java.awt.Dimension(175, 40));
    detailsButton.setName("Botão de detalhes"); // NOI18N
    detailsButton.setNextFocusableComponent(editBtn);
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
    editBtn.setToolTipText("Abrir formulário de edição de livro");
    editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    editBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    editBtn.setName("Botão de editar"); // NOI18N
    editBtn.setNextFocusableComponent(statusBtn);
    editBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    editBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editBtnActionPerformed(evt);
      }
    });

    statusBtn.setBackground(Constants.BURNT_YELLOW);
    statusBtn.setFont(Constants.LARGE_FONT);
    statusBtn.setForeground(Constants.WHITE);
    statusBtn.setText("Alterar status");
    statusBtn.setToolTipText("Alternar status do livro entre lido/não lido");
    statusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    statusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    statusBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    statusBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    statusBtn.setName("Botão de alterar status"); // NOI18N
    statusBtn.setNextFocusableComponent(newBtn);
    statusBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    statusBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        statusBtnActionPerformed(evt);
      }
    });

    newBtn.setBackground(Constants.GREEN);
    newBtn.setFont(Constants.LARGE_FONT);
    newBtn.setForeground(Constants.WHITE);
    newBtn.setText("Novo");
    newBtn.setToolTipText("Abrir formulário de cadastro de livro");
    newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    newBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    newBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    newBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    newBtn.setName("Botão novo livro"); // NOI18N
    newBtn.setNextFocusableComponent(refreshBtn);
    newBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    newBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newBtnActionPerformed(evt);
      }
    });

    refreshBtn.setBackground(Constants.DARK_GREEN);
    refreshBtn.setFont(Constants.LARGE_FONT);
    refreshBtn.setForeground(Constants.WHITE);
    refreshBtn.setText("Atualizar");
    refreshBtn.setToolTipText("Atualizar a lista de livros");
    refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    refreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    refreshBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    refreshBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    refreshBtn.setName("Botão de atualizar"); // NOI18N
    refreshBtn.setNextFocusableComponent(deleteBtn);
    refreshBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    refreshBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshBtnActionPerformed(evt);
      }
    });

    deleteBtn.setBackground(Constants.RED);
    deleteBtn.setFont(Constants.LARGE_FONT);
    deleteBtn.setForeground(Constants.WHITE);
    deleteBtn.setText("Excluir");
    deleteBtn.setToolTipText("Excluir o livro selecionado");
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
    totalLabel.setText(String.format("Total encontrado: %d", books.size()));
    totalLabel.setFocusable(false);
    totalLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    totalLabel.setMaximumSize(null);
    totalLabel.setMinimumSize(new java.awt.Dimension(70, 20));
    totalLabel.setName("Total registros"); // NOI18N
    totalLabel.setPreferredSize(new java.awt.Dimension(175, 20));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(detailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(newBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(statusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(35, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(statusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        .addContainerGap(45, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    detailsButton.getAccessibleContext().setAccessibleName("Botão detalhes");
    editBtn.getAccessibleContext().setAccessibleName("Botão editar");
    newBtn.getAccessibleContext().setAccessibleName("Botão novo livro");
    refreshBtn.getAccessibleContext().setAccessibleName("Botão atualizar");
    deleteBtn.getAccessibleContext().setAccessibleName("Botão excluir");

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_detailsButtonActionPerformed
		JOptionPane.showMessageDialog(this, "Esta opção ainda não foi implementada!", getTitle(),
				JOptionPane.INFORMATION_MESSAGE);
	}// GEN-LAST:event_detailsButtonActionPerformed

	private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();
			var form = new BookForm(controllerFactory, selectedBook);
			form.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de livro:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_editBtnActionPerformed

	private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshBtnActionPerformed
		try {
			var books = bookController.getAll();
			updateView(books);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar atualizar a tabela de livros:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_refreshBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();

			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o livros %s?\nNão é possível desfazer esta ação!",
							selectedBook.getTitle()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			bookController.delete(selectedBook.getId());
			var books = bookController.getAll();
			updateView(books);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_deleteBtnActionPerformed

	private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newBtnActionPerformed
		var form = new BookForm(controllerFactory);
		form.setVisible(true);
	}// GEN-LAST:event_newBtnActionPerformed

	private void statusBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_statusBtnActionPerformed
		try {
			var selectedBook = getSelectedBook();

			String[] options = { "Sim", "Não" };
			String newStatus = selectedBook.isRead() ? "Não lido" : "Lido";
			int res = JOptionPane.showOptionDialog(this,
					String.format("Deseja marcar o livro %s como %s?", selectedBook.getTitle(), newStatus), getTitle(),
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			bookController.updateReadStatus(selectedBook);
			var books = bookController.getAll();
			updateView(books);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar alterar o status:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_statusBtnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable bookTable;
  private javax.swing.JButton deleteBtn;
  private javax.swing.JButton detailsButton;
  private javax.swing.JButton editBtn;
  private javax.swing.JButton newBtn;
  private javax.swing.JButton refreshBtn;
  private javax.swing.JButton statusBtn;
  private javax.swing.JScrollPane tableScrollPane;
  private javax.swing.JLabel title;
  private javax.swing.JLabel totalLabel;
  // End of variables declaration//GEN-END:variables
}
