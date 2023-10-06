package views.lists;

import controller.AuthorController;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Author;
import views.constants.Constants;
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
    cancelBtn = new javax.swing.JButton();
    cancelBtn1 = new javax.swing.JButton();
    cancelBtn3 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Autores");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(new java.awt.Dimension(975, 610));
    setMinimumSize(new java.awt.Dimension(975, 610));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(975, 610));
    setSize(new java.awt.Dimension(975, 610));

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
    tableScrollPane.setFont(Constants.DEFAULT_FONT);

    authorTable.setBackground(Constants.WHITE);
    authorTable.setFont(Constants.DEFAULT_FONT);
    authorTable.setForeground(Constants.FONT_COLOR);
    authorTable.setModel(tableModel);
    authorTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    authorTable.setGridColor(Constants.FONT_COLOR);
    authorTable.setMaximumSize(new java.awt.Dimension(650, 485));
    authorTable.setMinimumSize(new java.awt.Dimension(650, 485));
    authorTable.setName("Lista de autores"); // NOI18N
    authorTable.setPreferredSize(new java.awt.Dimension(650, 485));
    authorTable.setRowHeight(25);
    authorTable.setRowMargin(3);
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
    detailsButton.setFont(Constants.MEDIUM_FONT);
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

    cancelBtn1.setBackground(Constants.RED);
    cancelBtn1.setFont(Constants.MEDIUM_FONT);
    cancelBtn1.setForeground(Constants.WHITE);
    cancelBtn1.setText("Cancelar");
    cancelBtn1.setToolTipText("Descartar alterações e voltar para o menu");
    cancelBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    cancelBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cancelBtn1.setMaximumSize(new java.awt.Dimension(175, 40));
    cancelBtn1.setMinimumSize(new java.awt.Dimension(175, 40));
    cancelBtn1.setName("Botão de cancelar"); // NOI18N
    cancelBtn1.setPreferredSize(new java.awt.Dimension(175, 40));

    cancelBtn3.setBackground(Constants.RED);
    cancelBtn3.setFont(Constants.MEDIUM_FONT);
    cancelBtn3.setForeground(Constants.WHITE);
    cancelBtn3.setText("Cancelar");
    cancelBtn3.setToolTipText("Descartar alterações e voltar para o menu");
    cancelBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    cancelBtn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cancelBtn3.setMaximumSize(new java.awt.Dimension(175, 40));
    cancelBtn3.setMinimumSize(new java.awt.Dimension(175, 40));
    cancelBtn3.setName("Botão de cancelar"); // NOI18N
    cancelBtn3.setPreferredSize(new java.awt.Dimension(175, 40));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(50, 50, 50)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tableScrollPane))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cancelBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(50, 50, 50))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cancelBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(57, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");

    getAccessibleContext().setAccessibleName("Lista de autores");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
    try {
      int selectedRow = authorTable.getSelectedRow();
      
      if (selectedRow == -1)
        throw new RuntimeException("Você deve selecionar um autor!");
      
      int authorId = (int) tableModel.getValueAt(selectedRow, 0);
      
      AuthorForm af = new AuthorForm(authorController.getById(authorId));
      af.setVisible(true);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Erro ao tentar abrir a página do autor:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_detailsButtonActionPerformed
  
  private void fillTable() {
    tableModel.getDataVector().clear();
    
    authors.forEach(a -> {
      tableModel.addRow(new Object[]{a.getId(), a.getName(), a.getNationality(), a.getBooksOwned()});
    });
  }
  
  @Override
  public void dispose() {
    authorController.closeConnection();
    super.dispose();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable authorTable;
  private javax.swing.JButton cancelBtn;
  private javax.swing.JButton cancelBtn1;
  private javax.swing.JButton cancelBtn3;
  private javax.swing.JButton detailsButton;
  private javax.swing.JScrollPane tableScrollPane;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
