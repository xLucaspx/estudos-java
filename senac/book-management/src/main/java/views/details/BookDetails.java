/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.details;

import models.Book;
import views.constants.Constants;

public class BookDetails extends javax.swing.JFrame {

  private Book book;

  /*
  	int id;
    int pages;
    double price;
    boolean read;
    String title;
    String isbn10;
    String isbn13;
    String review;
    Format format;
    Author author;
    Publisher publisher;
    LocalDate purchaseDate;
    Set<Genre> genres;
   */
  public BookDetails(Book book) {
    this.book = book;
    initComponents();
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(String.format("Livro - %s", book.getTitle()));
    setBackground(Constants.BACKGROUND_COLOR);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 727, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 438, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
