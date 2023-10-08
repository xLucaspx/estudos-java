package views.forms;

import static utils.Validator.isValidString;
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

import controller.AuthorController;
import controller.BookController;
import controller.GenreController;
import controller.PublisherController;
import exceptions.ValidationException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import models.Author;
import models.Book;
import models.Genre;
import models.Publisher;
import models.Format;
import models.dto.BookDto;
import views.constants.Constants;

public class BookForm extends javax.swing.JFrame {

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final java.text.Format dateFormat = dateFormatter.toFormat();
	private final NumberFormat decimalFormat = DecimalFormat.getInstance();
	private final NumberFormat integerFormat = NumberFormat.getIntegerInstance();

	private BookController bookController;
	private AuthorController authorController;
	private PublisherController publisherController;
	private GenreController genreController;

	private Set<Author> authors;
	private Set<Publisher> publishers;
	private Set<Genre> genres;
	private Set<Format> formats;
	private Book book;

	public BookForm() {
		initControllers();
		initComponents();
	}

	public BookForm(Book book) {
		this.book = book;
		initControllers();
		initComponents();
		defineCategories(book);
	}

	private void initControllers() {
		this.bookController = new BookController();
		this.authorController = new AuthorController();
		this.publisherController = new PublisherController();
		this.genreController = new GenreController();
		this.authors = authorController.getAll();
		this.publishers = publisherController.getAll();
		this.genres = genreController.getAll();
		this.formats = new HashSet<>(Arrays.asList(Format.values()));
	}

	private void defineCategories(Book book) {
		var categories = book.getGenres().toArray();

		genreCombo1.setSelectedItem(categories[0]);

		if (categories.length > 1) genreCombo2.setSelectedItem(categories[1]);

		if (categories.length > 2) genreCombo3.setSelectedItem(categories[2]);
	}

	private Format selectFormat() {
		if (formatCombo.getSelectedIndex() < 1) throw new ValidationException("Por favor, selecione o formato do livro!");

		return (Format) formatCombo.getSelectedItem();
	}

	private Author selectAuthor() {
		if (authorCombo.getSelectedIndex() < 1) throw new ValidationException("Por favor, selecione o autor do livro!");

		return (Author) authorCombo.getSelectedItem();
	}

	private Publisher selectPublisher() {
		if (publisherCombo.getSelectedIndex() < 1)
			throw new ValidationException("Por favor, selecione a editora do livro!");

		return (Publisher) publisherCombo.getSelectedItem();
	}

