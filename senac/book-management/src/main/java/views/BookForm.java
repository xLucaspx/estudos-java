package views;

import controller.AuthorController;
import controller.BookController;
import controller.CategoryController;
import controller.FormatController;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import models.Book;
import models.Author;
import models.Format;
import models.Category;
import views.constants.Constants;

public class BookForm extends javax.swing.JFrame {

  private final BookController bookController;
  private final AuthorController authorController;
  private final FormatController formatController;
  private final CategoryController categoryController;

  private Set<Author> authors;
  private Set<Format> formats;
  private Set<Category> categories;
  private Book book;

  public BookForm() {
    this.bookController = new BookController();
    this.authorController = new AuthorController();
    this.formatController = new FormatController();
    this.categoryController = new CategoryController();
    this.authors = authorController.getAll();
    this.formats = formatController.getAll();
    this.categories = categoryController.getAll();
    initComponents();
  }

  public BookForm(Book book) {
    this.bookController = new BookController();
    this.authorController = new AuthorController();
    this.formatController = new FormatController();
    this.categoryController = new CategoryController();
    this.authors = authorController.getAll();
    this.formats = formatController.getAll();
    this.categories = categoryController.getAll();
    this.book = book;
    initComponents();
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    titleInput = new javax.swing.JTextField();
    isbnLabel = new javax.swing.JLabel();
    isbnInput = new javax.swing.JTextField();
    authorLabel = new javax.swing.JLabel();
    authorCombo = new javax.swing.JComboBox<>();
    formatLabel = new javax.swing.JLabel();
    formatCombo = new javax.swing.JComboBox<>();
    purchaseDateLabel = new javax.swing.JLabel();
    purchaseDateInput = new javax.swing.JFormattedTextField();
    priceLabel = new javax.swing.JLabel();
    priceInput = new javax.swing.JFormattedTextField();
    pagesLabel = new javax.swing.JLabel();
    pagesInput = new javax.swing.JFormattedTextField();
    readCheckbox = new javax.swing.JCheckBox();
    saveBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(book != null ? "Edição de livro" : "Cadastro de livro");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(new java.awt.Dimension(925, 600));
    setMinimumSize(new java.awt.Dimension(925, 600));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(925, 600));
    setResizable(false);
    setSize(new java.awt.Dimension(925, 600));

    title.setBackground(Constants.BACKGROUND_COLOR);
    title.setFont(Constants.TITLE_FONT);
    title.setForeground(Constants.FONT_COLOR);
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText(book != null ? "Editar livro" : "Cadastrar livro");
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

    titleLabel.setBackground(Constants.BACKGROUND_COLOR);
    titleLabel.setFont(Constants.DEFAULT_FONT);
    titleLabel.setForeground(Constants.FONT_COLOR);
    titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    titleLabel.setLabelFor(titleInput);
    titleLabel.setText("Título");
    titleLabel.setFocusable(false);
    titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    titleLabel.setName("Label título"); // NOI18N
    titleLabel.setRequestFocusEnabled(false);
    titleLabel.setVerifyInputWhenFocusTarget(false);

    titleInput.setBackground(Constants.WHITE);
    titleInput.setColumns(25);
    titleInput.setFont(Constants.DEFAULT_FONT);
    titleInput.setForeground(Constants.FONT_COLOR);
    titleInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    titleInput.setText(book != null ? book.getTitle() : "");
    titleInput.setToolTipText("Insira o título do livro");
    titleInput.setCaretColor(Constants.FONT_COLOR);
    titleInput.setMaximumSize(new java.awt.Dimension(295, 30));
    titleInput.setMinimumSize(new java.awt.Dimension(295, 30));
    titleInput.setName("Título do livro"); // NOI18N
    titleInput.setNextFocusableComponent(isbnInput);
    titleInput.setPreferredSize(new java.awt.Dimension(295, 30));
    titleInput.setSelectedTextColor(Constants.WHITE);
    titleInput.setSelectionColor(Constants.DARK_BLUE);

    isbnLabel.setBackground(Constants.BACKGROUND_COLOR);
    isbnLabel.setFont(Constants.DEFAULT_FONT);
    isbnLabel.setForeground(Constants.FONT_COLOR);
    isbnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    isbnLabel.setLabelFor(isbnInput);
    isbnLabel.setText("ISBN");
    isbnLabel.setFocusable(false);
    isbnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    isbnLabel.setName("Label ISBN"); // NOI18N
    isbnLabel.setRequestFocusEnabled(false);
    isbnLabel.setVerifyInputWhenFocusTarget(false);

