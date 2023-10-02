package views;

import controller.AuthorController;
import controller.BookController;
import controller.CategoryController;
import controller.FormatController;
import exceptions.ValidationException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import models.Book;
import models.Author;
import models.Format;
import models.Category;
import models.dto.BookDto;
import views.constants.Constants;

public class BookForm extends javax.swing.JFrame {

  private final BookController bookController;
  private final AuthorController authorController;
  private final FormatController formatController;
  private final CategoryController categoryController;

  private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private final java.text.Format dateFormat = dateFormatter.toFormat();
  private final NumberFormat decimalFormat = DecimalFormat.getInstance();
  private final NumberFormat integerFormat = NumberFormat.getIntegerInstance();

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
    defineCategories(book);
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
    purchaseDateInput = new JFormattedTextField(dateFormat);
    priceLabel = new javax.swing.JLabel();
    decimalFormat.setMaximumFractionDigits(2);
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    priceInput = new JFormattedTextField(decimalFormat);
    pagesLabel = new javax.swing.JLabel();
    readCheckbox = new javax.swing.JCheckBox();
    categoriesPanel = new javax.swing.JPanel();
    categoriesLabel = new javax.swing.JLabel();
    categoryCombo1 = new javax.swing.JComboBox<>();
    categoryCombo2 = new javax.swing.JComboBox<>();
    categoryCombo3 = new javax.swing.JComboBox<>();
    saveBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();
    integerFormat.setMaximumIntegerDigits(5);
    pagesInput = new JFormattedTextField(integerFormat);

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
    isbnInput.setNextFocusableComponent(categoryCombo1);
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
    formatCombo.setFont(Constants.DEFAULT_FONT);
    formatCombo.setForeground(Constants.FONT_COLOR);
    formatCombo.setMaximumRowCount(formats.size());
    formatCombo.setModel(new DefaultComboBoxModel<Format>(new Vector<Format>(formats)));
    formatCombo.setSelectedItem(book != null ? book.getFormat() : null);
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
    purchaseDateInput.setToolTipText("Insira a data da compra no formato dd/MM/aaaa");
    purchaseDateInput.setCaretColor(Constants.FONT_COLOR);
    purchaseDateInput.setFont(Constants.DEFAULT_FONT);
    purchaseDateInput.setMaximumSize(new java.awt.Dimension(120, 30));
    purchaseDateInput.setMinimumSize(new java.awt.Dimension(120, 30));
    purchaseDateInput.setName("Data da compra"); // NOI18N
    purchaseDateInput.setNextFocusableComponent(priceInput);
    purchaseDateInput.setSelectedTextColor(Constants.WHITE);
    purchaseDateInput.setSelectionColor(Constants.DARK_BLUE);
    purchaseDateInput.setValue(book != null ? book.getPurchaseDate() : LocalDate.now());

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
    priceInput.setToolTipText("Insira o preço do livro, apenas números e vírgula");
    priceInput.setCaretColor(Constants.FONT_COLOR);
    priceInput.setFont(Constants.DEFAULT_FONT);
    priceInput.setMaximumSize(new java.awt.Dimension(120, 30));
    priceInput.setMinimumSize(new java.awt.Dimension(120, 30));
    priceInput.setName("Preço do livro"); // NOI18N
    priceInput.setNextFocusableComponent(pagesInput);
    priceInput.setPreferredSize(new java.awt.Dimension(120, 30));
    priceInput.setSelectedTextColor(Constants.WHITE);
    priceInput.setSelectionColor(Constants.DARK_BLUE);
    priceInput.setValue(book != null ? book.getPrice() : 0);

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

