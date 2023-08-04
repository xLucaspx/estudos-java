package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
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
import models.Cliente;
import models.Item;
import models.Pedido;
import models.Pizza;

public class FormPedido extends JFrame {
  private JPanel contentPane, body, panelPizza, panelPedido;
  private JTabbedPane tabbedPane;
  private JLabel logo, imgPepperoni, imgBasca, imgFrangoBacon, imgCincoQueijos, imgChocolateMorango;
  private Label titulo, subtitulo, labelNome, labelTelefone, labelEndereco, labelCidade, labelSabor, labelTamanho,
      labelOpcionais, labelUnidades, labelSubtotalItem, labelItens, labelSubtotalPedido;
  private Input inputNome, inputTelefone, inputEndereco, inputUnidades;
  private JComboBox<String> comboCidade;
  private ButtonGroup btnGroupSabor, btnGroupTamanho;
  private Radio radioPepperoni, radioBasca, radioFrangoBacon, radioCincoQueijos, radioChocolateMorango, radioBrotinho,
      radioMedia, radioGrande, radioFamilia;
  private Checkbox checkMassaIntegral, checkBaconExtra, checkBordaCheddar, checkBordaChocolate;
  private Button btnCalcularItem, btnAdicionarItem, btnRemoverItem, btnCancelarPedido, btnFecharPedido;
  private JScrollPane tablePane;
  private JTable tabelaItens;
  private DefaultTableModel modelTabelaItens;
  private JSeparator separatorCliente, separatorSabor, separatorTamanho, separatorOpcionais;

  private Font fonte, fonteSmall, fonteBold;
  private Color corFundo, corFonte, branco, verde, verdeEscuro, azul, azulEscuro, vermelho, vermelhoEscuro;
  private String[] cidades;
  private Pedido pedido;

  public FormPedido() {
    super("Pizzeria Napoletana - Novo Pedido");

    setBounds(0, 0, 1200, 845);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setIconImage(Toolkit.getDefaultToolkit().getImage(FormPedido.class.getResource("/img/imgLogo.png")));

    fonte = new Font("Roboto", Font.PLAIN, 16);
    fonteSmall = new Font("Roboto", Font.PLAIN, 14);
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

    pedido = new Pedido();

    contentPane = new JPanel();
    contentPane.setLayout(null);
    contentPane.setBackground(corFundo);

    setContentPane(contentPane);

    body = new JPanel();
    body.setBounds(5, 5, 1190, 845);
    body.setBackground(corFundo);
    body.setLayout(null);

    contentPane.add(body);

    logo = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/imgLogo.png")));
    logo.setBounds(5, 5, 105, 100);

    body.add(logo);

    titulo = new Label(5, 5, "Pizzeria Napoletana");
    titulo.setSize(1180, 40);
    titulo.setFontSize(36);
    titulo.setHorizontalAlignment(SwingConstants.CENTER);

    body.add(titulo);

    subtitulo = new Label(5, 50, String.format("- Pedido %d -", Pedido.getNumero()));
    subtitulo.setSize(1180, 28);
    subtitulo.setFontSize(24);
    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);