    isbnInput.setBackground(Constants.WHITE);
    isbnInput.setColumns(25);
    isbnInput.setFont(Constants.DEFAULT_FONT);
    isbnInput.setForeground(Constants.FONT_COLOR);
    isbnInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    isbnInput.setText(book != null ? book.getIsbn() : "");
    isbnInput.setToolTipText("Insira o ISBN do livro");
    isbnInput.setCaretColor(Constants.FONT_COLOR);
    isbnInput.setMaximumSize(new java.awt.Dimension(295, 30));
    isbnInput.setMinimumSize(new java.awt.Dimension(295, 30));
    isbnInput.setName("ISBN do livro"); // NOI18N
    isbnInput.setNextFocusableComponent(authorCombo);
    isbnInput.setPreferredSize(new java.awt.Dimension(295, 30));
    isbnInput.setSelectedTextColor(Constants.WHITE);
    isbnInput.setSelectionColor(Constants.DARK_BLUE);

    authorLabel.setBackground(Constants.BACKGROUND_COLOR);
    authorLabel.setFont(Constants.DEFAULT_FONT);
    authorLabel.setForeground(Constants.FONT_COLOR);
    authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    authorLabel.setLabelFor(titleInput);
    authorLabel.setText("Autor");
    authorLabel.setFocusable(false);
    authorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    authorLabel.setName("Label título"); // NOI18N
    authorLabel.setRequestFocusEnabled(false);
    authorLabel.setVerifyInputWhenFocusTarget(false);

    authorCombo.setBackground(Constants.WHITE);
    authorCombo.setEditable(true);
    authorCombo.setFont(Constants.DEFAULT_FONT);
    authorCombo.setForeground(Constants.FONT_COLOR);
    authorCombo.setMaximumRowCount(authors.size());
    authorCombo.setModel(new DefaultComboBoxModel<Author>(new Vector<Author>(authors)));
    authorCombo.setSelectedItem(book != null ? book.getAuthor() : null);
    authorCombo.setToolTipText("Selecione o autor do livro");
    authorCombo.setMaximumSize(new java.awt.Dimension(295, 30));
    authorCombo.setMinimumSize(new java.awt.Dimension(295, 30));
    authorCombo.setName("Autor"); // NOI18N
    authorCombo.setNextFocusableComponent(formatCombo);
    authorCombo.setPreferredSize(new java.awt.Dimension(295, 30));

    formatLabel.setBackground(Constants.BACKGROUND_COLOR);
    formatLabel.setFont(Constants.DEFAULT_FONT);
    formatLabel.setForeground(Constants.FONT_COLOR);
    formatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    formatLabel.setLabelFor(titleInput);
    formatLabel.setText("Formato");
    formatLabel.setFocusable(false);
    formatLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    formatLabel.setName("Label título"); // NOI18N
    formatLabel.setRequestFocusEnabled(false);
    formatLabel.setVerifyInputWhenFocusTarget(false);

    formatCombo.setBackground(Constants.WHITE);
    formatCombo.setEditable(true);
    formatCombo.setFont(Constants.DEFAULT_FONT);
    formatCombo.setForeground(Constants.FONT_COLOR);
    formatCombo.setMaximumRowCount(formats.size());
    formatCombo.setModel(new DefaultComboBoxModel<Format>(new Vector<Format>(formats)));
    formatCombo.setSelectedItem(book != null ? book.getFormat() : "");
    formatCombo.setToolTipText("Selecione o formato do livro");
    formatCombo.setMaximumSize(new java.awt.Dimension(295, 30));
    formatCombo.setMinimumSize(new java.awt.Dimension(295, 30));
    formatCombo.setName("Formato"); // NOI18N
    formatCombo.setNextFocusableComponent(purchaseDateInput);
    formatCombo.setPreferredSize(new java.awt.Dimension(295, 30));

    purchaseDateLabel.setBackground(Constants.BACKGROUND_COLOR);
    purchaseDateLabel.setFont(Constants.DEFAULT_FONT);
    purchaseDateLabel.setForeground(Constants.FONT_COLOR);
    purchaseDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    purchaseDateLabel.setLabelFor(titleInput);
    purchaseDateLabel.setText("Data da compra");
    purchaseDateLabel.setFocusable(false);
    purchaseDateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    purchaseDateLabel.setName("Label título"); // NOI18N
    purchaseDateLabel.setRequestFocusEnabled(false);
    purchaseDateLabel.setVerifyInputWhenFocusTarget(false);