	private Set<Genre> selectGenres() {
		Set<Genre> genres = new HashSet<>();

		if (genreCombo1.getSelectedIndex() < 1)
			throw new ValidationException("Por favor, selecione ao menos uma categoria!");

		genres.add((Genre) genreCombo1.getSelectedItem());

		if (genreCombo2.isEnabled() && genreCombo2.getSelectedIndex() > 0)
			genres.add((Genre) genreCombo2.getSelectedItem());

		if (genreCombo3.isEnabled() && genreCombo3.getSelectedIndex() > 0)
			genres.add((Genre) genreCombo3.getSelectedItem());

		return genres;
	}

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    titleInput = new javax.swing.JTextField();
    isbn13Label = new javax.swing.JLabel();
    isbn13Input = new javax.swing.JTextField();
    isbn10Label = new javax.swing.JLabel();
    isbn10Input = new javax.swing.JTextField();
    formatLabel = new javax.swing.JLabel();
    var formatComboModel = new DefaultComboBoxModel<>(new Vector<>(formats));
    formatComboModel.insertElementAt(null, 0);
    formatCombo = new javax.swing.JComboBox<>();
    authorLabel = new javax.swing.JLabel();
    var authorComboModel = new DefaultComboBoxModel<>(new Vector<>(authors));
    authorComboModel.insertElementAt(null, 0);
    authorCombo = new javax.swing.JComboBox<>();
    publisherLabel = new javax.swing.JLabel();
    var publisherComboModel = new DefaultComboBoxModel<>(new Vector<>(publishers));
    publisherComboModel.insertElementAt(null, 0);
    publisherCombo = new javax.swing.JComboBox<>();
    purchaseDateLabel = new javax.swing.JLabel();
    purchaseDateInput = new JFormattedTextField(dateFormat);
    priceLabel = new javax.swing.JLabel();
    decimalFormat.setMaximumFractionDigits(2);
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    priceInput = new JFormattedTextField(decimalFormat);
    pagesLabel = new javax.swing.JLabel();
    integerFormat.setMaximumIntegerDigits(5);
    pagesInput = new JFormattedTextField(integerFormat);
    readCheckbox = new javax.swing.JCheckBox();
    genresPanel = new javax.swing.JPanel();
    genresLabel = new javax.swing.JLabel();
    var genresComboModel1 = new DefaultComboBoxModel<>(new Vector<>(genres));
    genresComboModel1.insertElementAt(null, 0);
    genreCombo1 = new javax.swing.JComboBox<>();
    var genresComboModel2 = new DefaultComboBoxModel<>(new Vector<>(genres));
    genresComboModel2.insertElementAt(null, 0);
    genreCombo2 = new javax.swing.JComboBox<>();
    var genresComboModel3 = new DefaultComboBoxModel<>(new Vector<>(genres));
    genresComboModel3.insertElementAt(null, 0);
    genreCombo3 = new javax.swing.JComboBox<>();
    buttonsPanel = new javax.swing.JPanel();
    saveBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(book != null ? "Edição de livro" : "Cadastro de livro");
    setBackground(Constants.BACKGROUND_COLOR);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setMaximumSize(new java.awt.Dimension(975, 550));
    setMinimumSize(new java.awt.Dimension(975, 550));
    setName("window"); // NOI18N
    setPreferredSize(new java.awt.Dimension(975, 550));
    setSize(new java.awt.Dimension(975, 550));

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
    titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    titleLabel.setLabelFor(titleInput);
    titleLabel.setText("Título");
    titleLabel.setToolTipText("");
    titleLabel.setFocusable(false);
    titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    titleLabel.setMaximumSize(new java.awt.Dimension(265, 16));
    titleLabel.setMinimumSize(new java.awt.Dimension(265, 16));
    titleLabel.setName("Label título"); // NOI18N
    titleLabel.setPreferredSize(new java.awt.Dimension(265, 16));
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
    titleInput.setMaximumSize(new java.awt.Dimension(270, 30));
    titleInput.setMinimumSize(new java.awt.Dimension(270, 30));
    titleInput.setName("Título do livro"); // NOI18N
    titleInput.setNextFocusableComponent(isbn13Input);
    titleInput.setPreferredSize(new java.awt.Dimension(270, 30));
    titleInput.setSelectedTextColor(Constants.WHITE);
    titleInput.setSelectionColor(Constants.DARK_BLUE);

    isbn13Label.setBackground(Constants.BACKGROUND_COLOR);
    isbn13Label.setFont(Constants.DEFAULT_FONT);
    isbn13Label.setForeground(Constants.FONT_COLOR);
    isbn13Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    isbn13Label.setLabelFor(isbn13Input);
    isbn13Label.setText("ISBN-13");
    isbn13Label.setToolTipText("");
    isbn13Label.setFocusable(false);
    isbn13Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    isbn13Label.setMaximumSize(new java.awt.Dimension(265, 16));
    isbn13Label.setMinimumSize(new java.awt.Dimension(265, 16));
    isbn13Label.setName("Label ISBN-13"); // NOI18N
    isbn13Label.setPreferredSize(new java.awt.Dimension(265, 16));
    isbn13Label.setRequestFocusEnabled(false);
    isbn13Label.setVerifyInputWhenFocusTarget(false);

