/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.forms.CategoryForm;
import views.forms.BookForm;
import views.forms.AuthorForm;
import views.forms.FormatForm;
import java.awt.Component;
import views.constants.Constants;

public class MainMenu extends javax.swing.JFrame {

  public MainMenu() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    sidebarPanel = new javax.swing.JPanel();
    formMenusPanel = new javax.swing.JPanel();
    formMenusLabel = new javax.swing.JLabel();
    bookFormBtn = new javax.swing.JButton();
    authorFormBtn = new javax.swing.JButton();
    categoryFormBtn = new javax.swing.JButton();
    formatFormBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Gerenciamento de livros");
    setBackground(Constants.BACKGROUND_COLOR);
    setFont(Constants.DEFAULT_FONT);
    setForeground(Constants.FONT_COLOR);
    setName("window"); // NOI18N

    sidebarPanel.setBackground(Constants.BLUE);
    sidebarPanel.setForeground(Constants.WHITE);
    sidebarPanel.setFocusable(false);
    sidebarPanel.setFont(Constants.DEFAULT_FONT);
    sidebarPanel.setMinimumSize(new java.awt.Dimension(280, 600));
    sidebarPanel.setName("Menu lateral"); // NOI18N
    sidebarPanel.setPreferredSize(new java.awt.Dimension(280, 600));

    formMenusPanel.setBackground(Constants.BLUE);
    formMenusPanel.setForeground(Constants.WHITE);
    formMenusPanel.setFocusable(false);
    formMenusPanel.setFont(Constants.DEFAULT_FONT);
    formMenusPanel.setMinimumSize(new java.awt.Dimension(280, 195));
    formMenusPanel.setName("Menu de cadastros"); // NOI18N
    formMenusPanel.setPreferredSize(new java.awt.Dimension(280, 195));

    formMenusLabel.setBackground(Constants.BLUE);
    formMenusLabel.setFont(Constants.MEDIUM_FONT);
    formMenusLabel.setForeground(Constants.WHITE);
    formMenusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    formMenusLabel.setLabelFor(formMenusPanel);
    formMenusLabel.setText("Cadastros");
    formMenusLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
    formMenusLabel.setMaximumSize(new java.awt.Dimension(280, 20));

