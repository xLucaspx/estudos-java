package views;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import components.Button;
import components.Input;
import components.Label;
import javafx.scene.control.CheckBox;
import models.Pizza;

public class FormPedido extends JFrame {
  private JPanel contentPane, body;
  private JLabel logo, imgPepperoni, imgBasca, imgFrangoBacon, imgCincoQueijos, imgChocolateMorango;
  private Label titulo, subtitulo, labelNome, labelTelefone, labelEndereco, labelCidade, labelSabor, labelTamanho,
  labelOpcionais, labelUnidades, labelValorItem, labelItens, labelSubtotal;
  private Input inputNome, inputTelefone, inputEndereco, inputUnidades;
  private JComboBox<String> comboCidade;
  private ButtonGroup btnGroupSabor, btnGroupTamanho;
  private CheckBox checkMassaIntegral, checkBaconExtra, checkBordaCheddar, checkBordaChocolate;
  private Button btnCalcularItem, btnAdicionarItem, btnLimparPedido, btnFecharPedido;
  private JScrollPane tablePane;
  private JTable tabelaItens;
  private DefaultTableModel modelTabelaItens;
  private JSeparator separatorCliente;

  private Font fonte;
  private Color corFundo, corFonte, branco;
  private String[] cidades;
  private ArrayList<Pizza> itens;

  public FormPedido() {
    super("Pizzeria Napoletana - Novo Pedido");

    setBounds(0, 0, 1045, 1225);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    fonte = new Font("Roboto", Font.PLAIN, 18);

    corFundo = new Color(234, 234, 234);
    corFonte = new Color(75, 75, 75);
    branco = new Color(255, 255, 255);

    cidades = new String[] { "Porto Alegre", "Canoas", "Cachoeirinha", "Gravataí", "São Leopoldo" };

    contentPane = new JPanel();
    contentPane.setLayout(null);

    setContentPane(contentPane);

    body = new JPanel();
    body.setBounds(0, 0, 1045, 1225);
    body.setBackground(corFundo);
    body.setLayout(null);

    contentPane.add(body);

    logo = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/imgLogo.png")));
    logo.setBounds(20, 5, 105, 100);

    body.add(logo);

    titulo = new Label(362, 10, "Pizzeria Napoletana");
    titulo.setSize(320, 38);
    titulo.setFontSize(36);

    body.add(titulo);

    subtitulo = new Label(452, 53, "- Novo pedido -");
    subtitulo.setSize(140, 22);
    subtitulo.setFontSize(20);

    body.add(subtitulo);

    labelNome = new Label(20, 120, "Nome do cliente:");

    body.add(labelNome);

    inputNome = new Input(20, 143, "Digite o nome do cliente");

    body.add(inputNome);

    labelTelefone = new Label(540, 120, "Telefone:");

    body.add(labelTelefone);

    inputTelefone = new Input(540, 143, "Digite o telefone do cliente");

    body.add(inputTelefone);

    labelEndereco = new Label(20, 188, "Endereço:");

    body.add(labelEndereco);

    inputEndereco = new Input(20, 211, "Digite o endereço do cliente");

    body.add(inputEndereco);

    labelCidade = new Label(540, 188, "Cidade:");

    body.add(labelCidade);

    comboCidade = new JComboBox<>(new DefaultComboBoxModel<>(cidades));
    comboCidade.setBounds(540, 211, 475, 35);
    comboCidade.setFont(fonte);
    comboCidade.setForeground(corFonte);
    comboCidade.setBackground(branco);

    body.add(comboCidade);

    separatorCliente = new JSeparator();
    separatorCliente.setBounds(20, 255, 995, 1);
    separatorCliente.setForeground(corFonte);

    body.add(separatorCliente);

    labelSabor = new Label(20, 264, "Sabor:");

    body.add(labelSabor);

    imgPepperoni = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgPepperoni.png")));
    imgPepperoni.setBounds(10, 290, 185, 185);

    body.add(imgPepperoni);

    imgBasca = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgBasca.png")));
    imgBasca.setBounds(215, 290, 185, 185);

    body.add(imgBasca);

    imgFrangoBacon = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgFrangoBacon.png")));
    imgFrangoBacon.setBounds(420, 290, 185, 185);

    body.add(imgFrangoBacon);

    imgCincoQueijos = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgCincoQueijos.png")));
    imgCincoQueijos.setBounds(625, 290, 185, 185);

    body.add(imgCincoQueijos);

    imgChocolateMorango = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgChocolateMorango.png")));
    imgChocolateMorango.setBounds(830, 290, 185, 185);

    body.add(imgChocolateMorango);
  }
}