    isbn13Input.setBackground(Constants.WHITE);
    isbn13Input.setColumns(25);
    isbn13Input.setFont(Constants.DEFAULT_FONT);
    isbn13Input.setForeground(Constants.FONT_COLOR);
    isbn13Input.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    isbn13Input.setText(book != null ? book.getIsbn13() : "");
    isbn13Input.setToolTipText("Insira o ISBN-13 do livro, somente números");
    isbn13Input.setCaretColor(Constants.FONT_COLOR);
    isbn13Input.setMaximumSize(new java.awt.Dimension(270, 30));
    isbn13Input.setMinimumSize(new java.awt.Dimension(270, 30));
    isbn13Input.setName("ISBN-13 do livro"); // NOI18N
    isbn13Input.setNextFocusableComponent(isbn10Input);
    isbn13Input.setPreferredSize(new java.awt.Dimension(270, 30));
    isbn13Input.setSelectedTextColor(Constants.WHITE);
    isbn13Input.setSelectionColor(Constants.DARK_BLUE);

    isbn10Label.setBackground(Constants.BACKGROUND_COLOR);
    isbn10Label.setFont(Constants.DEFAULT_FONT);
    isbn10Label.setForeground(Constants.FONT_COLOR);
    isbn10Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    isbn10Label.setLabelFor(isbn10Input);
    isbn10Label.setText("ISBN-10");
    isbn10Label.setToolTipText("");
    isbn10Label.setFocusable(false);
    isbn10Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    isbn10Label.setMaximumSize(new java.awt.Dimension(265, 16));
    isbn10Label.setMinimumSize(new java.awt.Dimension(265, 16));
    isbn10Label.setName("Label ISBN-10"); // NOI18N
    isbn10Label.setPreferredSize(new java.awt.Dimension(265, 16));
    isbn10Label.setRequestFocusEnabled(false);
    isbn10Label.setVerifyInputWhenFocusTarget(false);

    isbn10Input.setBackground(Constants.WHITE);
    isbn10Input.setColumns(25);
    isbn10Input.setFont(Constants.DEFAULT_FONT);
    isbn10Input.setForeground(Constants.FONT_COLOR);
    isbn10Input.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    isbn10Input.setText(book != null ? book.getIsbn10() : "");
    isbn10Input.setToolTipText("Insira o ISBN-10 do livro, somente números");
    isbn10Input.setCaretColor(Constants.FONT_COLOR);
    isbn10Input.setMaximumSize(new java.awt.Dimension(270, 30));
    isbn10Input.setMinimumSize(new java.awt.Dimension(270, 30));
    isbn10Input.setName("ISBN-10 do livro"); // NOI18N
    isbn10Input.setNextFocusableComponent(formatCombo);
    isbn10Input.setPreferredSize(new java.awt.Dimension(270, 30));
    isbn10Input.setSelectedTextColor(Constants.WHITE);
    isbn10Input.setSelectionColor(Constants.DARK_BLUE);

    formatLabel.setBackground(Constants.BACKGROUND_COLOR);
    formatLabel.setFont(Constants.DEFAULT_FONT);
    formatLabel.setForeground(Constants.FONT_COLOR);
    formatLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    formatLabel.setLabelFor(formatCombo);
    formatLabel.setText("Formato");
    formatLabel.setToolTipText("");
    formatLabel.setFocusable(false);
    formatLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    formatLabel.setMaximumSize(new java.awt.Dimension(265, 16));
    formatLabel.setMinimumSize(new java.awt.Dimension(265, 16));
    formatLabel.setName("Label formato"); // NOI18N
    formatLabel.setPreferredSize(new java.awt.Dimension(265, 16));
    formatLabel.setRequestFocusEnabled(false);
    formatLabel.setVerifyInputWhenFocusTarget(false);

    formatCombo.setBackground(Constants.WHITE);
    formatCombo.setFont(Constants.DEFAULT_FONT);
    formatCombo.setForeground(Constants.FONT_COLOR);
    formatCombo.setMaximumRowCount(10);
    formatCombo.setModel(formatComboModel);
    formatCombo.setSelectedItem(book != null ? book.getFormat() : null);
    formatCombo.setToolTipText("Selecione o formato do livro");
    formatCombo.setMaximumSize(new java.awt.Dimension(270, 30));
    formatCombo.setMinimumSize(new java.awt.Dimension(270, 30));
    formatCombo.setName("Formato"); // NOI18N
    formatCombo.setNextFocusableComponent(authorCombo);
    formatCombo.setPreferredSize(new java.awt.Dimension(270, 30));

