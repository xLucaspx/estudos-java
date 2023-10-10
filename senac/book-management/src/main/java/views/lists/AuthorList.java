package views.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.AuthorController;
import exceptions.ValidationException;
import models.Author;
import views.constants.Constants;
import views.details.AuthorDetails;
import views.forms.AuthorForm;

public class AuthorList extends javax.swing.JFrame {

	private final AuthorController authorController;
	private Set<Author> authors;

	private DefaultTableModel tableModel;

	public AuthorList() {
		this.authorController = new AuthorController();
		this.authors = authorController.getAll();
		initComponents();
		fillTable();
	}

	private void fillTable() {
		tableModel.getDataVector().clear();

		var authorsList = new ArrayList<>(authors);
		Collections.sort(authorsList);

		authorsList.forEach(
				a -> tableModel.addRow(new Object[] { a.getId(), a.getName(), a.getNationality(), a.getBooksOwned() }));
	}

	private void updateView(Set<Author> authors) {
		this.authors = authors;
		this.totalLabel.setText(String.format("Total encontrado: %d", authors.size()));
		fillTable();
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
    refreshBtn = new javax.swing.JButton();
    deleteBtn = new javax.swing.JButton();
    totalLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Lista de autores");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(null);
    setMinimumSize(new java.awt.Dimension(975, 625));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(975, 625));
    setSize(new java.awt.Dimension(975, 625));

    title.setBackground(Constants.BACKGROUND_COLOR);
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
    authorTable.setNextFocusableComponent(detailsButton);
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
    authorTable.getAccessibleContext().setAccessibleName("Lista de autores");

    detailsButton.setBackground(Constants.BLUE);
    detailsButton.setFont(Constants.LARGE_FONT);
    detailsButton.setForeground(Constants.WHITE);
    detailsButton.setText("Detalhes");
    detailsButton.setToolTipText("Visualizar detalhes do autor");
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
    editBtn.setToolTipText("Abrir formulário de edição de autor");
    editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    editBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    editBtn.setName("Botão de editar"); // NOI18N
    editBtn.setNextFocusableComponent(newBtn);
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
    refreshBtn.setToolTipText("Atualizar a lista de autores");
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
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(detailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(newBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    newBtn.getAccessibleContext().setAccessibleName("Botão novo autor");
    refreshBtn.getAccessibleContext().setAccessibleName("Botão atualizar");
    deleteBtn.getAccessibleContext().setAccessibleName("Botão excluir");
    totalLabel.getAccessibleContext().setAccessibleName("Total de registros");

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_detailsButtonActionPerformed
		try {
			var selectedAuthor = getSelectedAuthor();
			var view = new AuthorDetails(selectedAuthor);
			view.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página de detalhes:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_detailsButtonActionPerformed

	private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editBtnActionPerformed
		try {
			var selectedAuthor = getSelectedAuthor();
			var form = new AuthorForm(selectedAuthor);
			form.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de autor:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_editBtnActionPerformed

	private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshBtnActionPerformed
		try {
			var authors = authorController.getAll();
			updateView(authors);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar atualizar a tabela de autores:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_refreshBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
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
			var authors = authorController.getAll();
			updateView(authors);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_deleteBtnActionPerformed

	private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newBtnActionPerformed
		var form = new AuthorForm();
		form.setVisible(true);
	}// GEN-LAST:event_newBtnActionPerformed

	@Override
	public void dispose() {
		authorController.closeConnection();
		super.dispose();
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable authorTable;
  private javax.swing.JButton deleteBtn;
  private javax.swing.JButton detailsButton;
  private javax.swing.JButton editBtn;
  private javax.swing.JButton newBtn;
  private javax.swing.JButton refreshBtn;
  private javax.swing.JScrollPane tableScrollPane;
  private javax.swing.JLabel title;
  private javax.swing.JLabel totalLabel;
  // End of variables declaration//GEN-END:variables
}
