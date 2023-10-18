package views.details;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import factory.ControllerFactory;
import models.Author;
import models.Book;
import models.Genre;
import models.Publisher;
import views.constants.Constants;
import views.forms.BookForm;

public class BookDetails extends javax.swing.JInternalFrame {
	private final ControllerFactory controllerFactory;
	private final BookController bookController;

	private Book book;
	private Author author;
	private Publisher publisher;
	private Genre[] genres;

	/* falta: String review; */
	public BookDetails(ControllerFactory controllerFactory, Book book) {
		this.controllerFactory = controllerFactory;
		this.bookController = controllerFactory.getBookController();
		this.book = book;
		this.author = book.getAuthor();
		this.publisher = book.getPublisher();
		this.genres = book.getGenres().toArray(Genre[]::new);
		initComponents();
	}

	private void updateView() {
		this.book = bookController.getById(book.getId());
		this.author = book.getAuthor();
		this.publisher = book.getPublisher();
		this.genres = book.getGenres().toArray(Genre[]::new);

		setTitle(String.format("%s - Livro", book.getTitle()));
		bookTitle.setText(book.getTitle());
		authorLink.setText(author.getName());
		authorLink.setToolTipText(String.format("Abrir a página do autor %s", author.getName()));
		publisherLink.setText(publisher.getName());
		publisherLink.setToolTipText(String.format("Abrir a página da editora %s", publisher.getName()));
		formatName.setText(book.getFormat().toString());
		isbn13.setText(book.getIsbn13());
		isbn10.setText(book.getIsbn10());
		bookPrice.setText(String.format("R$ %.2f", book.getPrice()));
		bookPurchaseDate.setText(Constants.DATE_FORMATTER.format(book.getPurchaseDate()));
		bookPages.setText(String.valueOf(book.getPages()));
		bookStatus.setText(book.isRead() ? "Lido" : "Não lido");

		deleteBookBtn.setToolTipText(String.format("Excluir o livro %s", book.getTitle()));

		genreLink1.setText(genres[0].getName());
		genreLink1.setToolTipText(String.format("Abrir a página da categoria %s", genres[0].getName()));

		if (genres.length > 1) {
			genreLink2.setText(genres[1].getName());
			genreLink2.setToolTipText(String.format("Abrir a página da categoria %s", genres[1].getName()));
			genreLink2.setEnabled(true);
			genreLink2.setFocusable(true);
		}

		if (genres.length > 2) {
			genreLink3.setText(genres[2].getName());
			genreLink3.setToolTipText(String.format("Abrir a página da categoria %s", genres[2].getName()));
			genreLink3.setEnabled(true);
			genreLink3.setFocusable(true);
		}
	}

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    title = new javax.swing.JLabel();
    bookTitleLabel = new javax.swing.JLabel();
    bookTitle = new javax.swing.JTextField();
    authorLabel = new javax.swing.JLabel();
    authorLink = new javax.swing.JTextField();
    jPanel1 = new javax.swing.JPanel();
    publisherLabel = new javax.swing.JLabel();
    publisherLink = new javax.swing.JTextField();
    formatLabel = new javax.swing.JLabel();
    formatName = new javax.swing.JTextField();
    jPanel2 = new javax.swing.JPanel();
    isbn13Label = new javax.swing.JLabel();
    isbn13 = new javax.swing.JTextField();
    isbn10Label = new javax.swing.JLabel();
    isbn10 = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    priceLabel = new javax.swing.JLabel();
    bookPrice = new javax.swing.JTextField();
    purchaseDateLabel = new javax.swing.JLabel();
    bookPurchaseDate = new javax.swing.JTextField();
    pagesLabel = new javax.swing.JLabel();
    bookPages = new javax.swing.JTextField();
    statusLabel = new javax.swing.JLabel();
    bookStatus = new javax.swing.JTextField();
    genresPanel = new javax.swing.JPanel();
    genreLink1 = new javax.swing.JTextField();
    genreLink2 = new javax.swing.JTextField();
    genreLink3 = new javax.swing.JTextField();
    editBookBtn = new javax.swing.JButton();
    deleteBookBtn = new javax.swing.JButton();