    authorLabel.setBackground(Constants.BACKGROUND_COLOR);
    authorLabel.setFont(Constants.DEFAULT_FONT);
    authorLabel.setForeground(Constants.FONT_COLOR);
    authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    authorLabel.setLabelFor(authorCombo);
    authorLabel.setText("Autor");
    authorLabel.setToolTipText("");
    authorLabel.setFocusable(false);
    authorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    authorLabel.setMaximumSize(new java.awt.Dimension(265, 16));
    authorLabel.setMinimumSize(new java.awt.Dimension(265, 16));
    authorLabel.setName("Label autor"); // NOI18N
    authorLabel.setPreferredSize(new java.awt.Dimension(265, 16));
    authorLabel.setRequestFocusEnabled(false);
    authorLabel.setVerifyInputWhenFocusTarget(false);

    authorCombo.setBackground(Constants.WHITE);
    authorCombo.setFont(Constants.DEFAULT_FONT);
    authorCombo.setForeground(Constants.FONT_COLOR);
    authorCombo.setMaximumRowCount(10);
    authorCombo.setModel(authorComboModel);
    authorCombo.setSelectedItem(book != null ? book.getAuthor() : null);
    authorCombo.setToolTipText("Selecione o autor do livro");
    authorCombo.setMaximumSize(new java.awt.Dimension(270, 30));
    authorCombo.setMinimumSize(new java.awt.Dimension(270, 30));
    authorCombo.setName("Autor"); // NOI18N
    authorCombo.setNextFocusableComponent(publisherCombo);
    authorCombo.setPreferredSize(new java.awt.Dimension(270, 30));

    publisherLabel.setBackground(Constants.BACKGROUND_COLOR);
    publisherLabel.setFont(Constants.DEFAULT_FONT);
    publisherLabel.setForeground(Constants.FONT_COLOR);
    publisherLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    publisherLabel.setLabelFor(publisherCombo);
    publisherLabel.setText("Editora");
    publisherLabel.setToolTipText("");
    publisherLabel.setFocusable(false);
    publisherLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    publisherLabel.setMaximumSize(new java.awt.Dimension(265, 16));
    publisherLabel.setMinimumSize(new java.awt.Dimension(265, 16));
    publisherLabel.setName("Label editora"); // NOI18N
    publisherLabel.setPreferredSize(new java.awt.Dimension(265, 16));
    publisherLabel.setRequestFocusEnabled(false);
    publisherLabel.setVerifyInputWhenFocusTarget(false);

    publisherCombo.setBackground(Constants.WHITE);
    publisherCombo.setFont(Constants.DEFAULT_FONT);
    publisherCombo.setForeground(Constants.FONT_COLOR);
    publisherCombo.setMaximumRowCount(10);
    publisherCombo.setModel(publisherComboModel);
    publisherCombo.setSelectedItem(book != null ? book.getPublisher() : null);
    publisherCombo.setToolTipText("Selecione a editora do livro");
    publisherCombo.setMaximumSize(new java.awt.Dimension(270, 30));
    publisherCombo.setMinimumSize(new java.awt.Dimension(270, 30));
    publisherCombo.setName("Editora"); // NOI18N
    publisherCombo.setNextFocusableComponent(purchaseDateInput);
    publisherCombo.setPreferredSize(new java.awt.Dimension(270, 30));

    purchaseDateLabel.setBackground(Constants.BACKGROUND_COLOR);
    purchaseDateLabel.setFont(Constants.DEFAULT_FONT);
    purchaseDateLabel.setForeground(Constants.FONT_COLOR);
    purchaseDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    purchaseDateLabel.setLabelFor(purchaseDateInput);
    purchaseDateLabel.setText("Data da compra");
    purchaseDateLabel.setFocusable(false);
    purchaseDateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    purchaseDateLabel.setMaximumSize(new java.awt.Dimension(120, 16));
    purchaseDateLabel.setMinimumSize(new java.awt.Dimension(120, 16));
    purchaseDateLabel.setName("Label data da compra"); // NOI18N
    purchaseDateLabel.setPreferredSize(new java.awt.Dimension(120, 16));
    purchaseDateLabel.setRequestFocusEnabled(false);
    purchaseDateLabel.setVerifyInputWhenFocusTarget(false);

