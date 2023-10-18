package views.forms;

import static utils.Lists.getSortedList;
import static utils.Validator.isValidString;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import controller.AuthorController;
import controller.BookController;
import controller.GenreController;
import controller.PublisherController;
import exceptions.ValidationException;
import factory.ControllerFactory;
import models.Author;
import models.Book;
import models.Format;
import models.Genre;
import models.Publisher;
import models.dto.BookDto;
import views.constants.Constants;
import views.details.BookDetails;

public class BookForm extends javax.swing.JInternalFrame {
	private final java.text.Format dateFormat = Constants.DATE_FORMATTER.toFormat();
	private final NumberFormat decimalFormat = DecimalFormat.getInstance();
	private final NumberFormat integerFormat = NumberFormat.getIntegerInstance();

	private ControllerFactory controllerFactory;
	private BookController bookController;
	private AuthorController authorController;
	private PublisherController publisherController;
	private GenreController genreController;

	private Book book;

	public BookForm(ControllerFactory controllerFactory) {
		initControllers(controllerFactory);
		initComponents();
	}

	public BookForm(ControllerFactory controllerFactory, Book book) {
		this.book = book;
		initControllers(controllerFactory);
		initComponents();
		defineGenres(book);
	}

	private void initControllers(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
		this.bookController = controllerFactory.getBookController();
		this.authorController = controllerFactory.getAuthorController();
		this.publisherController = controllerFactory.getPublisherController();
		this.genreController = controllerFactory.getGenreController();
	}

