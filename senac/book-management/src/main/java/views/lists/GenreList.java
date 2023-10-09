package views.lists;

import controller.GenreController;
import exceptions.ValidationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Genre;
import views.constants.Constants;
import views.forms.GenreForm;

public class GenreList extends javax.swing.JFrame {

  private final GenreController genreController;
  private Set<Genre> genres;

  private DefaultTableModel tableModel;

  public GenreList() {
    this.genreController = new GenreController();
    this.genres = genreController.getAll();
    initComponents();
    fillTable();
  }

  private void fillTable() {
    tableModel.getDataVector().clear();

    var genreList = new ArrayList<>(genres);
    Collections.sort(genreList);

    genreList.forEach(g -> tableModel.addRow(new Object[]{ g.getId(), g.getName(), g.getBooksOwned() }));
  }

  private Genre getSelectedGenre() {
    int selectedRow = genreTable.getSelectedRow();

    if (selectedRow == -1 || selectedRow >= tableModel.getRowCount())
      throw new RuntimeException("Você deve selecionar uma categoria!");

    var id = (int) tableModel.getValueAt(selectedRow, 0);
    return genreController.getById(id);
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    tableScrollPane = new javax.swing.JScrollPane();
    String[] columnNames = { "ID", "Nome", "Livros obtidos" };
    tableModel = new DefaultTableModel(columnNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    genreTable = new javax.swing.JTable();
    detailsButton = new javax.swing.JButton();
    editBtn = new javax.swing.JButton();
    newBtn = new javax.swing.JButton();
    refreshBtn = new javax.swing.JButton();
    deleteBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Categorias");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(null);
    setMinimumSize(new java.awt.Dimension(900, 625));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(900, 625));
    setSize(new java.awt.Dimension(900, 625));

    title.setBackground(Constants.BACKGROUND_COLOR);
    title.setFont(Constants.TITLE_FONT);
    title.setForeground(Constants.FONT_COLOR);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText("Categorias");
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

    genreTable.setBackground(Constants.WHITE);
    genreTable.setFont(Constants.DEFAULT_FONT);
    genreTable.setForeground(Constants.FONT_COLOR);
    genreTable.setModel(tableModel);
    genreTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    genreTable.setGridColor(Constants.FONT_COLOR);
    genreTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
    genreTable.setMaximumSize(null);
    genreTable.setMinimumSize(new java.awt.Dimension(480, 500));
    genreTable.setName("Lista de categorias"); // NOI18N
    genreTable.setNextFocusableComponent(detailsButton);
    genreTable.setPreferredSize(null);
    genreTable.setRowHeight(25);
    genreTable.setSelectionBackground(Constants.DARK_GREEN);
    genreTable.setSelectionForeground(Constants.WHITE);
    genreTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    genreTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    genreTable.setShowGrid(false);
    genreTable.setShowHorizontalLines(true);
    genreTable.getTableHeader().setReorderingAllowed(false);
    TableColumn idColumn = genreTable.getColumnModel().getColumn(0);
    TableColumn nameColumn = genreTable.getColumnModel().getColumn(1);
    TableColumn booksOwnedColumn = genreTable.getColumnModel().getColumn(2);

    idColumn.setPreferredWidth(125);
    nameColumn.setPreferredWidth(230);
    booksOwnedColumn.setPreferredWidth(125);
    tableScrollPane.setViewportView(genreTable);
    genreTable.getAccessibleContext().setAccessibleName("Lista de categorias");

    detailsButton.setBackground(Constants.BLUE);
    detailsButton.setFont(Constants.MEDIUM_FONT);
    detailsButton.setForeground(Constants.WHITE);
    detailsButton.setText("Detalhes");
    detailsButton.setToolTipText("Visualizar detalhes da categoria");
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
    editBtn.setFont(Constants.MEDIUM_FONT);
    editBtn.setForeground(Constants.WHITE);
    editBtn.setText("Editar");
    editBtn.setToolTipText("Abrir formulário de edição de categoria");
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
    newBtn.setFont(Constants.MEDIUM_FONT);
    newBtn.setForeground(Constants.WHITE);
    newBtn.setText("Novo");
    newBtn.setToolTipText("Abrir formulário de cadastro de categoria");
    newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    newBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    newBtn.setMaximumSize(new java.awt.Dimension(175, 40));
    newBtn.setMinimumSize(new java.awt.Dimension(175, 40));
    newBtn.setName("Botão nova categoria"); // NOI18N
    newBtn.setNextFocusableComponent(refreshBtn);
    newBtn.setPreferredSize(new java.awt.Dimension(175, 40));
    newBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newBtnActionPerformed(evt);
      }
    });

    refreshBtn.setBackground(Constants.DARK_GREEN);
    refreshBtn.setFont(Constants.MEDIUM_FONT);
    refreshBtn.setForeground(Constants.WHITE);
    refreshBtn.setText("Atualizar");
    refreshBtn.setToolTipText("Atualizar a lista de categorias");
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
    deleteBtn.setFont(Constants.MEDIUM_FONT);
    deleteBtn.setForeground(Constants.WHITE);
    deleteBtn.setText("Excluir");
    deleteBtn.setToolTipText("Excluir a categoria selecionada");
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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(50, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(50, Short.MAX_VALUE))
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
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        .addContainerGap(45, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    detailsButton.getAccessibleContext().setAccessibleName("Botão detalhes");
    editBtn.getAccessibleContext().setAccessibleName("Botão editar");
    newBtn.getAccessibleContext().setAccessibleName("Botão nova categoria");
    refreshBtn.getAccessibleContext().setAccessibleName("Botão atualizar");
    deleteBtn.getAccessibleContext().setAccessibleName("Botão excluir");

    getAccessibleContext().setAccessibleName("Lista de categorias");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
    JOptionPane.showMessageDialog(this, "Esta opção ainda não foi implementada!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_detailsButtonActionPerformed

  private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
    try {
      var selectedGenre= getSelectedGenre();
      var form = new GenreForm(selectedGenre);
      form.setVisible(true);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Erro ao tentar abrir o formulário de edição de categoria:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_editBtnActionPerformed

  private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
    try {
      this.genres = genreController.getAll();
      fillTable();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Erro ao tentar atualizar a tabela de categorias:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_refreshBtnActionPerformed

  private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
    try {
      var selectedGenre = getSelectedGenre();

      String[] options = { "Sim", "Não" };
      int res = JOptionPane.showOptionDialog(this, String.format("Tem certeza que deseja excluir a categoria %s?\nNão é possível desfazer esta ação!", selectedGenre.getName()), getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

      if (res != 0) return;

      if (selectedGenre.getBooksOwned() > 0)
        throw new ValidationException("A categoria selecionada possui livros cadastrados no sistema!");

      genreController.delete(selectedGenre.getId());
      this.genres = genreController.getAll();
      fillTable();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Erro ao tentar excluir:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_deleteBtnActionPerformed

  private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
    var form = new GenreForm();
    form.setVisible(true);
  }//GEN-LAST:event_newBtnActionPerformed

  @Override
  public void dispose() {
    genreController.closeConnection();
    super.dispose();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton deleteBtn;
  private javax.swing.JButton detailsButton;
  private javax.swing.JButton editBtn;
  private javax.swing.JTable genreTable;
  private javax.swing.JButton newBtn;
  private javax.swing.JButton refreshBtn;
  private javax.swing.JScrollPane tableScrollPane;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
