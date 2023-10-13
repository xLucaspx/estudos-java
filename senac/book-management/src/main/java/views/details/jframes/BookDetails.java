/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.details.jframes;

import factory.ControllerFactory;
import static utils.Validator.isValidString;

import models.Book;
import models.Author;
import models.Publisher;
import views.constants.Constants;

public class BookDetails extends javax.swing.JFrame {
  private final ControllerFactory controllerFactory;

  private Book book;
  private Author author;
  private Publisher publisher;

  /*
  falta:
  
    double price;
    LocalDate purchaseDate;
    int pages;
    boolean read;
  
    Set<Genre> genres;
  
    String review;
   */
  public BookDetails(ControllerFactory controllerFactory, Book book) {
    this.controllerFactory = controllerFactory;
    this.book = book;
    this.author = book.getAuthor();
    this.publisher = book.getPublisher();
    initComponents();
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    windowTitle = new javax.swing.JLabel();
    bookTitleLabel = new javax.swing.JLabel();
    bookTitle = new javax.swing.JTextField();
    authorLabel = new javax.swing.JLabel();
    publisherLabel = new javax.swing.JLabel();
    publisherLink = new javax.swing.JLabel();
    formatLabel = new javax.swing.JLabel();
    formatName = new javax.swing.JLabel();
    isbn13Label = new javax.swing.JLabel();
    isbn13 = new javax.swing.JLabel();
    isbn10Label = new javax.swing.JLabel();
    isbn14 = new javax.swing.JLabel();
    authorLink = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(String.format("Livro - %s", book.getTitle()));
    setBackground(Constants.BACKGROUND_COLOR);
    setName("window"); // NOI18N
    setSize(new java.awt.Dimension(450, 300));

    windowTitle.setBackground(Constants.BACKGROUND_COLOR);
    windowTitle.setFont(Constants.LARGE_FONT);
    windowTitle.setForeground(Constants.FONT_COLOR);
    windowTitle.setLabelFor(this);
    windowTitle.setText("Página de livro");
    windowTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    windowTitle.setFocusable(false);
    windowTitle.setName("Página de livro"); // NOI18N
    windowTitle.setPreferredSize(new java.awt.Dimension(650, 30));
    windowTitle.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    bookTitleLabel.setBackground(Constants.BACKGROUND_COLOR);
    bookTitleLabel.setFont(Constants.DEFAULT_FONT);
    bookTitleLabel.setForeground(Constants.FONT_COLOR);
    bookTitleLabel.setLabelFor(bookTitle);
    bookTitleLabel.setText("Título");
    bookTitleLabel.setFocusable(false);
    bookTitleLabel.setMaximumSize(null);
    bookTitleLabel.setMinimumSize(new java.awt.Dimension(20, 18));
    bookTitleLabel.setName(""); // NOI18N
    bookTitleLabel.setPreferredSize(null);

    bookTitle.setEditable(false);
    bookTitle.setBackground(null);
    bookTitle.setFont(Constants.TITLE_FONT);
    bookTitle.setForeground(Constants.FONT_COLOR);
    bookTitle.setText(book.getTitle());
    bookTitle.setBorder(null);
    bookTitle.setCaretColor(Constants.FONT_COLOR);
    bookTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    bookTitle.setMinimumSize(new java.awt.Dimension(20, 30));
    bookTitle.setName("Título do livro"); // NOI18N
    bookTitle.setPreferredSize(null);
    bookTitle.setSelectedTextColor(Constants.WHITE);
    bookTitle.setSelectionColor(Constants.DARK_BLUE);

    authorLabel.setBackground(Constants.BACKGROUND_COLOR);
    authorLabel.setFont(Constants.DEFAULT_FONT);
    authorLabel.setForeground(Constants.FONT_COLOR);
    authorLabel.setLabelFor(authorLink);
    authorLabel.setText("Autor");
    authorLabel.setFocusable(false);
    authorLabel.setMaximumSize(null);
    authorLabel.setMinimumSize(new java.awt.Dimension(20, 18));
    authorLabel.setName(""); // NOI18N
    authorLabel.setPreferredSize(null);

    publisherLabel.setBackground(Constants.BACKGROUND_COLOR);
    publisherLabel.setFont(Constants.DEFAULT_FONT);
    publisherLabel.setForeground(Constants.FONT_COLOR);
    publisherLabel.setLabelFor(publisherLink);
    publisherLabel.setText("Editora");
    publisherLabel.setFocusable(false);
    publisherLabel.setMinimumSize(new java.awt.Dimension(20, 18));

    publisherLink.setBackground(Constants.BACKGROUND_COLOR);
    publisherLink.setFont(Constants.MEDIUM_FONT);
    publisherLink.setForeground(Constants.FONT_COLOR);
    publisherLink.setText(publisher.getName());
    publisherLink.setToolTipText(String.format("Abrir a página da editora %s", publisher.getName())
    );
    publisherLink.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    publisherLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    publisherLink.setMaximumSize(null);
    publisherLink.setMinimumSize(new java.awt.Dimension(20, 20));
    publisherLink.setName("Editora do livro"); // NOI18N
    publisherLink.setPreferredSize(null);
    publisherLink.setRequestFocusEnabled(false);
    publisherLink.setVerifyInputWhenFocusTarget(false);
    publisherLink.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    formatLabel.setBackground(Constants.BACKGROUND_COLOR);
    formatLabel.setFont(Constants.DEFAULT_FONT);
    formatLabel.setForeground(Constants.FONT_COLOR);
    formatLabel.setLabelFor(formatName);
    formatLabel.setText("Formato");
    formatLabel.setFocusable(false);
    formatLabel.setMaximumSize(null);
    formatLabel.setMinimumSize(new java.awt.Dimension(20, 18));
    formatLabel.setPreferredSize(null);

    formatName.setBackground(Constants.BACKGROUND_COLOR);
    formatName.setFont(Constants.MEDIUM_FONT);
    formatName.setForeground(Constants.FONT_COLOR);
    formatName.setText(book.getFormat().toString());
    formatName.setMaximumSize(null);
    formatName.setMinimumSize(new java.awt.Dimension(20, 20));
    formatName.setName("Formato do livro"); // NOI18N
    formatName.setPreferredSize(null);
    formatName.setRequestFocusEnabled(false);
    formatName.setVerifyInputWhenFocusTarget(false);
    formatName.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    isbn13Label.setBackground(Constants.BACKGROUND_COLOR);
    isbn13Label.setFont(Constants.DEFAULT_FONT);
    isbn13Label.setForeground(Constants.FONT_COLOR);
    isbn13Label.setLabelFor(isbn13);
    isbn13Label.setText("ISBN-13");
    isbn13Label.setFocusable(false);
    isbn13Label.setMinimumSize(new java.awt.Dimension(20, 18));

    isbn13.setBackground(Constants.BACKGROUND_COLOR);
    isbn13.setFont(Constants.MEDIUM_FONT);
    isbn13.setForeground(Constants.FONT_COLOR);
    isbn13.setText(book.getIsbn13());
    isbn13.setMaximumSize(null);
    isbn13.setMinimumSize(new java.awt.Dimension(20, 20));
    isbn13.setName("ISBN-13 do livro"); // NOI18N
    isbn13.setPreferredSize(null);
    isbn13.setRequestFocusEnabled(false);
    isbn13.setVerifyInputWhenFocusTarget(false);
    isbn13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    isbn10Label.setBackground(Constants.BACKGROUND_COLOR);
    isbn10Label.setFont(Constants.DEFAULT_FONT);
    isbn10Label.setForeground(Constants.FONT_COLOR);
    isbn10Label.setLabelFor(isbn14);
    isbn10Label.setText("ISBN-10");
    isbn10Label.setFocusable(false);
    isbn10Label.setMinimumSize(new java.awt.Dimension(20, 18));

    isbn14.setBackground(Constants.BACKGROUND_COLOR);
    isbn14.setFont(Constants.MEDIUM_FONT);
    isbn14.setForeground(Constants.FONT_COLOR);
    isbn14.setText(isValidString(book.getIsbn10()) ? book.getIsbn10() : "Não cadastrado");
    isbn14.setMaximumSize(null);
    isbn14.setMinimumSize(new java.awt.Dimension(20, 20));
    isbn14.setName("ISBN-10 do livro"); // NOI18N
    isbn14.setPreferredSize(null);
    isbn14.setRequestFocusEnabled(false);
    isbn14.setVerifyInputWhenFocusTarget(false);
    isbn14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    authorLink.setEditable(false);
    authorLink.setBackground(null);
    authorLink.setFont(Constants.LARGE_FONT);
    authorLink.setForeground(Constants.FONT_COLOR);
    authorLink.setText(author.getName());
    authorLink.setToolTipText(String.format("Abrir a página do autor %s", author.getName()));
    authorLink.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Constants.FONT_COLOR));
    authorLink.setCaretColor(Constants.FONT_COLOR);
    authorLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    authorLink.setMinimumSize(new java.awt.Dimension(20, 22));
    authorLink.setName("Autor do livro"); // NOI18N
    authorLink.setPreferredSize(null);
    authorLink.setSelectedTextColor(Constants.WHITE);
    authorLink.setSelectionColor(Constants.DARK_BLUE);
    authorLink.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        authorLinkMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(50, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(authorLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(windowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(isbn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(publisherLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(formatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(isbn14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(153, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(326, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(35, Short.MAX_VALUE)
        .addComponent(windowTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        .addGap(30, 30, 30)
        .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(authorLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(publisherLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(formatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(formatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(isbn13Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(isbn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(isbn10Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(isbn14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(45, Short.MAX_VALUE))
    );

    bookTitleLabel.getAccessibleContext().setAccessibleName("Título do livro");
    bookTitle.getAccessibleContext().setAccessibleName("Título do livro");
    publisherLink.getAccessibleContext().setAccessibleName("Editora do livro");
    formatName.getAccessibleContext().setAccessibleName("Formato do livro");
    isbn13.getAccessibleContext().setAccessibleName("ISBN-13 do livro");
    isbn14.getAccessibleContext().setAccessibleName("ISBN-10 do livro");
    authorLink.getAccessibleContext().setAccessibleName("Autor do livro");

    getAccessibleContext().setAccessibleName("Página de livro");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void authorLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorLinkMouseClicked
    var view = new AuthorDetails(controllerFactory, author);
    view.setVisible(true);
  }//GEN-LAST:event_authorLinkMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel authorLabel;
  private javax.swing.JTextField authorLink;
  private javax.swing.JTextField bookTitle;
  private javax.swing.JLabel bookTitleLabel;
  private javax.swing.JLabel formatLabel;
  private javax.swing.JLabel formatName;
  private javax.swing.JLabel isbn10Label;
  private javax.swing.JLabel isbn13;
  private javax.swing.JLabel isbn13Label;
  private javax.swing.JLabel isbn14;
  private javax.swing.JLabel publisherLabel;
  private javax.swing.JLabel publisherLink;
  private javax.swing.JLabel windowTitle;
  // End of variables declaration//GEN-END:variables
}