	private void defineGenres(Book book) {
		var genres = book.getGenres().toArray();

		genreCombo1.setSelectedItem(genres[0]);

		if (genres.length > 1) genreCombo2.setSelectedItem(genres[1]);

		if (genres.length > 2) genreCombo3.setSelectedItem(genres[2]);
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
		var formatComboModel = new DefaultComboBoxModel<>(Format.values());
		formatComboModel.insertElementAt(null, 0);
		formatCombo = new javax.swing.JComboBox<>();
		authorLabel = new javax.swing.JLabel();
		var authorsList = getSortedList(authorController.getAll());
		var authorComboModel = new DefaultComboBoxModel<>(authorsList.toArray(Author[]::new));
		authorComboModel.insertElementAt(null, 0);
		authorCombo = new javax.swing.JComboBox<>();
		publisherLabel = new javax.swing.JLabel();
		var publishersList = getSortedList(publisherController.getAll());
		var publisherComboModel = new DefaultComboBoxModel<>(publishersList.toArray(Publisher[]::new));
		publisherComboModel.insertElementAt(null, 0);
		publisherCombo = new javax.swing.JComboBox<>();
		purchaseDateLabel = new javax.swing.JLabel();
		purchaseDateInput = new JFormattedTextField(dateFormat);
		priceLabel = new javax.swing.JLabel();
		decimalFormat.setMaximumIntegerDigits(3);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		priceInput = new JFormattedTextField(decimalFormat);
		pagesLabel = new javax.swing.JLabel();
		integerFormat.setMaximumIntegerDigits(5);
		pagesInput = new JFormattedTextField(integerFormat);
		readCheckbox = new javax.swing.JCheckBox();
		genresPanel = new javax.swing.JPanel();
		genresLabel = new javax.swing.JLabel();
		var genresList = getSortedList(genreController.getAll());
		var genresComboModel1 = new DefaultComboBoxModel<>(genresList.toArray(Genre[]::new));
		genresComboModel1.insertElementAt(null, 0);
		genreCombo1 = new javax.swing.JComboBox<>();
		var genresComboModel2 = new DefaultComboBoxModel<>(genresList.toArray(Genre[]::new));
		genresComboModel2.insertElementAt(null, 0);
		genreCombo2 = new javax.swing.JComboBox<>();
		var genresComboModel3 = new DefaultComboBoxModel<>(genresList.toArray(Genre[]::new));
		genresComboModel3.insertElementAt(null, 0);
		genreCombo3 = new javax.swing.JComboBox<>();
		buttonsPanel = new javax.swing.JPanel();
		saveBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();
		addButtonsPanel = new javax.swing.JPanel();
		addButtonsLabel = new javax.swing.JLabel();
		addAuthorBtn = new javax.swing.JButton();
		addPublisherBtn = new javax.swing.JButton();
		addGenreBtn = new javax.swing.JButton();

		setBackground(Constants.BACKGROUND_COLOR);
		setBorder(new javax.swing.border.LineBorder(Constants.BLACK, 2, true));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle(book != null ? "Edição de livro" : "Cadastro de livro");
		setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/book-icon.png"))); // NOI18N
		setMinimumSize(new java.awt.Dimension(944, 554));
		setName("Formulário de livro"); // NOI18N
		setNormalBounds(new java.awt.Rectangle(0, 0, 944, 554));
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
		title.setText(book != null ? "Editar livro" : "Cadastrar livro");
		title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		title.setFocusable(false);
		title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		title.setMaximumSize(null);
		title.setMinimumSize(new java.awt.Dimension(270, 30));
		title.setName("Título"); // NOI18N
		title.setPreferredSize(null);
		title.setRequestFocusEnabled(false);
		title.setVerifyInputWhenFocusTarget(false);
		title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

		titleLabel.setFont(Constants.DEFAULT_FONT);
		titleLabel.setForeground(Constants.FONT_COLOR);
		titleLabel.setLabelFor(titleInput);
		titleLabel.setText("Título");
		titleLabel.setFocusable(false);
		titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		titleLabel.setMaximumSize(null);
		titleLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		titleLabel.setName("Label título"); // NOI18N
		titleLabel.setPreferredSize(null);
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
		titleInput.setPreferredSize(new java.awt.Dimension(270, 30));
		titleInput.setSelectedTextColor(Constants.WHITE);
		titleInput.setSelectionColor(Constants.DARK_BLUE);

		isbn13Label.setFont(Constants.DEFAULT_FONT);
		isbn13Label.setForeground(Constants.FONT_COLOR);
		isbn13Label.setLabelFor(isbn13Input);
		isbn13Label.setText("ISBN-13");
		isbn13Label.setFocusable(false);
		isbn13Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		isbn13Label.setMaximumSize(null);
		isbn13Label.setMinimumSize(new java.awt.Dimension(265, 18));
		isbn13Label.setName("Label ISBN-13"); // NOI18N
		isbn13Label.setPreferredSize(null);
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
		isbn13Input.setPreferredSize(new java.awt.Dimension(270, 30));
		isbn13Input.setSelectedTextColor(Constants.WHITE);
		isbn13Input.setSelectionColor(Constants.DARK_BLUE);

		isbn10Label.setFont(Constants.DEFAULT_FONT);
		isbn10Label.setForeground(Constants.FONT_COLOR);
		isbn10Label.setLabelFor(isbn10Input);
		isbn10Label.setText("ISBN-10");
		isbn10Label.setFocusable(false);
		isbn10Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		isbn10Label.setMaximumSize(null);
		isbn10Label.setMinimumSize(new java.awt.Dimension(265, 18));
		isbn10Label.setName("Label ISBN-10"); // NOI18N
		isbn10Label.setPreferredSize(null);
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
		isbn10Input.setPreferredSize(new java.awt.Dimension(270, 30));
		isbn10Input.setSelectedTextColor(Constants.WHITE);
		isbn10Input.setSelectionColor(Constants.DARK_BLUE);

		formatLabel.setFont(Constants.DEFAULT_FONT);
		formatLabel.setForeground(Constants.FONT_COLOR);
		formatLabel.setLabelFor(formatCombo);
		formatLabel.setText("Formato");
		formatLabel.setFocusable(false);
		formatLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		formatLabel.setMaximumSize(null);
		formatLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		formatLabel.setName("Label formato"); // NOI18N
		formatLabel.setPreferredSize(null);
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
		formatCombo.setPreferredSize(new java.awt.Dimension(270, 30));

		authorLabel.setFont(Constants.DEFAULT_FONT);
		authorLabel.setForeground(Constants.FONT_COLOR);
		authorLabel.setLabelFor(authorCombo);
		authorLabel.setText("Autor");
		authorLabel.setFocusable(false);
		authorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		authorLabel.setMaximumSize(null);
		authorLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		authorLabel.setName("Label autor"); // NOI18N
		authorLabel.setPreferredSize(null);
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
		authorCombo.setPreferredSize(new java.awt.Dimension(270, 30));

		publisherLabel.setFont(Constants.DEFAULT_FONT);
		publisherLabel.setForeground(Constants.FONT_COLOR);
		publisherLabel.setLabelFor(publisherCombo);
		publisherLabel.setText("Editora");
		publisherLabel.setFocusable(false);
		publisherLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		publisherLabel.setMaximumSize(null);
		publisherLabel.setMinimumSize(new java.awt.Dimension(265, 18));
		publisherLabel.setName("Label editora"); // NOI18N
		publisherLabel.setPreferredSize(null);
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

		purchaseDateLabel.setFont(Constants.DEFAULT_FONT);
		purchaseDateLabel.setForeground(Constants.FONT_COLOR);
		purchaseDateLabel.setLabelFor(purchaseDateInput);
		purchaseDateLabel.setText("Data da compra");
		purchaseDateLabel.setFocusable(false);
		purchaseDateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		purchaseDateLabel.setMaximumSize(null);
		purchaseDateLabel.setMinimumSize(new java.awt.Dimension(120, 18));
		purchaseDateLabel.setName("Label data da compra"); // NOI18N
		purchaseDateLabel.setPreferredSize(null);
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
		purchaseDateInput.setPreferredSize(new java.awt.Dimension(125, 30));
		purchaseDateInput.setSelectedTextColor(Constants.WHITE);
		purchaseDateInput.setSelectionColor(Constants.DARK_BLUE);
		purchaseDateInput.setValue(book != null ? book.getPurchaseDate() : LocalDate.now());

		priceLabel.setFont(Constants.DEFAULT_FONT);
		priceLabel.setForeground(Constants.FONT_COLOR);
		priceLabel.setLabelFor(priceInput);
		priceLabel.setText("Preço");
		priceLabel.setFocusable(false);
		priceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		priceLabel.setMaximumSize(null);
		priceLabel.setMinimumSize(new java.awt.Dimension(120, 18));
		priceLabel.setName("Label preço"); // NOI18N
		priceLabel.setPreferredSize(null);
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
		priceInput.setPreferredSize(new java.awt.Dimension(125, 30));
		priceInput.setSelectedTextColor(Constants.WHITE);
		priceInput.setSelectionColor(Constants.DARK_BLUE);
		priceInput.setValue(book != null ? book.getPrice() : 0);

		pagesLabel.setFont(Constants.DEFAULT_FONT);
		pagesLabel.setForeground(Constants.FONT_COLOR);
		pagesLabel.setLabelFor(pagesInput);
		pagesLabel.setText("Nº de páginas");
		pagesLabel.setFocusable(false);
		pagesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		pagesLabel.setMaximumSize(null);
		pagesLabel.setMinimumSize(new java.awt.Dimension(95, 18));
		pagesLabel.setName("Label número de páginas"); // NOI18N
		pagesLabel.setPreferredSize(null);
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
		readCheckbox.setPreferredSize(new java.awt.Dimension(150, 30));
		readCheckbox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				readCheckboxItemStateChanged(evt);
			}
		});

		genresPanel.setBackground(null);
		genresPanel.setBorder(
				javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Constants.FONT_COLOR, 1, true),
						"Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP,
						Constants.MEDIUM_FONT, Constants.FONT_COLOR));
		genresPanel.setForeground(Constants.FONT_COLOR);
		genresPanel.setFocusable(false);
		genresPanel.setFont(Constants.DEFAULT_FONT);
		genresPanel.setMaximumSize(new java.awt.Dimension(874, 95));
		genresPanel.setMinimumSize(new java.awt.Dimension(874, 95));
		genresPanel.setName("Painel de categorias"); // NOI18N

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
		genreCombo3.setPreferredSize(new java.awt.Dimension(270, 30));

		javax.swing.GroupLayout genresPanelLayout = new javax.swing.GroupLayout(genresPanel);
		genresPanel.setLayout(genresPanelLayout);
		genresPanelLayout
				.setHorizontalGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(genresPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(genreCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(genreCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(genreCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								genresPanelLayout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(genresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 871,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		genresPanelLayout.setVerticalGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(genresPanelLayout.createSequentialGroup()
						.addComponent(genresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(genreCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(genreCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(genreCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));

		buttonsPanel.setBackground(null);
		buttonsPanel.setForeground(Constants.FONT_COLOR);
		buttonsPanel.setFont(Constants.DEFAULT_FONT);
		buttonsPanel.setMaximumSize(new java.awt.Dimension(874, 50));
		buttonsPanel.setMinimumSize(new java.awt.Dimension(874, 50));
		buttonsPanel.setName("Painel de botões"); // NOI18N

		saveBtn.setBackground(Constants.BLUE);
		saveBtn.setFont(Constants.LARGE_FONT);
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
		saveBtn.setPreferredSize(new java.awt.Dimension(175, 40));
		saveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveBtnActionPerformed(evt);
			}
		});

		cancelBtn.setBackground(Constants.RED);
		cancelBtn.setFont(Constants.LARGE_FONT);
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
		buttonsPanelLayout
				.setHorizontalGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(buttonsPanelLayout.createSequentialGroup()
								.addContainerGap(255, Short.MAX_VALUE)
								.addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(256, Short.MAX_VALUE)));
		buttonsPanelLayout
				.setVerticalGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(buttonsPanelLayout.createSequentialGroup()
								.addGap(5, 5, 5)
								.addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		addButtonsPanel.setBackground(null);

		addButtonsLabel.setFont(Constants.SMALL_FONT);
		addButtonsLabel.setForeground(Constants.FONT_COLOR);
		addButtonsLabel.setLabelFor(addButtonsPanel);
		addButtonsLabel.setText("Cadastro de novas opções para seleção:");
		addButtonsLabel.setFocusable(false);
		addButtonsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		addButtonsLabel.setMinimumSize(new java.awt.Dimension(95, 18));
		addButtonsLabel.setName("Label botões adicionar"); // NOI18N
		addButtonsLabel.setRequestFocusEnabled(false);
		addButtonsLabel.setVerifyInputWhenFocusTarget(false);

		addAuthorBtn.setBackground(null);
		addAuthorBtn.setFont(Constants.DEFAULT_FONT);
		addAuthorBtn.setForeground(Constants.FONT_COLOR);
		addAuthorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/author-icon.png"))); // NOI18N
		addAuthorBtn.setText("Autor");
		addAuthorBtn.setToolTipText("Cadastre o autor do livro caso ele não esteja cadastrado");
		addAuthorBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, Constants.FONT_COLOR));
		addAuthorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		addAuthorBtn.setMargin(new java.awt.Insets(0, 0, 3, 0));
		addAuthorBtn.setMaximumSize(new java.awt.Dimension(80, 30));
		addAuthorBtn.setName("Botão adicionar autor"); // NOI18N
		addAuthorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBtnMouseExited(evt);
			}
		});
		addAuthorBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addAuthorBtnActionPerformed(evt);
			}
		});

		addPublisherBtn.setBackground(null);
		addPublisherBtn.setFont(Constants.DEFAULT_FONT);
		addPublisherBtn.setForeground(Constants.FONT_COLOR);
		addPublisherBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/publisher-icon.png"))); // NOI18N
		addPublisherBtn.setText("Editora");
		addPublisherBtn.setToolTipText("Cadastre a editora do livro caso ela não esteja cadastrada");
		addPublisherBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, Constants.FONT_COLOR));
		addPublisherBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		addPublisherBtn.setMargin(new java.awt.Insets(0, 0, 3, 2));
		addPublisherBtn.setMaximumSize(new java.awt.Dimension(80, 30));
		addPublisherBtn.setName("Botão adicionar editora"); // NOI18N
		addPublisherBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBtnMouseExited(evt);
			}
		});
		addPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addPublisherBtnActionPerformed(evt);
			}
		});

		addGenreBtn.setBackground(null);
		addGenreBtn.setFont(Constants.DEFAULT_FONT);
		addGenreBtn.setForeground(Constants.FONT_COLOR);
		addGenreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/genre-icon.png"))); // NOI18N
		addGenreBtn.setText("Categoria");
		addGenreBtn.setToolTipText("Cadastre uma categoria para livro caso não encontre a que deseja");
		addGenreBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
		addGenreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		addGenreBtn.setMargin(new java.awt.Insets(0, 0, 3, 2));
		addGenreBtn.setMaximumSize(new java.awt.Dimension(80, 30));
		addGenreBtn.setName("Botão adicionar categoria"); // NOI18N
		addGenreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBtnMouseExited(evt);
			}
		});
		addGenreBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addGenreBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout addButtonsPanelLayout = new javax.swing.GroupLayout(addButtonsPanel);
		addButtonsPanel.setLayout(addButtonsPanelLayout);
		addButtonsPanelLayout
				.setHorizontalGroup(addButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(addButtonsPanelLayout.createSequentialGroup()
								.addGap(0, 0, 0)
								.addGroup(addButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(addButtonsLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(addButtonsPanelLayout.createSequentialGroup()
												.addComponent(addAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addPublisherBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addGenreBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))));
		addButtonsPanelLayout
				.setVerticalGroup(addButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addButtonsPanelLayout.createSequentialGroup()
								.addComponent(addButtonsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(addButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(addAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(addButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(addGenreBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addPublisherBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		addButtonsLabel.getAccessibleContext().setAccessibleName("Label botões cadastrar");
		addButtonsLabel.getAccessibleContext()
				.setAccessibleDescription("Se não encontrar as opções desejadas, utilize os botões abaixo");
		addAuthorBtn.getAccessibleContext().setAccessibleName("Adicionar autor");
		addPublisherBtn.getAccessibleContext().setAccessibleName("Adicionar editora");
		addGenreBtn.getAccessibleContext().setAccessibleName("Adicionar categoria");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(20, 20, 20)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(formatCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(formatLabel, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(36, 36, 36)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
																layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(20, 20, 20)
																		.addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(isbn13Input, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 265,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(36, 36, 36)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addGap(10, 10, 10)
														.addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(isbn10Label, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(isbn10Input, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
												.addComponent(publisherCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(addButtonsPanel, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))
								.addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 882,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(genresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(35, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(isbn13Input, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(isbn10Input, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(authorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(publisherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup()
												.addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(pagesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(readCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(addButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(25, 25, 25)
						.addComponent(genresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(45, Short.MAX_VALUE)));

		getAccessibleContext().setAccessibleName("Formulário de livro");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void showInternalFrame(JInternalFrame frame) {
		getDesktopPane().add(frame);
		frame.moveToFront();
		frame.requestFocus();
	}

	private void readCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readCheckboxItemStateChanged
		readCheckbox.setToolTipText(readCheckbox.isSelected() ? "Marcar livro como não lido" : "Marcar livro como lido");
	}//GEN-LAST:event_readCheckboxItemStateChanged

	private void genreCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreCombo1ActionPerformed
		if (genreCombo1.getSelectedIndex() > 0) {
			genreCombo2.setEnabled(true);
			genreCombo2.actionPerformed(evt);
		} else {
			genreCombo2.setEnabled(false);
			genreCombo3.setEnabled(false);
		}
	}//GEN-LAST:event_genreCombo1ActionPerformed

	private void genreCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreCombo2ActionPerformed
		if (genreCombo2.getSelectedIndex() > 0) genreCombo3.setEnabled(true);
		else genreCombo3.setEnabled(false);
	}//GEN-LAST:event_genreCombo2ActionPerformed

	private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
		try {
			String isbn10 = isbn10Input.getText();
			String isbn13 = isbn13Input.getText();

			if (!isValidString(isbn10) && !isValidString(isbn13))
				throw new ValidationException("Pelo menos um ISBN deve ser informado!");

			String title = titleInput.getText();
			Format format = selectFormat();
			Author author = selectAuthor();
			Publisher publisher = selectPublisher();
			LocalDate purchaseDate = LocalDate.parse(purchaseDateInput.getText(), Constants.DATE_FORMATTER);
			float price = Float.parseFloat(priceInput.getText().replace(".", "").replace(",", "."));
			int pages = Integer.parseInt(pagesInput.getText().replace(".", ""));
			boolean read = readCheckbox.isSelected();
			Set<Genre> genres = selectGenres();

			BookDto bookData = new BookDto(title, isbn10, isbn13, pages, read, format, author, publisher, purchaseDate,
					price);

			if (book != null) updateBook(book.getId(), bookData, genres);
			else createBook(bookData, genres);

			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Ocorreu um erro ao tentar salvar:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_saveBtnActionPerformed

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		dispose();
	}//GEN-LAST:event_cancelBtnActionPerformed

	private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
		try {
			refreshComboBoxes();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar atualizar a página:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
			dispose();
		}
	}//GEN-LAST:event_formInternalFrameActivated

	private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
		var comp = (JButton) evt.getComponent();
		setActiveBtn(comp);
	}//GEN-LAST:event_addBtnMouseEntered

	private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
		var comp = (JButton) evt.getComponent();
		setInactiveBtn(comp);
	}//GEN-LAST:event_addBtnMouseExited

	private void addAuthorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorBtnActionPerformed
		try {
			var form = new AuthorForm(controllerFactory);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de cadastro de autor:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_addAuthorBtnActionPerformed

	private void addPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherBtnActionPerformed
		try {
			var form = new PublisherForm(controllerFactory);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de cadastro de editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_addPublisherBtnActionPerformed

	private void addGenreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGenreBtnActionPerformed
		try {
			var form = new GenreForm(controllerFactory);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de cadastro de categoria:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_addGenreBtnActionPerformed

	private void setActiveBtn(JButton btn) {
		var color = Constants.BLUE;
		btn.setForeground(color);
		btn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
	}

	private void setInactiveBtn(JButton btn) {
		var color = Constants.FONT_COLOR;
		btn.setForeground(color);
		btn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
	}

	private void refreshComboBoxes() {
		var authorsList = getSortedList(authorController.getAll());
		updateComboModel(authorsList.toArray(Author[]::new), authorCombo);

		var publishersList = getSortedList(publisherController.getAll());
		updateComboModel(publishersList.toArray(Publisher[]::new), publisherCombo);

		var genresList = getSortedList(genreController.getAll());
		updateComboModel(genresList.toArray(Genre[]::new), genreCombo1);
		updateComboModel(genresList.toArray(Genre[]::new), genreCombo2);
		updateComboModel(genresList.toArray(Genre[]::new), genreCombo3);
	}

	private <T> void updateComboModel(T[] items, JComboBox<T> combo) {
		var model = new DefaultComboBoxModel<>(items);
		model.insertElementAt(null, 0);

		var selected = combo.getSelectedItem();
		combo.setModel(model);
		combo.setSelectedItem(selected);
	}

	private void createBook(BookDto data, Set<Genre> genres) {
		Book createdBook = bookController.create(data, genres);
		JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
		var view = new BookDetails(controllerFactory, createdBook);
		showInternalFrame(view);
	}

	private void updateBook(int id, BookDto data, Set<Genre> genres) {
		bookController.update(id, data, genres);
		JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addAuthorBtn;
	private javax.swing.JLabel addButtonsLabel;
	private javax.swing.JPanel addButtonsPanel;
	private javax.swing.JButton addGenreBtn;
	private javax.swing.JButton addPublisherBtn;
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