    purchaseDateInput.setBackground(Constants.WHITE);
    purchaseDateInput.setColumns(10);
    purchaseDateInput.setForeground(Constants.FONT_COLOR);
    purchaseDateInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    purchaseDateInput.setToolTipText("Insira a data da compra no formato dd/MM/aaaa");
    purchaseDateInput.setCaretColor(Constants.FONT_COLOR);
    purchaseDateInput.setFont(Constants.DEFAULT_FONT);
    purchaseDateInput.setMaximumSize(new java.awt.Dimension(125, 30));
    purchaseDateInput.setMinimumSize(new java.awt.Dimension(125, 30));
    purchaseDateInput.setName("Data da compra"); // NOI18N
    purchaseDateInput.setNextFocusableComponent(priceInput);
    purchaseDateInput.setPreferredSize(new java.awt.Dimension(125, 30));
    purchaseDateInput.setSelectedTextColor(Constants.WHITE);
    purchaseDateInput.setSelectionColor(Constants.DARK_BLUE);
    purchaseDateInput.setValue(book != null ? book.getPurchaseDate() : LocalDate.now());

    priceLabel.setBackground(Constants.BACKGROUND_COLOR);
    priceLabel.setFont(Constants.DEFAULT_FONT);
    priceLabel.setForeground(Constants.FONT_COLOR);
    priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    priceLabel.setLabelFor(priceInput);
    priceLabel.setText("Preço");
    priceLabel.setFocusable(false);
    priceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    priceLabel.setMaximumSize(new java.awt.Dimension(120, 16));
    priceLabel.setMinimumSize(new java.awt.Dimension(120, 16));
    priceLabel.setName("Label preço"); // NOI18N
    priceLabel.setPreferredSize(new java.awt.Dimension(120, 16));
    priceLabel.setRequestFocusEnabled(false);
    priceLabel.setVerifyInputWhenFocusTarget(false);

    priceInput.setBackground(Constants.WHITE);
    priceInput.setColumns(10);
    priceInput.setForeground(Constants.FONT_COLOR);
    priceInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    priceInput.setToolTipText("Insira o preço do livro, separando as cadas decimais com vírgula");
    priceInput.setCaretColor(Constants.FONT_COLOR);
    priceInput.setFont(Constants.DEFAULT_FONT);
    priceInput.setMaximumSize(new java.awt.Dimension(125, 30));
    priceInput.setMinimumSize(new java.awt.Dimension(125, 30));
    priceInput.setName("Preço do livro"); // NOI18N
    priceInput.setNextFocusableComponent(pagesInput);
    priceInput.setPreferredSize(new java.awt.Dimension(125, 30));
    priceInput.setSelectedTextColor(Constants.WHITE);
    priceInput.setSelectionColor(Constants.DARK_BLUE);
    priceInput.setValue(book != null ? book.getPrice() : 0);

    pagesLabel.setBackground(Constants.BACKGROUND_COLOR);
    pagesLabel.setFont(Constants.DEFAULT_FONT);
    pagesLabel.setForeground(Constants.FONT_COLOR);
    pagesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    pagesLabel.setLabelFor(pagesInput);
    pagesLabel.setText("Nº de páginas");
    pagesLabel.setFocusable(false);
    pagesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    pagesLabel.setMaximumSize(new java.awt.Dimension(95, 16));
    pagesLabel.setMinimumSize(new java.awt.Dimension(95, 16));
    pagesLabel.setName("Label número de páginas"); // NOI18N
    pagesLabel.setPreferredSize(new java.awt.Dimension(95, 16));
    pagesLabel.setRequestFocusEnabled(false);
    pagesLabel.setVerifyInputWhenFocusTarget(false);