    setBackground(Constants.BACKGROUND_COLOR);
    setBorder(new javax.swing.border.LineBorder(Constants.BLACK, 2, true));
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle(String.format("%s - Livro", book.getTitle()));
    setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/book-icon.png"))); // NOI18N
    setMinimumSize(new java.awt.Dimension(577, 516));
    setName("Detalhes livro"); // NOI18N
    setNormalBounds(new java.awt.Rectangle(0, 0, 623, 515));
    setVisible(true);
    addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
      public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
        formInternalFrameActivated(evt);
      }
      public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
      }
    });

    title.setFont(Constants.LARGE_FONT);
    title.setForeground(Constants.FONT_COLOR);
    title.setLabelFor(this);
    title.setText("Página de livro");
    title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    title.setFocusable(false);
    title.setMaximumSize(null);
    title.setMinimumSize(new java.awt.Dimension(78, 22));
    title.setName("Página de livro"); // NOI18N
    title.setPreferredSize(null);
    title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookTitleLabel.setFont(Constants.DEFAULT_FONT);
    bookTitleLabel.setForeground(Constants.FONT_COLOR);
    bookTitleLabel.setLabelFor(bookTitle);
    bookTitleLabel.setText("Título");
    bookTitleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    bookTitleLabel.setFocusable(false);
    bookTitleLabel.setMaximumSize(null);
    bookTitleLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    bookTitleLabel.setName("Título do livro"); // NOI18N
    bookTitleLabel.setPreferredSize(null);
    bookTitleLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookTitle.setEditable(false);
    bookTitle.setBackground(null);
    bookTitle.setFont(Constants.TITLE_FONT);
    bookTitle.setForeground(Constants.FONT_COLOR);
    bookTitle.setText(book.getTitle());
    bookTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bookTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookTitle.setMargin(new java.awt.Insets(0, 0, 3, 0));
    bookTitle.setMinimumSize(new java.awt.Dimension(10, 30));
    bookTitle.setName("Título do livro"); // NOI18N
    bookTitle.setPreferredSize(null);
    bookTitle.setSelectedTextColor(Constants.WHITE);
    bookTitle.setSelectionColor(Constants.DARK_BLUE);

    authorLabel.setFont(Constants.DEFAULT_FONT);
    authorLabel.setForeground(Constants.FONT_COLOR);
    authorLabel.setLabelFor(authorLink);
    authorLabel.setText("Autor");
    authorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    authorLabel.setFocusable(false);
    authorLabel.setMaximumSize(null);
    authorLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    authorLabel.setName("Autor do livro"); // NOI18N
    authorLabel.setPreferredSize(null);
    authorLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    authorLink.setEditable(false);
    authorLink.setBackground(null);
    authorLink.setFont(Constants.LARGE_FONT);
    authorLink.setForeground(Constants.FONT_COLOR);
    authorLink.setText(author.getName());
    authorLink.setToolTipText(String.format("Abrir a página do autor %s", author.getName()));
    authorLink.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    authorLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    authorLink.setMargin(new java.awt.Insets(0, 0, 3, 0));
    authorLink.setMinimumSize(new java.awt.Dimension(10, 22));
    authorLink.setName("Autor do livro"); // NOI18N
    authorLink.setPreferredSize(null);
    authorLink.setSelectedTextColor(Constants.WHITE);
    authorLink.setSelectionColor(Constants.DARK_BLUE);
    authorLink.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        linkFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        linkFocusLost(evt);
      }
    });
    authorLink.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        authorLinkMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        linkMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        linkMouseExited(evt);
      }
    });

    jPanel1.setBackground(null);
    jPanel1.setMaximumSize(new java.awt.Dimension(475, 42));
    jPanel1.setMinimumSize(new java.awt.Dimension(475, 42));

    publisherLabel.setFont(Constants.DEFAULT_FONT);
    publisherLabel.setForeground(Constants.FONT_COLOR);
    publisherLabel.setLabelFor(publisherLink);
    publisherLabel.setText("Editora");
    publisherLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    publisherLabel.setFocusable(false);
    publisherLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    publisherLabel.setName("Editora do livro"); // NOI18N
    publisherLabel.setPreferredSize(null);
    publisherLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    publisherLink.setEditable(false);
    publisherLink.setBackground(null);
    publisherLink.setFont(Constants.MEDIUM_FONT);
    publisherLink.setForeground(Constants.FONT_COLOR);
    publisherLink.setText(publisher.getName());
    publisherLink.setToolTipText(String.format("Abrir a página da editora %s", publisher.getName()));
    publisherLink.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    publisherLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    publisherLink.setMargin(new java.awt.Insets(0, 0, 3, 0));
    publisherLink.setMinimumSize(new java.awt.Dimension(10, 22));
    publisherLink.setName("Editora do livro"); // NOI18N
    publisherLink.setPreferredSize(null);
    publisherLink.setSelectedTextColor(Constants.WHITE);
    publisherLink.setSelectionColor(Constants.DARK_BLUE);
    publisherLink.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        linkFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        linkFocusLost(evt);
      }
    });
    publisherLink.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        publisherLinkMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        linkMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        linkMouseExited(evt);
      }
    });

    formatLabel.setFont(Constants.DEFAULT_FONT);
    formatLabel.setForeground(Constants.FONT_COLOR);
    formatLabel.setLabelFor(formatName);
    formatLabel.setText("Formato");
    formatLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    formatLabel.setFocusable(false);
    formatLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    formatLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    formatLabel.setName("Formato do livro"); // NOI18N
    formatLabel.setPreferredSize(null);
    formatLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    formatName.setEditable(false);
    formatName.setBackground(null);
    formatName.setFont(Constants.MEDIUM_FONT);
    formatName.setForeground(Constants.FONT_COLOR);
    formatName.setText(book.getFormat().toString());
    formatName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    formatName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    formatName.setMargin(new java.awt.Insets(0, 0, 3, 0));
    formatName.setMinimumSize(new java.awt.Dimension(10, 22));
    formatName.setName("Formato do livro"); // NOI18N
    formatName.setPreferredSize(null);
    formatName.setSelectedTextColor(Constants.WHITE);
    formatName.setSelectionColor(Constants.DARK_BLUE);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(publisherLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(formatName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(formatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(publisherLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanel2.setBackground(null);
    jPanel2.setMaximumSize(new java.awt.Dimension(475, 42));
    jPanel2.setMinimumSize(new java.awt.Dimension(475, 42));

    isbn13Label.setFont(Constants.DEFAULT_FONT);
    isbn13Label.setForeground(Constants.FONT_COLOR);
    isbn13Label.setLabelFor(isbn13);
    isbn13Label.setText("ISBN-13");
    isbn13Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    isbn13Label.setFocusable(false);
    isbn13Label.setMinimumSize(new java.awt.Dimension(30, 18));
    isbn13Label.setName("ISBN-13 do livro"); // NOI18N
    isbn13Label.setPreferredSize(null);
    isbn13Label.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    isbn13.setEditable(false);
    isbn13.setBackground(null);
    isbn13.setFont(Constants.MEDIUM_FONT);
    isbn13.setForeground(Constants.FONT_COLOR);
    isbn13.setText(book.getIsbn13());
    isbn13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    isbn13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    isbn13.setMargin(new java.awt.Insets(0, 0, 3, 0));
    isbn13.setMinimumSize(new java.awt.Dimension(10, 22));
    isbn13.setName("ISBN-13 do livro"); // NOI18N
    isbn13.setSelectedTextColor(Constants.WHITE);
    isbn13.setSelectionColor(Constants.DARK_BLUE);

    isbn10Label.setFont(Constants.DEFAULT_FONT);
    isbn10Label.setForeground(Constants.FONT_COLOR);
    isbn10Label.setLabelFor(isbn10);
    isbn10Label.setText("ISBN-10");
    isbn10Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    isbn10Label.setFocusable(false);
    isbn10Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    isbn10Label.setMinimumSize(new java.awt.Dimension(30, 18));
    isbn10Label.setName("ISBN-10 do livro"); // NOI18N
    isbn10Label.setPreferredSize(null);
    isbn10Label.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    isbn10.setEditable(false);
    isbn10.setBackground(null);
    isbn10.setFont(Constants.MEDIUM_FONT);
    isbn10.setForeground(Constants.FONT_COLOR);
    isbn10.setText(book.getIsbn10());
    isbn10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    isbn10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    isbn10.setMargin(new java.awt.Insets(0, 0, 3, 0));
    isbn10.setMinimumSize(new java.awt.Dimension(10, 22));
    isbn10.setName("ISBN-10 do livro"); // NOI18N
    isbn10.setPreferredSize(null);
    isbn10.setSelectedTextColor(Constants.WHITE);
    isbn10.setSelectionColor(Constants.DARK_BLUE);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(isbn10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(isbn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(isbn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanel3.setBackground(null);
    jPanel3.setMaximumSize(new java.awt.Dimension(475, 42));
    jPanel3.setMinimumSize(new java.awt.Dimension(475, 42));

    priceLabel.setFont(Constants.DEFAULT_FONT);
    priceLabel.setForeground(Constants.FONT_COLOR);
    priceLabel.setLabelFor(bookPrice);
    priceLabel.setText("Preço");
    priceLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    priceLabel.setFocusable(false);
    priceLabel.setMaximumSize(null);
    priceLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    priceLabel.setName("Preço do livro"); // NOI18N
    priceLabel.setPreferredSize(null);
    priceLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookPrice.setEditable(false);
    bookPrice.setBackground(null);
    bookPrice.setFont(Constants.MEDIUM_FONT);
    bookPrice.setForeground(Constants.FONT_COLOR);
    bookPrice.setText(String.format("R$ %.2f", book.getPrice()));
    bookPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bookPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookPrice.setMargin(new java.awt.Insets(0, 0, 3, 0));
    bookPrice.setMinimumSize(new java.awt.Dimension(10, 22));
    bookPrice.setName("Preço do livro"); // NOI18N
    bookPrice.setPreferredSize(null);
    bookPrice.setSelectedTextColor(Constants.WHITE);
    bookPrice.setSelectionColor(Constants.DARK_BLUE);

    purchaseDateLabel.setFont(Constants.DEFAULT_FONT);
    purchaseDateLabel.setForeground(Constants.FONT_COLOR);
    purchaseDateLabel.setLabelFor(bookPurchaseDate);
    purchaseDateLabel.setText("Adquirido em");
    purchaseDateLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    purchaseDateLabel.setFocusable(false);
    purchaseDateLabel.setMaximumSize(null);
    purchaseDateLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    purchaseDateLabel.setName("Data da compra"); // NOI18N
    purchaseDateLabel.setPreferredSize(null);
    purchaseDateLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookPurchaseDate.setEditable(false);
    bookPurchaseDate.setBackground(null);
    bookPurchaseDate.setFont(Constants.MEDIUM_FONT);
    bookPurchaseDate.setForeground(Constants.FONT_COLOR);
    bookPurchaseDate.setText(Constants.DATE_FORMATTER.format(book.getPurchaseDate()));
    bookPurchaseDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bookPurchaseDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookPurchaseDate.setMargin(new java.awt.Insets(0, 0, 3, 0));
    bookPurchaseDate.setMinimumSize(new java.awt.Dimension(10, 22));
    bookPurchaseDate.setName("Data da compra"); // NOI18N
    bookPurchaseDate.setPreferredSize(null);
    bookPurchaseDate.setSelectedTextColor(Constants.WHITE);
    bookPurchaseDate.setSelectionColor(Constants.DARK_BLUE);

    pagesLabel.setFont(Constants.DEFAULT_FONT);
    pagesLabel.setForeground(Constants.FONT_COLOR);
    pagesLabel.setLabelFor(bookPages);
    pagesLabel.setText("Nº de páginas");
    pagesLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    pagesLabel.setFocusable(false);
    pagesLabel.setMaximumSize(null);
    pagesLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    pagesLabel.setName("Número de páginas"); // NOI18N
    pagesLabel.setPreferredSize(null);
    pagesLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookPages.setEditable(false);
    bookPages.setBackground(null);
    bookPages.setFont(Constants.MEDIUM_FONT);
    bookPages.setForeground(Constants.FONT_COLOR);
    bookPages.setText(String.valueOf(book.getPages()));
    bookPages.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bookPages.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookPages.setMargin(new java.awt.Insets(0, 0, 3, 0));
    bookPages.setMinimumSize(new java.awt.Dimension(10, 22));
    bookPages.setName("Número de páginas"); // NOI18N
    bookPages.setSelectedTextColor(Constants.WHITE);
    bookPages.setSelectionColor(Constants.DARK_BLUE);

    statusLabel.setFont(Constants.DEFAULT_FONT);
    statusLabel.setForeground(Constants.FONT_COLOR);
    statusLabel.setLabelFor(bookStatus);
    statusLabel.setText("Status");
    statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    statusLabel.setFocusable(false);
    statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    statusLabel.setMaximumSize(null);
    statusLabel.setMinimumSize(new java.awt.Dimension(30, 18));
    statusLabel.setName("Status"); // NOI18N
    statusLabel.setPreferredSize(null);
    statusLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookStatus.setEditable(false);
    bookStatus.setBackground(null);
    bookStatus.setFont(Constants.MEDIUM_FONT);
    bookStatus.setForeground(Constants.FONT_COLOR);
    bookStatus.setText(book.isRead() ? "Lido" : "Não lido");
    bookStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bookStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookStatus.setMargin(new java.awt.Insets(0, 0, 3, 0));
    bookStatus.setMinimumSize(new java.awt.Dimension(10, 22));
    bookStatus.setName("Status"); // NOI18N
    bookStatus.setPreferredSize(null);
    bookStatus.setSelectedTextColor(Constants.WHITE);
    bookStatus.setSelectionColor(Constants.DARK_BLUE);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookPurchaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
          .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(bookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel3Layout.createSequentialGroup()
          .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(bookPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(purchaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bookPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(pagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bookPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    purchaseDateLabel.getAccessibleContext().setAccessibleName("Data da compra");
    bookPurchaseDate.getAccessibleContext().setAccessibleName("Data da compra");
    pagesLabel.getAccessibleContext().setAccessibleName("Número de páginas");
    bookPages.getAccessibleContext().setAccessibleName("Número de páginas");

    genresPanel.setBackground(null);
    genresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Constants.FONT_COLOR, 1, true), "Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, Constants.MEDIUM_FONT, Constants.FONT_COLOR));
    genresPanel.setMaximumSize(new java.awt.Dimension(475, 42));
    genresPanel.setMinimumSize(new java.awt.Dimension(475, 42));

    genreLink1.setEditable(false);
    genreLink1.setBackground(null);
    genreLink1.setFont(Constants.MEDIUM_FONT);
    genreLink1.setForeground(Constants.FONT_COLOR);
    genreLink1.setText(genres[0].getName());
    genreLink1.setToolTipText(String.format("Abrir a página da categoria %s", genres[0].getName()));
    genreLink1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    genreLink1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    genreLink1.setMargin(new java.awt.Insets(0, 0, 3, 0));
    genreLink1.setMinimumSize(null);
    genreLink1.setName("Categoria 1"); // NOI18N
    genreLink1.setPreferredSize(null);
    genreLink1.setSelectedTextColor(Constants.WHITE);
    genreLink1.setSelectionColor(Constants.DARK_BLUE);
    genreLink1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        linkFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        linkFocusLost(evt);
      }
    });
    genreLink1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        genreLink1MouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        linkMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        linkMouseExited(evt);
      }
    });

    genreLink2.setEditable(false);
    genreLink2.setBackground(null);
    genreLink2.setFont(Constants.MEDIUM_FONT);
    genreLink2.setForeground(Constants.FONT_COLOR);
    genreLink2.setText(genres.length > 1 ? genres[1].getName() : null);
    genreLink2.setToolTipText(genres.length > 1 ? String.format("Abrir a página da categoria %s", genres[1].getName()) : null);
    genreLink2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    genreLink2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    genreLink2.setEnabled(genres.length > 1);
    genreLink2.setFocusable(genres.length > 1);
    genreLink2.setMargin(new java.awt.Insets(0, 0, 3, 0));
    genreLink2.setMinimumSize(null);
    genreLink2.setName("Categoria 2"); // NOI18N
    genreLink2.setPreferredSize(null);
    genreLink2.setSelectedTextColor(Constants.WHITE);
    genreLink2.setSelectionColor(Constants.DARK_BLUE);
    genreLink2.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        linkFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        linkFocusLost(evt);
      }
    });
    genreLink2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        genreLink2MouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        linkMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        linkMouseExited(evt);
      }
    });

    genreLink3.setEditable(false);
    genreLink3.setBackground(null);
    genreLink3.setFont(Constants.MEDIUM_FONT);
    genreLink3.setForeground(Constants.FONT_COLOR);
    genreLink3.setText(genres.length > 2 ? genres[2].getName() : null);
    genreLink3.setToolTipText(genres.length > 2 ? String.format("Abrir a página da categoria %s", genres[2].getName()) : null);
    genreLink3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    genreLink3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    genreLink3.setEnabled(genres.length > 2);
    genreLink3.setFocusable(genres.length > 2);
    genreLink3.setMargin(new java.awt.Insets(0, 0, 3, 0));
    genreLink3.setMinimumSize(null);
    genreLink3.setName("Categoria 3"); // NOI18N
    genreLink3.setPreferredSize(null);
    genreLink3.setSelectedTextColor(Constants.WHITE);
    genreLink3.setSelectionColor(Constants.DARK_BLUE);
    genreLink3.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        linkFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        linkFocusLost(evt);
      }
    });
    genreLink3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        genreLink3MouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        linkMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        linkMouseExited(evt);
      }
    });

    javax.swing.GroupLayout genresPanelLayout = new javax.swing.GroupLayout(genresPanel);
    genresPanel.setLayout(genresPanelLayout);
    genresPanelLayout.setHorizontalGroup(
      genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(genresPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(genreLink1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(genreLink2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(genreLink3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    genresPanelLayout.setVerticalGroup(
      genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(genresPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(genresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(genreLink1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(genreLink2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(genreLink3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    genreLink1.getAccessibleContext().setAccessibleName("");

    editBookBtn.setBackground(Constants.DARK_BLUE);
    editBookBtn.setFont(Constants.MEDIUM_FONT);
    editBookBtn.setForeground(Constants.WHITE);
    editBookBtn.setText("Editar");
    editBookBtn.setToolTipText("Abrir formulário de edição de livro");
    editBookBtn.setActionCommand("Editar livro");
    editBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

    deleteBookBtn.setBackground(Constants.RED);
    deleteBookBtn.setFont(Constants.MEDIUM_FONT);
    deleteBookBtn.setForeground(Constants.WHITE);
    deleteBookBtn.setText("Excluir");
    deleteBookBtn.setToolTipText(String.format("Excluir o livro %s", book.getTitle()));
    deleteBookBtn.setActionCommand("Excluir livro");
    deleteBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(genresPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(authorLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(bookTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(editBookBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(deleteBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(35, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
            .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20))
          .addGroup(layout.createSequentialGroup()
            .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(deleteBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(authorLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addComponent(genresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(45, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private void showInternalFrame(JInternalFrame frame) {
		getDesktopPane().add(frame);
		frame.moveToFront();
		frame.requestFocus();
	}

	private void authorLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorLinkMouseClicked
		try {
			var view = new AuthorDetails(controllerFactory, author);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, String.format("Erro ao tentar abrir a página do autor:\n%s", e.getMessage()),
					getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_authorLinkMouseClicked

	private void setActiveLink(JTextField link) {
		var color = Constants.BLUE;
		link.setForeground(color);
		link.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
	}

	private void setInactiveLink(JTextField link) {
		var color = Constants.FONT_COLOR;
		link.setForeground(color);
		link.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
	}

	private void linkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkMouseEntered
		var comp = (JTextField) evt.getComponent();
		setActiveLink(comp);
	}//GEN-LAST:event_linkMouseEntered

	private void linkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkMouseExited
		var comp = (JTextField) evt.getComponent();
		setInactiveLink(comp);
	}//GEN-LAST:event_linkMouseExited

	private void linkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_linkFocusGained
		var comp = (JTextField) evt.getComponent();
		setActiveLink(comp);
	}//GEN-LAST:event_linkFocusGained

	private void linkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_linkFocusLost
		var comp = (JTextField) evt.getComponent();
		setInactiveLink(comp);
	}//GEN-LAST:event_linkFocusLost

	private void publisherLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publisherLinkMouseClicked
		try {
			var view = new PublisherDetails(controllerFactory, publisher);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página da editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_publisherLinkMouseClicked

	private void genreLink1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genreLink1MouseClicked
		try {
			var view = new GenreDetails(controllerFactory, genres[0]);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página da categoria:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_genreLink1MouseClicked

	private void genreLink2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genreLink2MouseClicked
		try {
			if (!evt.getComponent().isEnabled()) return;

			var view = new GenreDetails(controllerFactory, genres[1]);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página da editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_genreLink2MouseClicked

	private void genreLink3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genreLink3MouseClicked
		try {
			if (!evt.getComponent().isEnabled()) return;

			var view = new GenreDetails(controllerFactory, genres[2]);
			showInternalFrame(view);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir a página da editora:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_genreLink3MouseClicked

	private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
		try {
			var form = new BookForm(controllerFactory, book);
			showInternalFrame(form);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					String.format("Erro ao tentar abrir o formulário de edição de livro:\n%s", e.getMessage()), getTitle(),
					JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_editBookBtnActionPerformed

	private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookBtnActionPerformed
		try {
			String[] options = { "Sim", "Não" };
			int res = JOptionPane.showOptionDialog(this,
					String.format("Tem certeza que deseja excluir o livro %s?\nNão é possível desfazer esta ação!",
							book.getTitle()),
					getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (res != 0) return;

			bookController.delete(book.getId());
			dispose();
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
  private javax.swing.JLabel authorLabel;
  private javax.swing.JTextField authorLink;
  private javax.swing.JTextField bookPages;
  private javax.swing.JTextField bookPrice;
  private javax.swing.JTextField bookPurchaseDate;
  private javax.swing.JTextField bookStatus;
  private javax.swing.JTextField bookTitle;
  private javax.swing.JLabel bookTitleLabel;
  private javax.swing.JButton deleteBookBtn;
  private javax.swing.JButton editBookBtn;
  private javax.swing.JLabel formatLabel;
  private javax.swing.JTextField formatName;
  private javax.swing.JTextField genreLink1;
  private javax.swing.JTextField genreLink2;
  private javax.swing.JTextField genreLink3;
  private javax.swing.JPanel genresPanel;
  private javax.swing.JTextField isbn10;
  private javax.swing.JLabel isbn10Label;
  private javax.swing.JTextField isbn13;
  private javax.swing.JLabel isbn13Label;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JLabel pagesLabel;
  private javax.swing.JLabel priceLabel;
  private javax.swing.JLabel publisherLabel;
  private javax.swing.JTextField publisherLink;
  private javax.swing.JLabel purchaseDateLabel;
  private javax.swing.JLabel statusLabel;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
