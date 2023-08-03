package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import components.Button;
import components.Checkbox;
import components.Input;
import components.Label;
import components.Radio;
import enums.Opcional;
import enums.Sabor;
import enums.Tamanho;
import models.Pizza;

public class FormPedido extends JFrame {
  private JPanel contentPane, body;
  private JLabel logo, imgPepperoni, imgBasca, imgFrangoBacon, imgCincoQueijos, imgChocolateMorango;
  private Label titulo, subtitulo, labelNome, labelTelefone, labelEndereco, labelCidade, labelSabor, labelTamanho,
      labelOpcionais, labelUnidades, labelSubtotalItem, labelItens, labelSubtotalPedido;
  private Input inputNome, inputTelefone, inputEndereco, inputUnidades;
  private JComboBox<String> comboCidade;
  private ButtonGroup btnGroupSabor, btnGroupTamanho;
  private Radio radioPepperoni, radioBasca, radioFrangoBacon, radioCincoQueijos, radioChocolateMorango, radioBrotinho,
      radioMedia, radioGrande, radioFamilia;
  private Checkbox checkMassaIntegral, checkBaconExtra, checkBordaCheddar, checkBordaChocolate;
  private Button btnCalcularItem, btnAdicionarItem, btnLimparPedido, btnFecharPedido;
  private JScrollPane tablePane;
  private JTable tabelaItens;
  private DefaultTableModel modelTabelaItens;
  private JSeparator separatorCliente, separatorSabor, separatorTamanho, separatorOpcionais;

  private Font fonte, fonteBold;
  private Color corFundo, corFonte, branco, verde, verdeEscuro, azul, azulEscuro, vermelho, vermelhoEscuro;
  private String[] cidades;
  private ArrayList<Pizza> itens;

