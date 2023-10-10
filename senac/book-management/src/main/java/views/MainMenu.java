/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Component;

import views.constants.Constants;
import views.forms.AuthorForm;
import views.forms.BookForm;
import views.forms.GenreForm;
import views.forms.PublisherForm;
import views.lists.AuthorList;
import views.lists.BookList;
import views.lists.GenreList;
import views.lists.PublisherList;

public class MainMenu extends javax.swing.JFrame {

	public MainMenu() {
		initComponents();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		sidebarPanel = new javax.swing.JPanel();
		listMenusPanel = new javax.swing.JPanel();
		listMenusLabel = new javax.swing.JLabel();
		bookListBtn = new javax.swing.JButton();
		authorListBtn = new javax.swing.JButton();
		genreListBtn = new javax.swing.JButton();
		publisherListBtn = new javax.swing.JButton();
		formMenusPanel = new javax.swing.JPanel();
		formMenusLabel = new javax.swing.JLabel();
		bookFormBtn = new javax.swing.JButton();
		authorFormBtn = new javax.swing.JButton();
		genreFormBtn = new javax.swing.JButton();
		publisherFormBtn = new javax.swing.JButton();

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

		listMenusPanel.setBackground(Constants.BLUE);
		listMenusPanel.setForeground(Constants.WHITE);
		listMenusPanel.setFocusable(false);
		listMenusPanel.setFont(Constants.DEFAULT_FONT);
		listMenusPanel.setMinimumSize(new java.awt.Dimension(280, 195));
		listMenusPanel.setName("Menu de cadastros"); // NOI18N

		listMenusLabel.setBackground(Constants.BLUE);
		listMenusLabel.setFont(Constants.MEDIUM_FONT);
		listMenusLabel.setForeground(Constants.WHITE);
		listMenusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		listMenusLabel.setLabelFor(listMenusPanel);
		listMenusLabel.setText("Listas");
		listMenusLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		listMenusLabel.setMaximumSize(new java.awt.Dimension(280, 20));

		bookListBtn.setBackground(Constants.BLUE);
		bookListBtn.setFont(Constants.LARGE_FONT);
		bookListBtn.setForeground(Constants.WHITE);
		bookListBtn.setText("Lista de livros");
		bookListBtn.setToolTipText("Abrir a lista de livros");
		bookListBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		bookListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bookListBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bookListBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		bookListBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		bookListBtn.setName("Botão listar livros"); // NOI18N
		bookListBtn.setNextFocusableComponent(authorListBtn);
		bookListBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		bookListBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		bookListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		bookListBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bookListBtnActionPerformed(evt);
			}
		});

		authorListBtn.setBackground(Constants.BLUE);
		authorListBtn.setFont(Constants.LARGE_FONT);
		authorListBtn.setForeground(Constants.WHITE);
		authorListBtn.setText("Lista de autores");
		authorListBtn.setToolTipText("Abrir a lista de autores");
		authorListBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		authorListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		authorListBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		authorListBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		authorListBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		authorListBtn.setName("Botão listar autores"); // NOI18N
		authorListBtn.setNextFocusableComponent(genreListBtn);
		authorListBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		authorListBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		authorListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		authorListBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				authorListBtnActionPerformed(evt);
			}
		});

		genreListBtn.setBackground(Constants.BLUE);
		genreListBtn.setFont(Constants.LARGE_FONT);
		genreListBtn.setForeground(Constants.WHITE);
		genreListBtn.setText("Lista de categorias");
		genreListBtn.setToolTipText("Abrir a lista de categorias");
		genreListBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		genreListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		genreListBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		genreListBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		genreListBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		genreListBtn.setName("Botão listar categorias"); // NOI18N
		genreListBtn.setNextFocusableComponent(publisherListBtn);
		genreListBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		genreListBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		genreListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		genreListBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				genreListBtnActionPerformed(evt);
			}
		});

		publisherListBtn.setBackground(Constants.BLUE);
		publisherListBtn.setFont(Constants.LARGE_FONT);
		publisherListBtn.setForeground(Constants.WHITE);
		publisherListBtn.setText("Lista de editoras");
		publisherListBtn.setToolTipText("Abrir a lista de editoras");
		publisherListBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		publisherListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		publisherListBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		publisherListBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		publisherListBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		publisherListBtn.setName("Botão listar editoras"); // NOI18N
		publisherListBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		publisherListBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		publisherListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		publisherListBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				publisherListBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout listMenusPanelLayout = new javax.swing.GroupLayout(listMenusPanel);
		listMenusPanel.setLayout(listMenusPanelLayout);
		listMenusPanelLayout
				.setHorizontalGroup(listMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(listMenusPanelLayout.createSequentialGroup()
								.addGroup(listMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(authorListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(genreListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(publisherListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(bookListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(listMenusPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(listMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		listMenusPanelLayout
				.setVerticalGroup(listMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(listMenusPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(listMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bookListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(authorListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(genreListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(publisherListBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(21, Short.MAX_VALUE)));

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
		bookFormBtn.setFont(Constants.LARGE_FONT);
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
		authorFormBtn.setFont(Constants.LARGE_FONT);
		authorFormBtn.setForeground(Constants.WHITE);
		authorFormBtn.setText("Cadastro de autor");
		authorFormBtn.setToolTipText("Abrir o formulário de cadastro de autores");
		authorFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		authorFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		authorFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		authorFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		authorFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		authorFormBtn.setName("Botão cadastro de autor"); // NOI18N
		authorFormBtn.setNextFocusableComponent(genreFormBtn);
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

		genreFormBtn.setBackground(Constants.BLUE);
		genreFormBtn.setFont(Constants.LARGE_FONT);
		genreFormBtn.setForeground(Constants.WHITE);
		genreFormBtn.setText("Cadastro de categoria");
		genreFormBtn.setToolTipText("Abrir o formulário de cadastro de categorias");
		genreFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		genreFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		genreFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		genreFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		genreFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		genreFormBtn.setName("Botão cadastro de categoria"); // NOI18N
		genreFormBtn.setNextFocusableComponent(publisherFormBtn);
		genreFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		genreFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		genreFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		genreFormBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				genreFormBtnActionPerformed(evt);
			}
		});

		publisherFormBtn.setBackground(Constants.BLUE);
		publisherFormBtn.setFont(Constants.LARGE_FONT);
		publisherFormBtn.setForeground(Constants.WHITE);
		publisherFormBtn.setText("Cadastro de editora");
		publisherFormBtn.setToolTipText("Abrir o formulário de cadastro de editoras");
		publisherFormBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.WHITE));
		publisherFormBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		publisherFormBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		publisherFormBtn.setMaximumSize(new java.awt.Dimension(280, 30));
		publisherFormBtn.setMinimumSize(new java.awt.Dimension(280, 30));
		publisherFormBtn.setName("Botão cadastro de editora"); // NOI18N
		publisherFormBtn.setPreferredSize(new java.awt.Dimension(280, 30));
		publisherFormBtn.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formBtnFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				formBtnFocusLost(evt);
			}
		});
		publisherFormBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				formBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				formBtnMouseExited(evt);
			}
		});
		publisherFormBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				publisherFormBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout formMenusPanelLayout = new javax.swing.GroupLayout(formMenusPanel);
		formMenusPanel.setLayout(formMenusPanelLayout);
		formMenusPanelLayout
				.setHorizontalGroup(formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(formMenusPanelLayout.createSequentialGroup()
								.addGroup(formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(authorFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(genreFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(publisherFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(bookFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(formMenusPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(formMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		formMenusPanelLayout
				.setVerticalGroup(formMenusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(formMenusPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(formMenusLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bookFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(authorFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(genreFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(publisherFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(21, Short.MAX_VALUE)));

		javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
		sidebarPanel.setLayout(sidebarPanelLayout);
		sidebarPanelLayout
				.setHorizontalGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(sidebarPanelLayout.createSequentialGroup()
								.addGap(0, 0, 0)
								.addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(listMenusPanel, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(formMenusPanel, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		sidebarPanelLayout
				.setVerticalGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(sidebarPanelLayout.createSequentialGroup()
								.addComponent(listMenusPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(formMenusPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 204, Short.MAX_VALUE)));

		formMenusPanel.getAccessibleContext().setAccessibleName("Menu de cadastros");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 629, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		sidebarPanel.getAccessibleContext().setAccessibleName("Menu lateral");

		getAccessibleContext().setAccessibleDescription("Menu principal do sistema de gerenciamento de livros");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void bookFormBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookFormBtnActionPerformed
		var bookForm = new BookForm();
		bookForm.setVisible(true);
	}// GEN-LAST:event_bookFormBtnActionPerformed

	private void authorFormBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_authorFormBtnActionPerformed
		var authorForm = new AuthorForm();
		authorForm.setVisible(true);
	}// GEN-LAST:event_authorFormBtnActionPerformed

	private void formBtnFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_formBtnFocusGained
		Component c = evt.getComponent();
		c.setBackground(Constants.DARK_BLUE);
	}// GEN-LAST:event_formBtnFocusGained

	private void formBtnFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_formBtnFocusLost
		Component c = evt.getComponent();
		c.setBackground(Constants.BLUE);
	}// GEN-LAST:event_formBtnFocusLost

	private void formBtnMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formBtnMouseEntered
		Component c = evt.getComponent();
		c.setBackground(Constants.DARK_BLUE);
	}// GEN-LAST:event_formBtnMouseEntered

	private void formBtnMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formBtnMouseExited
		Component c = evt.getComponent();
		c.setBackground(Constants.BLUE);
	}// GEN-LAST:event_formBtnMouseExited

	private void genreFormBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genreFormBtnActionPerformed
		var genreForm = new GenreForm();
		genreForm.setVisible(true);
	}// GEN-LAST:event_genreFormBtnActionPerformed

	private void publisherFormBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_publisherFormBtnActionPerformed
		var publisherForm = new PublisherForm();
		publisherForm.setVisible(true);
	}// GEN-LAST:event_publisherFormBtnActionPerformed

	private void bookListBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookListBtnActionPerformed
		var bookList = new BookList();
		bookList.setVisible(true);
	}// GEN-LAST:event_bookListBtnActionPerformed

	private void authorListBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_authorListBtnActionPerformed
		var authorList = new AuthorList();
		authorList.setVisible(true);
	}// GEN-LAST:event_authorListBtnActionPerformed

	private void genreListBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genreListBtnActionPerformed
		var genreList = new GenreList();
		genreList.setVisible(true);
	}// GEN-LAST:event_genreListBtnActionPerformed

	private void publisherListBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_publisherListBtnActionPerformed
		var publisherList = new PublisherList();
		publisherList.setVisible(true);
	}// GEN-LAST:event_publisherListBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton authorFormBtn;
	private javax.swing.JButton authorListBtn;
	private javax.swing.JButton bookFormBtn;
	private javax.swing.JButton bookListBtn;
	private javax.swing.JLabel formMenusLabel;
	private javax.swing.JPanel formMenusPanel;
	private javax.swing.JButton genreFormBtn;
	private javax.swing.JButton genreListBtn;
	private javax.swing.JLabel listMenusLabel;
	private javax.swing.JPanel listMenusPanel;
	private javax.swing.JButton publisherFormBtn;
	private javax.swing.JButton publisherListBtn;
	private javax.swing.JPanel sidebarPanel;
	// End of variables declaration//GEN-END:variables
}