    bookFormBtn.setBackground(Constants.BLUE);
    bookFormBtn.setFont(Constants.MEDIUM_FONT);
    bookFormBtn.setForeground(Constants.WHITE);
    bookFormBtn.setText("Cadastro de livro");
    bookFormBtn.setToolTipText("Abrir o formulário de cadastro de livros");
    bookFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
    bookFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bookFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bookFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
    bookFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
    bookFormBtn.setName("Botão cadastro de livro"); // NOI18N
    bookFormBtn.setNextFocusableComponent(authorFormBtn);
    bookFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
    bookFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formBtnFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        formBtnFocusLost(evt);
      }
    });
    bookFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formBtnMouseExited(evt);
      }
    });
    bookFormBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bookFormBtnActionPerformed(evt);
      }
    });

    authorFormBtn.setBackground(Constants.BLUE);
    authorFormBtn.setFont(Constants.MEDIUM_FONT);
    authorFormBtn.setForeground(Constants.WHITE);
    authorFormBtn.setText("Cadastro de autor");
    authorFormBtn.setToolTipText("Abrir o formulário de cadastro de autores");
    authorFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
    authorFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    authorFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    authorFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
    authorFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
    authorFormBtn.setName("Botão cadastro de autor"); // NOI18N
    authorFormBtn.setNextFocusableComponent(categoryFormBtn);
    authorFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
    authorFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formBtnFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        formBtnFocusLost(evt);
      }
    });
    authorFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formBtnMouseExited(evt);
      }
    });
    authorFormBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorFormBtnActionPerformed(evt);
      }
    });

    categoryFormBtn.setBackground(Constants.BLUE);
    categoryFormBtn.setFont(Constants.MEDIUM_FONT);
    categoryFormBtn.setForeground(Constants.WHITE);
    categoryFormBtn.setText("Cadastro de categoria");
    categoryFormBtn.setToolTipText("Abrir o formulário de cadastro de categorias");
    categoryFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
    categoryFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    categoryFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    categoryFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
    categoryFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
    categoryFormBtn.setName("Botão cadastro de categoria"); // NOI18N
    categoryFormBtn.setNextFocusableComponent(formatFormBtn);
    categoryFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
    categoryFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formBtnFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        formBtnFocusLost(evt);
      }
    });
    categoryFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formBtnMouseExited(evt);
      }
    });
    categoryFormBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        categoryFormBtnActionPerformed(evt);
      }
    });

    formatFormBtn.setBackground(Constants.BLUE);
    formatFormBtn.setFont(Constants.MEDIUM_FONT);
    formatFormBtn.setForeground(Constants.WHITE);
    formatFormBtn.setText("Cadastro de formato");
    formatFormBtn.setToolTipText("Abrir o formulário de cadastro de formatos");
    formatFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
    formatFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    formatFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    formatFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
    formatFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
    formatFormBtn.setName("Botão cadastro de formato"); // NOI18N
    formatFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
    formatFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formBtnFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        formBtnFocusLost(evt);
      }
    });
    formatFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formBtnMouseExited(evt);
      }
    });
    formatFormBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        formatFormBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout formMenusPanelLayout = new javax.swing.GroupLayout(formMenusPanel);
    formMenusPanel.setLayout(formMenusPanelLayout);
    formMenusPanelLayout.setHorizontalGroup(
      formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formMenusPanelLayout.createSequentialGroup()
        .addGroup(formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(authorFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(categoryFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(formatFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, Short.MAX_VALUE))
      .addGroup(formMenusPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(formMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    formMenusPanelLayout.setVerticalGroup(
      formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formMenusPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(formMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bookFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(authorFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(categoryFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(formatFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(21, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
    sidebarPanel.setLayout(sidebarPanelLayout);
    sidebarPanelLayout.setHorizontalGroup(
      sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(sidebarPanelLayout.createSequentialGroup()
        .addComponent(formMenusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    sidebarPanelLayout.setVerticalGroup(
      sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(sidebarPanelLayout.createSequentialGroup()
        .addComponent(formMenusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 405, Short.MAX_VALUE))
    );

    formMenusPanel.getAccessibleContext().setAccessibleName("Menu de cadastros");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 629, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    sidebarPanel.getAccessibleContext().setAccessibleName("Menu lateral");

    getAccessibleContext().setAccessibleDescription("Menu principal do sistema de gerenciamento de livros");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void bookFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookFormBtnActionPerformed
    var bookForm = new BookForm();
    bookForm.setVisible(true);
  }//GEN-LAST:event_bookFormBtnActionPerformed

  private void authorFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorFormBtnActionPerformed
    var authorForm = new AuthorForm();
    authorForm.setVisible(true);
  }//GEN-LAST:event_authorFormBtnActionPerformed

  private void formBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formBtnFocusGained
    Component c = evt.getComponent();
    c.setBackground(Constants.DARK_BLUE);
  }//GEN-LAST:event_formBtnFocusGained

  private void formBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formBtnFocusLost
    Component c = evt.getComponent();
    c.setBackground(Constants.BLUE);
  }//GEN-LAST:event_formBtnFocusLost

  private void formBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formBtnMouseEntered
    Component c = evt.getComponent();
    c.setBackground(Constants.DARK_BLUE);
  }//GEN-LAST:event_formBtnMouseEntered

  private void formBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formBtnMouseExited
    Component c = evt.getComponent();
    c.setBackground(Constants.BLUE);
  }//GEN-LAST:event_formBtnMouseExited

  private void categoryFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFormBtnActionPerformed
    var categoryForm = new CategoryForm();
    categoryForm.setVisible(true);
  }//GEN-LAST:event_categoryFormBtnActionPerformed

  private void formatFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatFormBtnActionPerformed
    var formatForm = new FormatForm();
    formatForm.setVisible(true);
  }//GEN-LAST:event_formatFormBtnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton authorFormBtn;
  private javax.swing.JButton bookFormBtn;
  private javax.swing.JButton categoryFormBtn;
  private javax.swing.JLabel formMenusLabel;
  private javax.swing.JPanel formMenusPanel;
  private javax.swing.JButton formatFormBtn;
  private javax.swing.JPanel sidebarPanel;
  // End of variables declaration//GEN-END:variables
}