  public FormPedido() {
    super("Pizzeria Napoletana - Novo Pedido");

    setBounds(0, 0, 1060, 1080);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setIconImage(Toolkit.getDefaultToolkit().getImage(FormPedido.class.getResource("/img/imgLogo.png")));

    fonte = new Font("Roboto", Font.PLAIN, 16);
    fonteBold = new Font("Roboto Black", Font.BOLD, 16);

    corFundo = new Color(234, 234, 234);
    corFonte = new Color(75, 75, 75);
    branco = new Color(255, 255, 255);
    azul = new Color(10, 102, 217);
    azulEscuro = new Color(12, 79, 156);
    verde = new Color(39, 179, 118);
    verdeEscuro = new Color(0, 111, 60);
    vermelho = new Color(230, 70, 70);
    vermelhoEscuro = new Color(191, 33, 47);

    cidades = new String[] { "Porto Alegre", "Canoas", "Cachoeirinha", "Gravataí", "São Leopoldo" };

    contentPane = new JPanel();
    contentPane.setLayout(null);

    setContentPane(contentPane);

    body = new JPanel();
    body.setBounds(0, 0, 1060, 1080);
    body.setBackground(corFundo);
    body.setLayout(null);

    contentPane.add(body);

    logo = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/imgLogo.png")));
    logo.setBounds(20, 5, 105, 100);

    body.add(logo);

    titulo = new Label(370, 10, "Pizzeria Napoletana");
    titulo.setSize(320, 38);
    titulo.setFontSize(36);

    body.add(titulo);

    subtitulo = new Label(460, 53, "- Novo pedido -");
    subtitulo.setSize(140, 22);
    subtitulo.setFontSize(20);

    body.add(subtitulo);

    labelNome = new Label(15, 120, "Nome do cliente:");

    body.add(labelNome);

    inputNome = new Input(15, 143, "Digite o nome do cliente");

    body.add(inputNome);

    labelTelefone = new Label(565, 120, "Telefone:");

    body.add(labelTelefone);

    inputTelefone = new Input(565, 143, "Digite o telefone do cliente");

    body.add(inputTelefone);

    labelEndereco = new Label(15, 188, "Endereço:");

    body.add(labelEndereco);

    inputEndereco = new Input(15, 211, "Digite o endereço do cliente");

    body.add(inputEndereco);

    labelCidade = new Label(565, 188, "Cidade:");

    body.add(labelCidade);

    comboCidade = new JComboBox<>(new DefaultComboBoxModel<>(cidades));
    comboCidade.setBounds(565, 211, 475, 35);
    comboCidade.setFont(fonte);
    comboCidade.setForeground(corFonte);
    comboCidade.setBackground(branco);

    body.add(comboCidade);

    separatorCliente = new JSeparator();
    separatorCliente.setBounds(15, 255, 1025, 1);
    separatorCliente.setForeground(corFonte);

    body.add(separatorCliente);

    labelSabor = new Label(20, 264, "Sabor:");

    body.add(labelSabor);

    imgPepperoni = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgPepperoni.png")));
    imgPepperoni.setBounds(15, 290, 185, 185);

    body.add(imgPepperoni);

    imgBasca = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgBasca.png")));
    imgBasca.setBounds(220, 290, 185, 185);

    body.add(imgBasca);

    imgFrangoBacon = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgFrangoBacon.png")));
    imgFrangoBacon.setBounds(425, 290, 185, 185);

    body.add(imgFrangoBacon);

    imgCincoQueijos = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgCincoQueijos.png")));
    imgCincoQueijos.setBounds(630, 290, 185, 185);

    body.add(imgCincoQueijos);

    imgChocolateMorango = new JLabel(
        new ImageIcon(FormPedido.class.getResource("/img/sabores/imgChocolateMorango.png")));
    imgChocolateMorango.setBounds(835, 290, 185, 185);

    body.add(imgChocolateMorango);

    btnGroupSabor = new ButtonGroup();

    radioPepperoni = new Radio(15, 485, Sabor.PEPPERONI.toString());
    radioPepperoni.setSelected(true);

    btnGroupSabor.add(radioPepperoni);
    body.add(radioPepperoni);

    radioBasca = new Radio(220, 485, Sabor.BASCA.toString());

    btnGroupSabor.add(radioBasca);
    body.add(radioBasca);

    radioFrangoBacon = new Radio(425, 485, Sabor.FRANGO_BACON.toString());

    btnGroupSabor.add(radioFrangoBacon);
    body.add(radioFrangoBacon);

    radioCincoQueijos = new Radio(630, 485, Sabor.CINCO_QUEIJOS.toString());

    btnGroupSabor.add(radioCincoQueijos);
    body.add(radioCincoQueijos);

    radioChocolateMorango = new Radio(830, 485, Sabor.CHOCOLATE_MORANGO.toString());

    btnGroupSabor.add(radioChocolateMorango);
    body.add(radioChocolateMorango);

    separatorSabor = new JSeparator();
    separatorSabor.setBounds(15, 512, 1025, 1);
    separatorSabor.setForeground(corFonte);

    body.add(separatorSabor);

    labelTamanho = new Label(20, 520, "Tamanho:");

    body.add(labelTamanho);

    btnGroupTamanho = new ButtonGroup();

    radioBrotinho = new Radio(15, 549, Tamanho.BROTINHO.toString());
    radioBrotinho.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.BROTINHO, Tamanho.BROTINHO.getValor()));
    radioBrotinho.setSelected(true);

    btnGroupTamanho.add(radioBrotinho);
    body.add(radioBrotinho);

    radioMedia = new Radio(270, 549, Tamanho.MEDIA.toString());
    radioMedia.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.MEDIA, Tamanho.MEDIA.getValor()));

    btnGroupTamanho.add(radioMedia);
    body.add(radioMedia);

    radioGrande = new Radio(525, 549, Tamanho.GRANDE.toString());
    radioGrande.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.GRANDE, Tamanho.GRANDE.getValor()));

    btnGroupTamanho.add(radioGrande);
    body.add(radioGrande);

    radioFamilia = new Radio(780, 549, Tamanho.FAMILIA.toString());
    radioFamilia.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.FAMILIA, Tamanho.FAMILIA.getValor()));

    btnGroupTamanho.add(radioFamilia);
    body.add(radioFamilia);

    separatorTamanho = new JSeparator();
    separatorTamanho.setBounds(15, 572, 1025, 1);
    separatorTamanho.setForeground(corFonte);

    body.add(separatorTamanho);

    labelOpcionais = new Label(15, 580, "Opcionais:");

    body.add(labelOpcionais);

    checkMassaIntegral = new Checkbox(15, 605, Opcional.MASSA_INTEGRAL.toString());
    checkMassaIntegral.setToolTipText(String.format("Valor %s R$ %.2f", Opcional.MASSA_INTEGRAL, Opcional.MASSA_INTEGRAL.getValor()));

    body.add(checkMassaIntegral);

    checkBaconExtra = new Checkbox(270, 605, Opcional.BACON_EXTRA.toString());
    checkBaconExtra.setToolTipText(String.format("Valor %s R$ %.2f", Opcional.BACON_EXTRA, Opcional.BACON_EXTRA.getValor()));

    body.add(checkBaconExtra);

    checkBordaCheddar = new Checkbox(525, 605, Opcional.BORDA_CHEDDAR.toString());
    checkBordaCheddar.setToolTipText(String.format("Valor %s R$ %.2f", Opcional.BORDA_CHEDDAR, Opcional.BORDA_CHEDDAR.getValor()));

    body.add(checkBordaCheddar);

    checkBordaChocolate = new Checkbox(780, 605, Opcional.BORDA_CHOCOLATE.toString());
    checkBordaChocolate.setToolTipText(String.format("Valor %s R$ %.2f", Opcional.BORDA_CHOCOLATE, Opcional.BORDA_CHOCOLATE.getValor()));

    body.add(checkBordaChocolate);

    separatorOpcionais = new JSeparator();
    separatorOpcionais.setBounds(15, 639, 1025, 1);
    separatorOpcionais.setForeground(corFonte);

    body.add(separatorOpcionais);

    labelUnidades = new Label(15, 655, "Unidades: ");
    labelUnidades.setSize(75, 18);

    body.add(labelUnidades);

    inputUnidades = new Input(100, 647, "1");
    inputUnidades.setSize(55, 35);

    body.add(inputUnidades);

    labelSubtotalItem = new Label(195, 655, "Subtotal item R$ --,--");
    labelSubtotalItem.setFont(fonteBold);

    body.add(labelSubtotalItem);

    btnCalcularItem = new Button(530, 647, "Calcular valor");
    btnCalcularItem.setToolTipText("Calcular o valor da pizza que está sendo montada");
    btnCalcularItem.setBackground(azul, azulEscuro);
    btnCalcularItem.setForeground(branco);

    body.add(btnCalcularItem);

    btnAdicionarItem = new Button(795, 647, "Adicionar item");
    btnAdicionarItem.setToolTipText("Adicionar a pizza montada ao pedido");
    btnAdicionarItem.setBackground(verde, verdeEscuro);
    btnAdicionarItem.setForeground(branco);

    body.add(btnAdicionarItem);

    labelItens = new Label(15, 697, "Itens do pedido:");

    body.add(labelItens);

    labelSubtotalPedido = new Label(837, 697, "Subtotal pedido R$ --,--");
    labelSubtotalPedido.setFont(fonteBold);

    body.add(labelSubtotalPedido);

    String[] itensColumnsNames = { "Indíce", "Sabor", "Tamanho", "Opcionais", "Un.", "Valor" };
    modelTabelaItens = new DefaultTableModel(itensColumnsNames, 0);

    tabelaItens = new JTable(modelTabelaItens);
    tabelaItens.setFont(fonte);
    tabelaItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    TableColumn itensColumn0 = tabelaItens.getColumnModel().getColumn(0);
    TableColumn itensColumn1 = tabelaItens.getColumnModel().getColumn(1);
    TableColumn itensColumn2 = tabelaItens.getColumnModel().getColumn(2);
    TableColumn itensColumn3 = tabelaItens.getColumnModel().getColumn(3);
    TableColumn itensColumn4 = tabelaItens.getColumnModel().getColumn(4);
    TableColumn itensColumn5 = tabelaItens.getColumnModel().getColumn(5);

    itensColumn0.setPreferredWidth(80);
    itensColumn1.setPreferredWidth(225);
    itensColumn2.setPreferredWidth(160);
    itensColumn3.setPreferredWidth(310);
    itensColumn4.setPreferredWidth(80);
    itensColumn5.setPreferredWidth(175);

    tablePane = new JScrollPane(tabelaItens, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tablePane.setBounds(15, 725, 1025, 265);

    body.add(tablePane);

    btnFecharPedido = new Button(530, 1000, "Fechar pedido");
    btnFecharPedido.setToolTipText("Fechar o pedido e salvar em um arquivo de texto");
    btnFecharPedido.setBackground(azul, azulEscuro);
    btnFecharPedido.setForeground(branco);

    body.add(btnFecharPedido);

    btnLimparPedido = new Button(795, 1000, "Cancelar pedido");
    btnLimparPedido.setToolTipText("Limpa todos os itens e começa um novo pedido");
    btnLimparPedido.setBackground(vermelho, vermelhoEscuro);
    btnLimparPedido.setForeground(branco);

    body.add(btnLimparPedido);
  }
}