    purchaseDateInput.setBackground(Constants.WHITE);
    purchaseDateInput.setColumns(10);
    purchaseDateInput.setForeground(Constants.FONT_COLOR);
    purchaseDateInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    purchaseDateInput.setText(book != null ? DateTimeFormatter.ofPattern("dd/MM/yyyy").format(book.getPurchaseDate()) : "dd/MM/aaaa");
    purchaseDateInput.setToolTipText("Insira a data da compra no formato dd/MM/aaaa");
    purchaseDateInput.setCaretColor(Constants.FONT_COLOR);
    purchaseDateInput.setFont(Constants.DEFAULT_FONT);
    purchaseDateInput.setMaximumSize(new java.awt.Dimension(130, 30));
    purchaseDateInput.setMinimumSize(new java.awt.Dimension(130, 30));
    purchaseDateInput.setName("Data da compra"); // NOI18N
    purchaseDateInput.setNextFocusableComponent(priceInput);
    purchaseDateInput.setPreferredSize(new java.awt.Dimension(130, 30));
    purchaseDateInput.setSelectedTextColor(Constants.WHITE);
    purchaseDateInput.setSelectionColor(Constants.DARK_BLUE);

    priceLabel.setBackground(Constants.BACKGROUND_COLOR);
    priceLabel.setFont(Constants.DEFAULT_FONT);
    priceLabel.setForeground(Constants.FONT_COLOR);
    priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    priceLabel.setLabelFor(titleInput);
    priceLabel.setText("Preço");
    priceLabel.setFocusable(false);
    priceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    priceLabel.setName("Label título"); // NOI18N
    priceLabel.setRequestFocusEnabled(false);
    priceLabel.setVerifyInputWhenFocusTarget(false);

    priceInput.setBackground(Constants.WHITE);
    priceInput.setColumns(10);
    priceInput.setForeground(Constants.FONT_COLOR);
    priceInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    priceInput.setText(book != null ? String.format("%.2f", book.getPrice()) : "");
    priceInput.setToolTipText("Insira o preço do livro, apenas números e vírgula");
    priceInput.setCaretColor(Constants.FONT_COLOR);
    priceInput.setFont(Constants.DEFAULT_FONT);
    priceInput.setMaximumSize(new java.awt.Dimension(130, 30));
    priceInput.setMinimumSize(new java.awt.Dimension(130, 30));
    priceInput.setName("Preço do livro"); // NOI18N
    priceInput.setNextFocusableComponent(pagesInput);
    priceInput.setPreferredSize(new java.awt.Dimension(130, 30));
    priceInput.setSelectedTextColor(Constants.WHITE);
    priceInput.setSelectionColor(Constants.DARK_BLUE);

    pagesLabel.setBackground(Constants.BACKGROUND_COLOR);
    pagesLabel.setFont(Constants.DEFAULT_FONT);
    pagesLabel.setForeground(Constants.FONT_COLOR);
    pagesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    pagesLabel.setLabelFor(titleInput);
    pagesLabel.setText("Nº de páginas");
    pagesLabel.setFocusable(false);
    pagesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    pagesLabel.setName("Label título"); // NOI18N
    pagesLabel.setRequestFocusEnabled(false);
    pagesLabel.setVerifyInputWhenFocusTarget(false);

    pagesInput.setBackground(Constants.WHITE);
    pagesInput.setColumns(10);
    pagesInput.setForeground(Constants.FONT_COLOR);
    pagesInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    pagesInput.setText(book != null ? String.format("%d", book.getPages()) : "");
    pagesInput.setToolTipText("Insira o número de páginas do livro");
    pagesInput.setCaretColor(Constants.FONT_COLOR);
    pagesInput.setFont(Constants.DEFAULT_FONT);
    pagesInput.setMaximumSize(new java.awt.Dimension(100, 30));
    pagesInput.setMinimumSize(new java.awt.Dimension(100, 30));
    pagesInput.setName("Número de páginas"); // NOI18N
    pagesInput.setNextFocusableComponent(readCheckbox);
    pagesInput.setPreferredSize(new java.awt.Dimension(100, 30));
    pagesInput.setSelectedTextColor(Constants.WHITE);
    pagesInput.setSelectionColor(Constants.DARK_BLUE);