    readCheckbox.setBackground(Constants.BACKGROUND_COLOR);
    readCheckbox.setFont(Constants.DEFAULT_FONT);
    readCheckbox.setForeground(Constants.FONT_COLOR);
    readCheckbox.setSelected(book != null ? book.isRead() : false);
    readCheckbox.setText("Leitura concluída");
    readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
    readCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    readCheckbox.setMaximumSize(new java.awt.Dimension(140, 30));
    readCheckbox.setMinimumSize(new java.awt.Dimension(140, 30));
    readCheckbox.setName("Checkbox leitura concluída"); // NOI18N
    readCheckbox.setNextFocusableComponent(categoryCombo1);
    readCheckbox.setPreferredSize(new java.awt.Dimension(140, 30));
    readCheckbox.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        readCheckboxItemStateChanged(evt);
      }
    });

    categoriesPanel.setBackground(Constants.BACKGROUND_COLOR);
    categoriesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Constants.FONT_COLOR, 1, true), "Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, Constants.MEDIUM_FONT, Constants.FONT_COLOR));
    categoriesPanel.setForeground(Constants.FONT_COLOR);
    categoriesPanel.setFocusable(false);
    categoriesPanel.setFont(Constants.DEFAULT_FONT);
    categoriesPanel.setMaximumSize(new java.awt.Dimension(635, 90));
    categoriesPanel.setMinimumSize(new java.awt.Dimension(635, 90));
    categoriesPanel.setName("Painel de categorias"); // NOI18N

    categoriesLabel.setBackground(Constants.BACKGROUND_COLOR);
    categoriesLabel.setFont(Constants.SMALL_FONT);
    categoriesLabel.setForeground(Constants.FONT_COLOR);
    categoriesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    categoriesLabel.setLabelFor(categoriesPanel);
    categoriesLabel.setText("Selecione entre uma e três categorias para o livro");
    categoriesLabel.setFocusable(false);
    categoriesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    categoriesLabel.setMaximumSize(new java.awt.Dimension(623, 16));
    categoriesLabel.setMinimumSize(new java.awt.Dimension(623, 16));
    categoriesLabel.setName("Legenda categorias"); // NOI18N
    categoriesLabel.setPreferredSize(new java.awt.Dimension(623, 16));

    categoryCombo1.setBackground(Constants.WHITE);
    categoryCombo1.setFont(Constants.DEFAULT_FONT);
    categoryCombo1.setForeground(Constants.FONT_COLOR);
    categoryCombo1.setMaximumRowCount(categories.size());
    categoryCombo1.setModel(new DefaultComboBoxModel<Category>(new Vector<>(categories)));
    categoryCombo1.setSelectedItem(null);
    categoryCombo1.setToolTipText("Selecione a categoria 1");
    categoryCombo1.setMaximumSize(new java.awt.Dimension(187, 30));
    categoryCombo1.setMinimumSize(new java.awt.Dimension(187, 30));
    categoryCombo1.setName("Categoria 1"); // NOI18N
    categoryCombo1.setNextFocusableComponent(categoryCombo2);
    categoryCombo1.setPreferredSize(new java.awt.Dimension(187, 30));
    categoryCombo1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        categoryCombo1ActionPerformed(evt);
      }
    });

    categoryCombo2.setBackground(Constants.WHITE);
    categoryCombo2.setFont(Constants.DEFAULT_FONT);
    categoryCombo2.setForeground(Constants.FONT_COLOR);
    categoryCombo2.setMaximumRowCount(categories.size());
    categoryCombo2.setModel(new DefaultComboBoxModel<Category>(new Vector<>(categories)));
    categoryCombo2.setSelectedItem(null);
    categoryCombo2.setToolTipText("Selecione a categoria 2");
    categoryCombo2.setEnabled(categoryCombo1.getSelectedIndex() > 0);
    categoryCombo2.setMaximumSize(new java.awt.Dimension(187, 30));
    categoryCombo2.setMinimumSize(new java.awt.Dimension(187, 30));
    categoryCombo2.setName("Categoria 2"); // NOI18N
    categoryCombo2.setNextFocusableComponent(categoryCombo3);
    categoryCombo2.setPreferredSize(new java.awt.Dimension(187, 30));
    categoryCombo2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        categoryCombo2ActionPerformed(evt);
      }
    });

    categoryCombo3.setBackground(Constants.WHITE);
    categoryCombo3.setFont(Constants.DEFAULT_FONT);
    categoryCombo3.setForeground(Constants.FONT_COLOR);
    categoryCombo3.setMaximumRowCount(categories.size());
    categoryCombo3.setModel(new DefaultComboBoxModel<Category>(new Vector<>(categories)));
    categoryCombo3.setSelectedItem(null);
    categoryCombo3.setToolTipText("Selecione a categoria 3");
    categoryCombo3.setEnabled(categoryCombo1.getSelectedIndex() > 0);
    categoryCombo3.setMaximumSize(new java.awt.Dimension(187, 30));
    categoryCombo3.setMinimumSize(new java.awt.Dimension(187, 30));
    categoryCombo3.setName("Categoria 3"); // NOI18N
    categoryCombo3.setNextFocusableComponent(saveBtn);
    categoryCombo3.setPreferredSize(new java.awt.Dimension(187, 30));

    javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
    categoriesPanel.setLayout(categoriesPanelLayout);
    categoriesPanelLayout.setHorizontalGroup(
      categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(categoriesPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(categoriesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(categoriesPanelLayout.createSequentialGroup()
            .addComponent(categoryCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addComponent(categoryCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addComponent(categoryCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    categoriesPanelLayout.setVerticalGroup(
      categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(categoriesPanelLayout.createSequentialGroup()
        .addComponent(categoriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(categoryCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(categoryCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(categoryCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 20, Short.MAX_VALUE))
    );

    categoriesLabel.getAccessibleContext().setAccessibleName("Legenda categorias");
    categoriesLabel.getAccessibleContext().setAccessibleDescription("Selecione entre uma e três categorias para o livro");
    categoryCombo1.getAccessibleContext().setAccessibleName("Combo categoria 1");
    ((DefaultComboBoxModel) categoryCombo1.getModel()).insertElementAt("", 0);
    categoryCombo2.getAccessibleContext().setAccessibleName("Combo categoria 2");
    ((DefaultComboBoxModel) categoryCombo2.getModel()).insertElementAt("", 0);
    categoryCombo3.getAccessibleContext().setAccessibleName("Combo categoria 3");
    ((DefaultComboBoxModel) categoryCombo3.getModel()).insertElementAt("", 0);

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

    pagesInput.setBackground(Constants.WHITE);
    pagesInput.setColumns(10);
    pagesInput.setForeground(Constants.FONT_COLOR);
    pagesInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    pagesInput.setToolTipText("Insira o número de páginas do livro");
    pagesInput.setCaretColor(Constants.FONT_COLOR);
    pagesInput.setFont(Constants.DEFAULT_FONT);
    pagesInput.setMaximumSize(new java.awt.Dimension(120, 30));
    pagesInput.setMinimumSize(new java.awt.Dimension(120, 30));
    pagesInput.setName("Número de páginas"); // NOI18N
    pagesInput.setNextFocusableComponent(readCheckbox);
    pagesInput.setPreferredSize(new java.awt.Dimension(120, 30));
    pagesInput.setSelectedTextColor(Constants.WHITE);
    pagesInput.setSelectionColor(Constants.DARK_BLUE);
    pagesInput.setValue(book != null ? book.getPages() : 0);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(146, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(categoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(titleLabel)
                      .addComponent(authorLabel)
                      .addComponent(purchaseDateLabel))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(priceLabel))))
              .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(55, 55, 55)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(isbnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(isbnLabel)
                  .addComponent(formatLabel)
                  .addComponent(pagesLabel))))))
        .addContainerGap(140, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(20, Short.MAX_VALUE)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(isbnLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(isbnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(formatLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(titleLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(authorLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(purchaseDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(pagesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        .addGap(29, 29, 29)
        .addComponent(categoriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(38, 38, 38)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(104, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    titleInput.getAccessibleContext().setAccessibleName("Input título");
    isbnInput.getAccessibleContext().setAccessibleName("Input ISBN");
    ((DefaultComboBoxModel) authorCombo.getModel()).insertElementAt("", 0);
    authorCombo.getAccessibleContext().setAccessibleName("Combo autor");
    formatCombo.getAccessibleContext().setAccessibleName("Combo formato");
    ((DefaultComboBoxModel) formatCombo.getModel()).insertElementAt("", 0);
    purchaseDateInput.getAccessibleContext().setAccessibleName("Input data da compra");
    priceInput.getAccessibleContext().setAccessibleName("Input preço");
    readCheckbox.getAccessibleContext().setAccessibleName("Checkbox leitura concluída");
    readCheckbox.getAccessibleContext().setAccessibleDescription("Alternar leitura concluída/não concluída");
    categoriesPanel.getAccessibleContext().setAccessibleDescription("Painel de categorias");
    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informações do livro");
    pagesInput.getAccessibleContext().setAccessibleName("Input número de páginas");

    getAccessibleContext().setAccessibleName("Formulário de livros");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void defineCategories(Book book) {
    var categories = book.getCategories().toArray();

    categoryCombo1.setSelectedItem(categories[0]);

    if (categories.length > 1)
      categoryCombo2.setSelectedItem(categories[1]);

    if (categories.length > 2)
      categoryCombo3.setSelectedItem(categories[2]);
  }

  private Author selectAuthor() {
    if (authorCombo.getSelectedIndex() < 1)
      throw new ValidationException("Por favor, selecione o autor do livro!");

    return (Author) authorCombo.getSelectedItem();
  }

  private Format selectFormat() {
    if (formatCombo.getSelectedIndex() < 1)
      throw new ValidationException("Por favor, selecione o formato do livro!");

    return (Format) formatCombo.getSelectedItem();
  }

  private Set<Category> selectCategories() {
    Set<Category> categories = new HashSet<>();

    if (categoryCombo1.getSelectedIndex() < 1)
      throw new ValidationException("Por favor, selecione ao menos uma categoria!");

    categories.add((Category) categoryCombo1.getSelectedItem());

    if (categoryCombo2.isEnabled() && categoryCombo2.getSelectedIndex() > 0)
      categories.add((Category) categoryCombo2.getSelectedItem());

    if (categoryCombo3.isEnabled() && categoryCombo3.getSelectedIndex() > 0)
      categories.add((Category) categoryCombo3.getSelectedItem());

    return categories;
  }

  private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    try {
      String title = titleInput.getText();
      String isbn = isbnInput.getText();
      Author author = selectAuthor();
      Format format = selectFormat();
      LocalDate purchaseDate = LocalDate.parse(purchaseDateInput.getText(), dateFormatter);
      double price = (Double) priceInput.getValue();
      int pages = Integer.parseInt(pagesInput.getText());
      boolean read = readCheckbox.isSelected();
      Set<Category> categories = selectCategories();

      BookDto bookData = new BookDto(title, isbn, pages, author, format, purchaseDate, price, read);
      String msg;

      if (book != null) {
        bookController.update(book.getId(), bookData, categories);
        msg = "Livro atualizado com sucesso!";
      } else {
        bookController.create(bookData, categories);
        msg = "Livro cadastrado com sucesso!";
      }

      JOptionPane.showMessageDialog(this, msg, getTitle(), JOptionPane.INFORMATION_MESSAGE);
      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()), getTitle(), JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_saveBtnActionPerformed

  private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
    dispose();
  }//GEN-LAST:event_cancelBtnActionPerformed

  private void readCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readCheckboxItemStateChanged
    readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
  }//GEN-LAST:event_readCheckboxItemStateChanged

  private void categoryCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCombo1ActionPerformed
    if (categoryCombo1.getSelectedIndex() > 0) {
      categoryCombo2.setEnabled(true);
      categoryCombo2.actionPerformed(evt);
    } else {
      categoryCombo2.setEnabled(false);
      categoryCombo3.setEnabled(false);
    }
  }//GEN-LAST:event_categoryCombo1ActionPerformed

  private void categoryCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCombo2ActionPerformed
    if (categoryCombo2.getSelectedIndex() > 0)
      categoryCombo3.setEnabled(true);
    else
      categoryCombo3.setEnabled(false);
  }//GEN-LAST:event_categoryCombo2ActionPerformed

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
  private javax.swing.JLabel categoriesLabel;
  private javax.swing.JPanel categoriesPanel;
  private javax.swing.JComboBox<Category> categoryCombo1;
  private javax.swing.JComboBox<Category> categoryCombo2;
  private javax.swing.JComboBox<Category> categoryCombo3;
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