    body.add(subtitulo);

    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 120, 1170, 590);
    tabbedPane.setAlignmentX(CENTER_ALIGNMENT);
    tabbedPane.setAlignmentY(CENTER_ALIGNMENT);
    tabbedPane.setFont(fonte);

    body.add(tabbedPane);

    panelPizza = new JPanel();
    panelPizza.setBounds(0, 0, 1170, 590);
    panelPizza.setBackground(corFundo);
    panelPizza.setLayout(null);

    tabbedPane.addTab("Pizzas", new ImageIcon(FormPedido.class.getResource("/img/logo-pizza.png")), panelPizza, null);

    labelSabor = new Label(5, 5, "Sabor:");

    panelPizza.add(labelSabor);

    imgPepperoni = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgPepperoni.png")));
    imgPepperoni.setBounds(5, 35, 200, 185);
    imgPepperoni.setHorizontalAlignment(SwingConstants.CENTER);
    imgPepperoni.setToolTipText("Selecionar sabor " + Sabor.PEPPERONI);

    panelPizza.add(imgPepperoni);

    imgBasca = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgBasca.png")));
    imgBasca.setBounds(240, 35, 200, 185);
    imgBasca.setHorizontalAlignment(SwingConstants.CENTER);
    imgBasca.setToolTipText("Selecionar sabor " + Sabor.BASCA);

    panelPizza.add(imgBasca);

    imgFrangoBacon = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgFrangoBacon.png")));
    imgFrangoBacon.setBounds(475, 35, 200, 185);
    imgFrangoBacon.setHorizontalAlignment(SwingConstants.CENTER);
    imgFrangoBacon.setToolTipText("Selecionar sabor " + Sabor.FRANGO_BACON);

    panelPizza.add(imgFrangoBacon);

    imgCincoQueijos = new JLabel(new ImageIcon(FormPedido.class.getResource("/img/sabores/imgCincoQueijos.png")));
    imgCincoQueijos.setBounds(710, 35, 200, 185);
    imgCincoQueijos.setHorizontalAlignment(SwingConstants.CENTER);
    imgCincoQueijos.setToolTipText("Selecionar sabor " + Sabor.CINCO_QUEIJOS);

    panelPizza.add(imgCincoQueijos);

    imgChocolateMorango = new JLabel(
        new ImageIcon(FormPedido.class.getResource("/img/sabores/imgChocolateMorango.png")));
    imgChocolateMorango.setBounds(945, 35, 200, 185);
    imgChocolateMorango.setHorizontalAlignment(SwingConstants.CENTER);
    imgChocolateMorango.setToolTipText("Selecionar sabor " + Sabor.CHOCOLATE_MORANGO);

    panelPizza.add(imgChocolateMorango);

    btnGroupSabor = new ButtonGroup();

    radioPepperoni = new Radio(5, 230, Sabor.PEPPERONI.toString());
    radioPepperoni.setSelected(true);

    btnGroupSabor.add(radioPepperoni);
    panelPizza.add(radioPepperoni);

    radioBasca = new Radio(240, 230, Sabor.BASCA.toString());

    btnGroupSabor.add(radioBasca);
    panelPizza.add(radioBasca);

    radioFrangoBacon = new Radio(475, 230, Sabor.FRANGO_BACON.toString());

    btnGroupSabor.add(radioFrangoBacon);
    panelPizza.add(radioFrangoBacon);

    radioCincoQueijos = new Radio(710, 230, Sabor.CINCO_QUEIJOS.toString());

    btnGroupSabor.add(radioCincoQueijos);
    panelPizza.add(radioCincoQueijos);

    radioChocolateMorango = new Radio(945, 230, Sabor.CHOCOLATE_MORANGO.toString());

    btnGroupSabor.add(radioChocolateMorango);
    panelPizza.add(radioChocolateMorango);

    separatorSabor = new JSeparator();
    separatorSabor.setBounds(5, 260, 1140, 1);
    separatorSabor.setForeground(corFonte);

    panelPizza.add(separatorSabor);

    labelTamanho = new Label(5, 270, "Tamanho:");

    panelPizza.add(labelTamanho);

    btnGroupTamanho = new ButtonGroup();

    radioBrotinho = new Radio(5, 300, Tamanho.BROTINHO.toString());
    radioBrotinho.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.BROTINHO, Tamanho.BROTINHO.getValor()));
    radioBrotinho.setSelected(true);

    btnGroupTamanho.add(radioBrotinho);
    panelPizza.add(radioBrotinho);

    radioMedia = new Radio(315, 300, Tamanho.MEDIA.toString());
    radioMedia.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.MEDIA, Tamanho.MEDIA.getValor()));

    btnGroupTamanho.add(radioMedia);
    panelPizza.add(radioMedia);

    radioGrande = new Radio(625, 300, Tamanho.GRANDE.toString());
    radioGrande.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.GRANDE, Tamanho.GRANDE.getValor()));

    btnGroupTamanho.add(radioGrande);
    panelPizza.add(radioGrande);

    radioFamilia = new Radio(935, 300, Tamanho.FAMILIA.toString());
    radioFamilia.setToolTipText(String.format("Valor %s R$ %.2f", Tamanho.FAMILIA, Tamanho.FAMILIA.getValor()));

    btnGroupTamanho.add(radioFamilia);
    panelPizza.add(radioFamilia);

    separatorTamanho = new JSeparator();
    separatorTamanho.setBounds(5, 330, 1140, 1);
    separatorTamanho.setForeground(corFonte);

    panelPizza.add(separatorTamanho);

    labelOpcionais = new Label(5, 340, "Opcionais:");

    panelPizza.add(labelOpcionais);

    checkMassaIntegral = new Checkbox(5, 370, Opcional.MASSA_INTEGRAL.toString());
    checkMassaIntegral
        .setToolTipText(String.format("Valor %s R$ %.2f", Opcional.MASSA_INTEGRAL, Opcional.MASSA_INTEGRAL.getValor()));

    panelPizza.add(checkMassaIntegral);

    checkBaconExtra = new Checkbox(315, 370, Opcional.BACON_EXTRA.toString());
    checkBaconExtra
        .setToolTipText(String.format("Valor %s R$ %.2f", Opcional.BACON_EXTRA, Opcional.BACON_EXTRA.getValor()));

    panelPizza.add(checkBaconExtra);

    checkBordaCheddar = new Checkbox(625, 370, Opcional.BORDA_CHEDDAR.toString());
    checkBordaCheddar
        .setToolTipText(String.format("Valor %s R$ %.2f", Opcional.BORDA_CHEDDAR, Opcional.BORDA_CHEDDAR.getValor()));

    panelPizza.add(checkBordaCheddar);

    checkBordaChocolate = new Checkbox(935, 370, Opcional.BORDA_CHOCOLATE.toString());
    checkBordaChocolate.setToolTipText(
        String.format("Valor %s R$ %.2f", Opcional.BORDA_CHOCOLATE, Opcional.BORDA_CHOCOLATE.getValor()));

    panelPizza.add(checkBordaChocolate);

    separatorOpcionais = new JSeparator();
    separatorOpcionais.setBounds(5, 400, 1140, 1);
    separatorOpcionais.setForeground(corFonte);

    panelPizza.add(separatorOpcionais);

    labelUnidades = new Label(5, 437, "Unidades: ");
    labelUnidades.setSize(75, 18);

    panelPizza.add(labelUnidades);

    inputUnidades = new Input(100, 430, "1");
    inputUnidades.setSize(55, 35);

    panelPizza.add(inputUnidades);

    labelSubtotalItem = new Label(315, 437, "Subtotal item R$ --,--");
    labelSubtotalItem.setFont(fonteBold);

    panelPizza.add(labelSubtotalItem);

    btnCalcularItem = new Button(600, 430, "Calcular valor");
    btnCalcularItem.setToolTipText("Calcular o valor da pizza que está sendo montada");
    btnCalcularItem.setBackground(azul, azulEscuro);
    btnCalcularItem.setForeground(branco);

    panelPizza.add(btnCalcularItem);

    btnAdicionarItem = new Button(900, 430, "Adicionar item");
    btnAdicionarItem.setToolTipText("Adicionar a pizza montada ao pedido");
    btnAdicionarItem.setBackground(verde, verdeEscuro);
    btnAdicionarItem.setForeground(branco);

    panelPizza.add(btnAdicionarItem);

    panelPedido = new JPanel();
    panelPedido.setBounds(0, 0, 1170, 590);
    panelPedido.setBackground(corFundo);
    panelPedido.setLayout(null);

    tabbedPane.addTab("Pedido", new ImageIcon(FormPedido.class.getResource("/img/logo-pedido.png")), panelPedido, null);

    labelNome = new Label(40, 10, "Nome do cliente:");

    panelPedido.add(labelNome);

    inputNome = new Input(40, 40, "Digite o nome do cliente");

    panelPedido.add(inputNome);

    labelTelefone = new Label(655, 10, "Telefone:");

    panelPedido.add(labelTelefone);

    inputTelefone = new Input(655, 40, "Digite o telefone do cliente");

    panelPedido.add(inputTelefone);

    labelEndereco = new Label(40, 95, "Endereço:");

    panelPedido.add(labelEndereco);

    inputEndereco = new Input(40, 125, "Digite o endereço do cliente");

    panelPedido.add(inputEndereco);

    labelCidade = new Label(655, 95, "Cidade:");

    panelPedido.add(labelCidade);

    comboCidade = new JComboBox<>(new DefaultComboBoxModel<>(cidades));
    comboCidade.setBounds(655, 125, 475, 35);
    comboCidade.setFont(fonte);
    comboCidade.setForeground(corFonte);
    comboCidade.setBackground(branco);

    panelPedido.add(comboCidade);

    separatorCliente = new JSeparator();
    separatorCliente.setBounds(5, 180, 1150, 1);
    separatorCliente.setForeground(corFonte);

    panelPedido.add(separatorCliente);

    labelItens = new Label(40, 195, "Itens do pedido:");

    panelPedido.add(labelItens);

    String[] itensColumnsNames = { "Item", "Sabor", "Tamanho", "Opcionais", "Un.", "Valor" };
    modelTabelaItens = new DefaultTableModel(itensColumnsNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    tabelaItens = new JTable(modelTabelaItens);
    tabelaItens.setFont(fonteSmall);
    tabelaItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaItens.setBackground(branco);

    TableColumn itensColumn0 = tabelaItens.getColumnModel().getColumn(0);
    TableColumn itensColumn1 = tabelaItens.getColumnModel().getColumn(1);
    TableColumn itensColumn2 = tabelaItens.getColumnModel().getColumn(2);
    TableColumn itensColumn3 = tabelaItens.getColumnModel().getColumn(3);
    TableColumn itensColumn4 = tabelaItens.getColumnModel().getColumn(4);
    TableColumn itensColumn5 = tabelaItens.getColumnModel().getColumn(5);

    itensColumn0.setPreferredWidth(50);
    itensColumn1.setPreferredWidth(225);
    itensColumn2.setPreferredWidth(105);
    itensColumn3.setPreferredWidth(560);
    itensColumn4.setPreferredWidth(45);
    itensColumn5.setPreferredWidth(105);

    tablePane = new JScrollPane(tabelaItens, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tablePane.setBounds(40, 230, 1090, 245);
    tablePane.setBackground(branco);

    panelPedido.add(tablePane);

    btnRemoverItem = new Button(885, 490, "Remover item");
    btnRemoverItem.setToolTipText("Remove o item selecionado do pedido");
    btnRemoverItem.setBackground(vermelho, vermelhoEscuro);
    btnRemoverItem.setForeground(branco);

    panelPedido.add(btnRemoverItem);

    labelSubtotalPedido = new Label(315, 752, "Subtotal pedido R$ --,--");
    labelSubtotalPedido.setSize(280, 20);
    labelSubtotalPedido.setFont(fonteBold);

    body.add(labelSubtotalPedido);

    btnFecharPedido = new Button(600, 745, "Fechar pedido");
    btnFecharPedido.setToolTipText("Fechar o pedido e salvar em um arquivo de texto");
    btnFecharPedido.setBackground(azul, azulEscuro);
    btnFecharPedido.setForeground(branco);

    body.add(btnFecharPedido);

    btnCancelarPedido = new Button(900, 745, "Cancelar pedido");
    btnCancelarPedido.setToolTipText("Limpa todos os itens e começa um novo pedido");
    btnCancelarPedido.setBackground(vermelho, vermelhoEscuro);
    btnCancelarPedido.setForeground(branco);

    body.add(btnCancelarPedido);

    imgPepperoni.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        radioPepperoni.setSelected(true);
      }
    });

    imgBasca.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        radioBasca.setSelected(true);
      }
    });

    imgFrangoBacon.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        radioFrangoBacon.setSelected(true);
      }
    });

    imgCincoQueijos.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        radioCincoQueijos.setSelected(true);
      }
    });

    imgChocolateMorango.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        radioChocolateMorango.setSelected(true);
      }
    });

    inputNome.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputTelefone.getText().trim().isEmpty()) inputTelefone.reset();

        if (inputEndereco.getText().trim().isEmpty()) inputEndereco.reset();
      }
    });

    inputTelefone.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputNome.getText().trim().isEmpty()) inputNome.reset();

        if (inputEndereco.getText().trim().isEmpty()) inputEndereco.reset();
      }
    });

    inputEndereco.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputTelefone.getText().trim().isEmpty()) inputTelefone.reset();

        if (inputTelefone.getText().trim().isEmpty()) inputTelefone.reset();
      }
    });

    btnCalcularItem.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent evt) {
        try {
          Item item = criaItem();

          labelSubtotalItem.setText(String.format("Subtotal item R$ %.2f", item.getValor()));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(body,
              "Erro ao calcular o valor do item:\nValor inválido inserido para o campo \"Unidades\"!\nApenas números inteiros maiores que 0 são permitidos.",
              getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(body, "Erro ao calcular o valor do item:\n" + e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnAdicionarItem.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent evt) {
        try {
          Item item = criaItem();

          pedido.addItem(item);
          preencheTabelaItens();
          atualizaSubtotalPedido();

          JOptionPane.showMessageDialog(body, "Item adicionado ao pedido!", getTitle(), JOptionPane.INFORMATION_MESSAGE);

          resetaPizza();
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(body,
              "Erro ao calcular o valor do item:\nValor inválido inserido para o campo \"Unidades\"!\nApenas números inteiros maiores que 0 são permitidos.",
              getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(body, "Erro ao calcular o valor do item:\n" + e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnRemoverItem.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent evt) {
        try {
          int selectedIndex = tabelaItens.getSelectedRow();
          Item item = pedido.getItens().get(selectedIndex);
          Pizza p = item.getPizza();
          String msgItem = String.format("%s de pizza %s sabor %s?\n",
              item.getUnidades() == 1 ? "1 unidade" : item.getUnidades() + " unidades", p.getTamanho().toString().toLowerCase(), p.getSabor().toString().toLowerCase());
          int res;
          String[] options = { "Sim", "Não" };

          res = JOptionPane.showOptionDialog(body,
              "Tem certeza que deseja remover " + msgItem + "Você não pode desfazer esta ação!", getTitle(),
              JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

          if (res != 0) return;

          pedido.removeItem(selectedIndex);
          preencheTabelaItens();
          atualizaSubtotalPedido();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(body, "Erro ao tentar remover item do pedido:\n" + e.getMessage(), getTitle(),
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnCancelarPedido.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent evt) {
        try {
          int res;
          String[] options = { "Sim", "Não" };

          res = JOptionPane.showOptionDialog(body,
              "Tem certeza que deseja cancelar o pedido?\nVocê não pode desfazer esta ação!", getTitle(),
              JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

          if (res != 0) return;

          if (pedido.getItens().size() == 0 || pedido.getValor() <= 0)
            throw new IllegalArgumentException("Você não pode cancelar um pedido vazio!");

          resetaPedido();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(body, "Erro ao cancelar o pedido:\n" + e.getMessage(), getTitle(),
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnFecharPedido.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent evt) {
        try {
          int res;
          String[] options = { "Sim", "Não" };

          res = JOptionPane.showOptionDialog(body,
              "Tem certeza que deseja fechar o pedido?", getTitle(), JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

          if (res != 0) return;

          fechaPedido();
          resetaPedido();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(body, "Erro ao fechar o pedido:\n" + e.getMessage(), getTitle(),
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  private Item criaItem() {
    Sabor sabor = Sabor.fromString(btnGroupSabor.getSelection().getActionCommand());
    Tamanho tamanho = Tamanho.fromString(btnGroupTamanho.getSelection().getActionCommand());
    int unidades = Integer.parseInt(inputUnidades.getText());

    Pizza p = new Pizza(sabor, tamanho);

    if (checkMassaIntegral.isSelected())
      p.addOpcional(Opcional.fromString(checkMassaIntegral.getName()));
    if (checkBaconExtra.isSelected())
      p.addOpcional(Opcional.fromString(checkBaconExtra.getName()));
    if (checkBordaCheddar.isSelected())
      p.addOpcional(Opcional.fromString(checkBordaCheddar.getName()));
    if (checkBordaChocolate.isSelected())
      p.addOpcional(Opcional.fromString(checkBordaChocolate.getName()));

    return new Item(p, unidades);
  }

  private Cliente criaCliente() {
    String nome = inputNome.getText().trim().equals(inputNome.getPlaceholder()) ? "" : inputNome.getText();
    String telefone = inputTelefone.getText().trim().equals(inputTelefone.getPlaceholder()) ? ""
        : inputTelefone.getText();
    String endereco = inputEndereco.getText().trim().equals(inputEndereco.getPlaceholder()) ? ""
        : inputEndereco.getText();
    String cidade = comboCidade.getSelectedItem().toString();

    return new Cliente(nome, telefone, endereco, cidade);
  }

  private void preencheTabelaItens() {
    modelTabelaItens.getDataVector().clear();

    for (int i = 0; i < pedido.getItens().size(); i++) {
      Item item = pedido.getItens().get(i);
      Pizza p = item.getPizza();
      Integer unidades = item.getUnidades();

      modelTabelaItens.addRow(new String[] { String.valueOf(i + 1), p.getSabor().toString(), p.getTamanho().toString(),
          p.getOpcionais().size() > 0 ? p.getOpcionais().toString().replace("[", "").replace("]", "") : "Sem opcionais",
          String.valueOf(unidades), String.format("R$ %.2f", item.getValor()) });
    }
  }

  private void resetaPizza() {
    radioPepperoni.setSelected(true);
    radioBrotinho.setSelected(true);
    checkMassaIntegral.setSelected(false);
    checkBaconExtra.setSelected(false);
    checkBordaCheddar.setSelected(false);
    checkBordaChocolate.setSelected(false);
    inputUnidades.reset();
    labelSubtotalItem.setText("Subtotal item R$ --,--");
  }

  private void resetaPedido() {
    resetaPizza();
    pedido = new Pedido();
    subtitulo.setText(String.format("- Pedido %d -", Pedido.getNumero()));
    labelSubtotalPedido.setText("Subtotal pedido R$ --,--");
    inputNome.reset();
    inputTelefone.reset();
    inputEndereco.reset();
    comboCidade.setSelectedIndex(0);
    modelTabelaItens.getDataVector().clear();
    tabbedPane.setSelectedIndex(0);
  }

  private void atualizaSubtotalPedido() {
    labelSubtotalPedido.setText(String.format("Subtotal pedido R$ %.2f", pedido.getValor()));
  }

  private void fechaPedido() {
    if (pedido.getItens().size() == 0 || pedido.getValor() <= 0)
      throw new IllegalArgumentException("Você não pode fechar um pedido vazio!");

    pedido.setCliente(criaCliente());
    String idPedido = String.format("pedido-%d", Pedido.getNumero());

    try (PrintStream ps = new PrintStream(new File(idPedido + ".txt"), StandardCharsets.UTF_8.name())) {
      ps.println(pedido);
      ps.println("\n\nA Pizzeria Napoletana agradece a preferência!");
    } catch (IOException e) {
      throw new RuntimeException(
          "Ocorreu um erro ao tentar imprimir o pedido:\n" + e.getMessage() + "\n" + e.getStackTrace());
    }
  }
}