    readCheckbox.setBackground(Constants.BACKGROUND_COLOR);
    readCheckbox.setFont(Constants.DEFAULT_FONT);
    readCheckbox.setForeground(Constants.FONT_COLOR);
    readCheckbox.setSelected(book != null ? book.isRead() : false);
    readCheckbox.setText("Leitura concluída");
    readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
    readCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    readCheckbox.setMaximumSize(new java.awt.Dimension(170, 30));
    readCheckbox.setMinimumSize(new java.awt.Dimension(170, 30));
    readCheckbox.setName("Checkbox leitura concluída"); // NOI18N
    readCheckbox.setPreferredSize(new java.awt.Dimension(170, 30));

    saveBtn.setBackground(Constants.BLUE);
    saveBtn.setFont(Constants.MEDIUM_FONT);
    saveBtn.setForeground(Constants.WHITE);
    saveBtn.setText(book != null ? "Editar" : "Cadastrar");
    saveBtn.setToolTipText(book != null ? String.format("Editar o livro %s", book.getTitle()) : "Cadastrar novo livro");
    saveBtn.setActionCommand("Salvar");
    saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    saveBtn.setLabel(book != null ? "Editar" : "Cadastrar");
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
            .addGap(145, 145, 145)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(titleLabel)
                      .addComponent(authorLabel)))
                  .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(purchaseDateLabel)
                .addGap(81, 81, 81)
                .addComponent(priceLabel))
              .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(isbnLabel)
                      .addComponent(formatLabel)))
                  .addComponent(isbnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(readCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
              .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(pagesLabel))))
          .addGroup(layout.createSequentialGroup()
            .addGap(315, 315, 315)
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(262, 262, 262)
            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(145, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(titleLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(isbnLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(isbnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(29, 29, 29)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(authorLabel)
            .addGap(36, 36, 36))
          .addGroup(layout.createSequentialGroup()
            .addComponent(formatLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(29, 29, 29)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(pagesLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(purchaseDateLabel)
              .addComponent(priceLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(purchaseDateInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(priceInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(51, 51, 51))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    titleInput.getAccessibleContext().setAccessibleName("Input título");
    isbnInput.getAccessibleContext().setAccessibleName("Input ISBN");
    authorCombo.getAccessibleContext().setAccessibleName("Combo autor");
    formatCombo.getAccessibleContext().setAccessibleName("Combo formato");
    purchaseDateInput.getAccessibleContext().setAccessibleName("Input data da compra");
    priceInput.getAccessibleContext().setAccessibleName("");
    pagesInput.getAccessibleContext().setAccessibleName("Input número de páginas");
    readCheckbox.getAccessibleContext().setAccessibleDescription("Alternar leitura concluída/não concluída");
    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informações do livro");

    getAccessibleContext().setAccessibleName("Formulário de livros");

    pack();
  }// </editor-fold>//GEN-END:initComponents


  private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
//    BookDto bookData = ;
//    String msg;
//
//    try {
//      if (book != null) {
//        bookController.update(book.getId(), bookData);
//        msg = "Livro atualizado com sucesso!";
//      } else {
//        bookController.create(bookData);
//        msg = "Livro cadastrado com sucesso!";
//      }
//
//      JOptionPane.showMessageDialog(this, msg, getTitle(), JOptionPane.INFORMATION_MESSAGE);
//      dispose();
//    } catch (Exception e) {
//      JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
//    }
  }//GEN-LAST:event_saveBtnActionPerformed

  private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
    dispose();
  }//GEN-LAST:event_cancelBtnActionPerformed

  @Override
  public void dispose() {
    bookController.closeConnection();
    authorController.closeConnection();
    formatController.closeConnection();
    categoryController.closeConnection();
    super.dispose();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<Author> authorCombo;
  private javax.swing.JLabel authorLabel;
  private javax.swing.JButton cancelBtn;
  private javax.swing.JComboBox<Format> formatCombo;
  private javax.swing.JLabel formatLabel;
  private javax.swing.JTextField isbnInput;
  private javax.swing.JLabel isbnLabel;
  private javax.swing.JFormattedTextField pagesInput;
  private javax.swing.JLabel pagesLabel;
  private javax.swing.JFormattedTextField priceInput;
  private javax.swing.JLabel priceLabel;
  private javax.swing.JFormattedTextField purchaseDateInput;
  private javax.swing.JLabel purchaseDateLabel;
  private javax.swing.JCheckBox readCheckbox;
  private javax.swing.JButton saveBtn;
  private javax.swing.JLabel title;
  private javax.swing.JTextField titleInput;
  private javax.swing.JLabel titleLabel;
  // End of variables declaration//GEN-END:variables
}