package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.CategoriaController;
import controller.ProdutoController;
import models.Categoria;
import models.Produto;

public class ProdutoCategoriaFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel labelNome, labelDescricao, labelCategoria;
	private JTextField campoNome, campoDescricao;
	private JComboBox<Categoria> campoCategoria;
	private JButton botaoCadastrar, botaoLimpar, botaoAtualizar, botaoDeletar, botaoEditar;
	private JScrollPane panel;
	private JTable tabela;
	private DefaultTableModel modeloTabela;

	private ProdutoController produtoController;
	private CategoriaController categoriaController;

	public ProdutoCategoriaFrame() {
		super("Produtos"); // title
		Container container = getContentPane();
		setLayout(null);

		this.categoriaController = new CategoriaController();
		this.produtoController = new ProdutoController();

		labelNome = new JLabel("Nome do produto");
		labelDescricao = new JLabel("Descrição do produto");
		labelCategoria = new JLabel("Categoria do produto");

		labelNome.setBounds(10, 10, 240, 15);
		labelDescricao.setBounds(10, 50, 240, 15);
		labelCategoria.setBounds(10, 90, 240, 15);

		labelNome.setForeground(Color.BLACK);
		labelDescricao.setForeground(Color.BLACK);
		labelCategoria.setForeground(Color.BLACK);

		container.add(labelNome);
		container.add(labelDescricao);
		container.add(labelCategoria);

		campoNome = new JTextField();
		campoDescricao = new JTextField();
		campoCategoria = new JComboBox<>();

		List<Categoria> categorias = listaCategorias();
		categorias.forEach(categoria -> campoCategoria.addItem(categoria));

		campoNome.setBounds(10, 25, 270, 20);
		campoDescricao.setBounds(10, 65, 270, 20);
		campoCategoria.setBounds(10, 105, 270, 20);

		container.add(campoNome);
		container.add(campoDescricao);
		container.add(campoCategoria);

		botaoCadastrar = new JButton("Salvar");
		botaoLimpar = new JButton("Limpar");
		botaoAtualizar = new JButton("Atualizar");

		botaoCadastrar.setBounds(10, 145, 80, 20);
		botaoLimpar.setBounds(100, 145, 80, 20);
		botaoAtualizar.setBounds(190, 145, 90, 20);

		container.add(botaoCadastrar);
		container.add(botaoLimpar);
		container.add(botaoAtualizar);

		String columnNames[] = { "Id do produto", "Nome do produto", "Descrição do produto", "Id da categoria" };
		modeloTabela = new DefaultTableModel(columnNames, 0);
		tabela = new JTable(modeloTabela);

		TableColumn column0 = tabela.getColumnModel().getColumn(0);
		TableColumn column1 = tabela.getColumnModel().getColumn(1);
		TableColumn column2 = tabela.getColumnModel().getColumn(2);
		TableColumn column3 = tabela.getColumnModel().getColumn(3);

		column0.setPreferredWidth(100);
		column1.setPreferredWidth(190);
		column2.setPreferredWidth(370);
		column3.setPreferredWidth(100);

		limpaTabela();
		preencheTabela();

		panel = new JScrollPane(tabela);
		panel.setBounds(10, 185, 760, 300);
		container.add(panel);

		botaoDeletar = new JButton("Excluir");
		botaoEditar = new JButton("Editar");

		botaoDeletar.setBounds(10, 500, 80, 20);
		botaoEditar.setBounds(100, 500, 80, 20);

		container.add(botaoDeletar);
		container.add(botaoEditar);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				cadastraProduto();
				limpaTabela();
				preencheTabela();
			}
		});

		botaoLimpar.addActionListener(event -> limpaCampos());

		botaoAtualizar.addActionListener(event -> {
			limpaTabela();
			preencheTabela();
		});

		botaoDeletar.addActionListener(event -> {
			deletaProduto();
			limpaTabela();
			preencheTabela();
		});

		botaoEditar.addActionListener(event -> {
			editaProduto();
			limpaTabela();
			preencheTabela();
		});
	}

	private List<Categoria> listaCategorias() {
		return categoriaController.listaCategorias();
	}

	private List<Produto> listaProdutos() {
		return produtoController.listaProdutos();
	}

	private void preencheTabela() {
		List<Produto> produtos = listaProdutos();

		try {
			produtos.forEach(produto -> modeloTabela.addRow(new Object[] { produto.getId(), produto.getNome(),
					produto.getDescricao(), produto.getCategoriaId() }));

		} catch (Exception e) {
			throw e;
		}
	}

	private void limpaTabela() {
		modeloTabela.getDataVector().clear();
	}

	private void limpaCampos() {
		campoNome.setText("");
		campoDescricao.setText("");
	}

	private void cadastraProduto() {
		if (!campoNome.getText().isEmpty() && !campoDescricao.getText().isEmpty()) {

			Categoria categoria = (Categoria) campoCategoria.getSelectedItem();
			Produto produto = new Produto(campoNome.getText(), campoDescricao.getText(), categoria.getId());

			produtoController.cadastra(produto);
			String message = "Produto cadastrado com sucesso!\n Id: " + produto.getId();

			JOptionPane.showMessageDialog(this, message, "Produto cadastrado", JOptionPane.INFORMATION_MESSAGE, null);
			limpaCampos();

		} else {
			String message = "Erro ao tentar cadastrar o produto:\nTodos os campos devem ser preenchidos!";
			JOptionPane.showMessageDialog(this, message, "Atenção!", JOptionPane.WARNING_MESSAGE, null);
		}
	}

	private void editaProduto() {
		if (tabela.getSelectedColumn() == 0) {
			Integer id = (Integer) modeloTabela.getValueAt(tabela.getSelectedRow(), 0);
			String nome = (String) modeloTabela.getValueAt(tabela.getSelectedRow(), 1);
			String descricao = (String) modeloTabela.getValueAt(tabela.getSelectedRow(), 2);

			produtoController.editaProduto(nome, descricao, id);

			String message = String.format("Produto %d editado com sucesso!", id);
			JOptionPane.showMessageDialog(this, message, "Produto editado", JOptionPane.INFORMATION_MESSAGE, null);

		} else {
			String message = "Por favor, selecione o Id do produto que deseja editar\ndepois clique novamente no botão \"Editar\".";
			JOptionPane.showMessageDialog(this, message, "Atenção!", JOptionPane.WARNING_MESSAGE, null);
		}
	}

	private void deletaProduto() {
		Integer id = (Integer) modeloTabela.getValueAt(tabela.getSelectedRow(), 0);

		produtoController.deletaProduto(id);
		modeloTabela.removeRow(tabela.getSelectedRow());

		String message = String.format("Produto %d excluído com sucesso!", id);
		JOptionPane.showMessageDialog(this, message, "Produto excluído", JOptionPane.INFORMATION_MESSAGE, null);
	}
}