    pagesInput.setBackground(Constants.WHITE);
    pagesInput.setColumns(10);
    pagesInput.setForeground(Constants.FONT_COLOR);
    pagesInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
    pagesInput.setValue(book != null ? book.getPages() : 0);

    readCheckbox.setBackground(null);
    readCheckbox.setFont(Constants.DEFAULT_FONT);
    readCheckbox.setForeground(Constants.FONT_COLOR);
    readCheckbox.setSelected(book != null ? book.isRead() : false);
    readCheckbox.setText("Leitura concluída");
    readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
    readCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    readCheckbox.setMaximumSize(new java.awt.Dimension(150, 30));
    readCheckbox.setMinimumSize(new java.awt.Dimension(150, 30));
    readCheckbox.setName("Checkbox leitura concluída"); // NOI18N
    readCheckbox.setNextFocusableComponent(genreCombo1);
    readCheckbox.setPreferredSize(new java.awt.Dimension(150, 30));
    readCheckbox.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        readCheckboxItemStateChanged(evt);
      }
    });

    genresPanel.setBackground(null);
    genresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Constants.FONT_COLOR, 1, true), "Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, Constants.MEDIUM_FONT, Constants.FONT_COLOR));
    genresPanel.setForeground(Constants.FONT_COLOR);
    genresPanel.setFocusable(false);
    genresPanel.setFont(Constants.DEFAULT_FONT);
    genresPanel.setMaximumSize(new java.awt.Dimension(874, 95));
    genresPanel.setMinimumSize(new java.awt.Dimension(874, 95));
    genresPanel.setName("Painel de categorias"); // NOI18N
    genresPanel.setPreferredSize(new java.awt.Dimension(874, 95));

    genresLabel.setBackground(Constants.BACKGROUND_COLOR);
    genresLabel.setFont(Constants.SMALL_FONT);
    genresLabel.setForeground(Constants.FONT_COLOR);
    genresLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    genresLabel.setLabelFor(genresPanel);
    genresLabel.setText("Selecione entre uma e três categorias para o livro");
    genresLabel.setFocusable(false);
    genresLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    genresLabel.setMaximumSize(new java.awt.Dimension(623, 16));
    genresLabel.setMinimumSize(new java.awt.Dimension(623, 16));
    genresLabel.setName("Legenda categorias"); // NOI18N
    genresLabel.setPreferredSize(new java.awt.Dimension(623, 16));

    genreCombo1.setBackground(Constants.WHITE);
    genreCombo1.setFont(Constants.DEFAULT_FONT);
    genreCombo1.setForeground(Constants.FONT_COLOR);
    genreCombo1.setMaximumRowCount(10);
    genreCombo1.setModel(genresComboModel1);
    genreCombo1.setSelectedItem(null);
    genreCombo1.setToolTipText("Selecione a categoria 1");
    genreCombo1.setMaximumSize(new java.awt.Dimension(270, 30));
    genreCombo1.setMinimumSize(new java.awt.Dimension(270, 30));
    genreCombo1.setName("Categoria 1"); // NOI18N
    genreCombo1.setNextFocusableComponent(genreCombo2);
    genreCombo1.setPreferredSize(new java.awt.Dimension(270, 30));
    genreCombo1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        genreCombo1ActionPerformed(evt);
      }
    });

    genreCombo2.setBackground(Constants.WHITE);
    genreCombo2.setFont(Constants.DEFAULT_FONT);
    genreCombo2.setForeground(Constants.FONT_COLOR);
    genreCombo2.setMaximumRowCount(10);
    genreCombo2.setModel(genresComboModel2);
    genreCombo2.setSelectedItem(null);
    genreCombo2.setToolTipText("Selecione a categoria 2");
    genreCombo2.setEnabled(false);
    genreCombo2.setMaximumSize(new java.awt.Dimension(270, 30));
    genreCombo2.setMinimumSize(new java.awt.Dimension(270, 30));
    genreCombo2.setName("Categoria 2"); // NOI18N
    genreCombo2.setNextFocusableComponent(genreCombo3);
    genreCombo2.setPreferredSize(new java.awt.Dimension(270, 30));
    genreCombo2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        genreCombo2ActionPerformed(evt);
      }
    });

    genreCombo3.setBackground(Constants.WHITE);
    genreCombo3.setFont(Constants.DEFAULT_FONT);
    genreCombo3.setForeground(Constants.FONT_COLOR);
    genreCombo3.setMaximumRowCount(10);
    genreCombo3.setModel(genresComboModel3);
    genreCombo3.setSelectedItem(null);
    genreCombo3.setToolTipText("Selecione a categoria 3");
    genreCombo3.setEnabled(false);
    genreCombo3.setMaximumSize(new java.awt.Dimension(270, 30));
    genreCombo3.setMinimumSize(new java.awt.Dimension(270, 30));
    genreCombo3.setName("Categoria 3"); // NOI18N
    genreCombo3.setNextFocusableComponent(saveBtn);
    genreCombo3.setPreferredSize(new java.awt.Dimension(270, 30));

    javax.swing.GroupLayout genresPanelLayout = new javax.swing.GroupLayout(genresPanel);
    genresPanel.setLayout(genresPanelLayout);
    genresPanelLayout.setHorizontalGroup(
      genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(genresPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(genresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(genresPanelLayout.createSequentialGroup()
            .addComponent(genreCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(genreCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(genreCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    genresPanelLayout.setVerticalGroup(
      genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(genresPanelLayout.createSequentialGroup()
        .addComponent(genresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(genreCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(genreCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(genreCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(14, Short.MAX_VALUE))
    );

    genresLabel.getAccessibleContext().setAccessibleName("Legenda categorias");
    genresLabel.getAccessibleContext().setAccessibleDescription("Selecione entre uma e três categorias para o livro");
    genreCombo1.getAccessibleContext().setAccessibleName("Combo categoria 1");
    genreCombo2.getAccessibleContext().setAccessibleName("Combo categoria 2");
    genreCombo3.getAccessibleContext().setAccessibleName("Combo categoria 3");

    buttonsPanel.setBackground(null);
    buttonsPanel.setForeground(Constants.FONT_COLOR);
    buttonsPanel.setFont(Constants.DEFAULT_FONT);
    buttonsPanel.setMaximumSize(new java.awt.Dimension(874, 50));
    buttonsPanel.setMinimumSize(new java.awt.Dimension(874, 50));
    buttonsPanel.setName("Painel de botões"); // NOI18N
    buttonsPanel.setPreferredSize(new java.awt.Dimension(874, 50));

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

    javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
    buttonsPanel.setLayout(buttonsPanelLayout);
    buttonsPanelLayout.setHorizontalGroup(
      buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(buttonsPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    buttonsPanelLayout.setVerticalGroup(
      buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(buttonsPanelLayout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    saveBtn.getAccessibleContext().setAccessibleName("Salvar");
    saveBtn.getAccessibleContext().setAccessibleDescription("Salvar informações do livro");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(50, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(20, 20, 20)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(formatCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(formatLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(32, 32, 32)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isbn10Input, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(isbn13Input, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(genresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(50, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn13Input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn10Input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(publisherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(20, 20, 20)
        .addComponent(genresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(25, 25, 25)
        .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(45, Short.MAX_VALUE))
    );

    title.getAccessibleContext().setAccessibleDescription("");
    titleInput.getAccessibleContext().setAccessibleName("Input título");
    isbn13Input.getAccessibleContext().setAccessibleName("Input ISBN-13");
    isbn10Input.getAccessibleContext().setAccessibleName("Input ISBN-10");
    formatCombo.getAccessibleContext().setAccessibleName("Combo formato");
    authorCombo.getAccessibleContext().setAccessibleName("Combo autor");
    publisherCombo.getAccessibleContext().setAccessibleName("Combo editora");
    purchaseDateInput.getAccessibleContext().setAccessibleName("Input data da compra");
    priceInput.getAccessibleContext().setAccessibleName("Input preço");
    pagesInput.getAccessibleContext().setAccessibleName("Input número de páginas");
    readCheckbox.getAccessibleContext().setAccessibleName("Checkbox leitura concluída");
    readCheckbox.getAccessibleContext().setAccessibleDescription("Alternar leitura concluída/não concluída");
    genresPanel.getAccessibleContext().setAccessibleDescription("Painel de categorias");
    buttonsPanel.getAccessibleContext().setAccessibleName("Painel de botões");

    getAccessibleContext().setAccessibleName("Formulário de livros");

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private void readCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_readCheckboxItemStateChanged
		readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
	}// GEN-LAST:event_readCheckboxItemStateChanged

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		dispose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void genreCombo1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genreCombo1ActionPerformed
		if (genreCombo1.getSelectedIndex() > 0) {
			genreCombo2.setEnabled(true);
			genreCombo2.actionPerformed(evt);
		} else {
			genreCombo2.setEnabled(false);
			genreCombo3.setEnabled(false);
		}
	}// GEN-LAST:event_genreCombo1ActionPerformed

	private void genreCombo2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genreCombo2ActionPerformed
		if (genreCombo2.getSelectedIndex() > 0) genreCombo3.setEnabled(true);
		else genreCombo3.setEnabled(false);
	}// GEN-LAST:event_genreCombo2ActionPerformed

	private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveBtnActionPerformed
		try {
			String isbn10 = isbn10Input.getText();
			String isbn13 = isbn13Input.getText();

			if (!isValidString(isbn10) && !isValidString(isbn13))
				throw new ValidationException("Pelo menos um ISBN deve ser informado!");

			String title = titleInput.getText();
			Format format = selectFormat();
			Author author = selectAuthor();
			Publisher publisher = selectPublisher();
			LocalDate purchaseDate = LocalDate.parse(purchaseDateInput.getText(), dateFormatter);
			float price = Float.parseFloat(priceInput.getText().replace(".", "").replace(",", "."));
			int pages = Integer.parseInt(pagesInput.getText());
			boolean read = readCheckbox.isSelected();
			Set<Genre> genres = selectGenres();

			BookDto bookData = new BookDto(title, isbn10, isbn13, pages, read, format, author, publisher, purchaseDate,
					price);
			String msg;

			if (book != null) {
				bookController.update(book.getId(), bookData, genres);
				msg = "Livro atualizado com sucesso!";
			} else {
				bookController.create(bookData, genres);
				msg = "Livro cadastrado com sucesso!";
			}

			JOptionPane.showMessageDialog(this, msg, getTitle(), JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_saveBtnActionPerformed

	@Override
	public void dispose() {
		bookController.closeConnection();
		authorController.closeConnection();
		publisherController.closeConnection();
		genreController.closeConnection();
		super.dispose();
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<Author> authorCombo;
  private javax.swing.JLabel authorLabel;
  private javax.swing.JPanel buttonsPanel;
  private javax.swing.JButton cancelBtn;
  private javax.swing.JComboBox<Format> formatCombo;
  private javax.swing.JLabel formatLabel;
  private javax.swing.JComboBox<Genre> genreCombo1;
  private javax.swing.JComboBox<Genre> genreCombo2;
  private javax.swing.JComboBox<Genre> genreCombo3;
  private javax.swing.JLabel genresLabel;
  private javax.swing.JPanel genresPanel;
  private javax.swing.JTextField isbn10Input;
  private javax.swing.JLabel isbn10Label;
  private javax.swing.JTextField isbn13Input;
  private javax.swing.JLabel isbn13Label;
  private javax.swing.JFormattedTextField pagesInput;
  private javax.swing.JLabel pagesLabel;
  private javax.swing.JFormattedTextField priceInput;
  private javax.swing.JLabel priceLabel;
  private javax.swing.JComboBox<Publisher> publisherCombo;
  private javax.swing.JLabel publisherLabel;
  private javax.swing.JFormattedTextField purchaseDateInput;
  private javax.swing.JLabel purchaseDateLabel;
  private javax.swing.JCheckBox readCheckbox;
  private javax.swing.JButton saveBtn;
  private javax.swing.JLabel title;
  private javax.swing.JTextField titleInput;
  private javax.swing.JLabel titleLabel;
  // End of variables declaration//GEN-END:variables
}
