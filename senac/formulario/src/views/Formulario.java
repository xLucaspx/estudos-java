package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import components.Button;
import components.Checkbox;
import components.Input;
import components.Label;
import models.Usuario;

public class Formulario extends JFrame {
  private JPanel contentPane, body;
  private Label labelNome, labelCidade, labelEmail, labelSenha, labelIdioma1, labelIdioma2, labelSkill;
  private Input inputNome, inputCidade, inputEmail;
  private JPasswordField inputSenha;
  private Checkbox boxBack, boxFront, boxBanco;
  private JComboBox<String> comboIdioma1, comboIdioma2;
  private Button btnCadastrar, btnLimpar;

  private Color corFundo, corFonte, branco, azul, azulForte, vermelho, vermelhoForte, cinza;
  private Font fonte;
  private String[] idiomas;

  public Formulario() {
    super("Formulário | Graphic User Interface");

    setBounds(0, 0, 960, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    corFundo = new Color(233, 233, 233);
    corFonte = new Color(75, 75, 75);
    branco = new Color(255, 255, 255);
    azul = new Color(12, 132, 240);
    azulForte = new Color(10, 90, 200);
    vermelho = new Color(230, 70, 70);
    vermelhoForte = new Color(240, 35, 35);
    cinza = new Color(145, 145, 145);

    fonte = new Font("Roboto", Font.PLAIN, 18);

    idiomas = new String[] { "Português", "Inglês", "Espanhol", "Francês", "Alemão" };

    contentPane = new JPanel();
    contentPane.setLayout(null);

    setContentPane(contentPane);

    body = new JPanel();
    body.setBounds(0, 0, 950, 600);
    body.setBackground(corFundo);
    body.setLayout(null);

    contentPane.add(body);

    labelNome = new Label(45, 20, "Nome:");

    body.add(labelNome);

    inputNome = new Input(20, 50, "Digite seu nome");

    body.add(inputNome);

    labelCidade = new Label(510, 20, "Cidade - UF:");

    body.add(labelCidade);

    inputCidade = new Input(485, 50, "Digite sua cidade - UF");

    body.add(inputCidade);

    labelEmail = new Label(45, 110, "E-mail:");

    body.add(labelEmail);

    inputEmail = new Input(20, 135, "Digite seu Email");

    body.add(inputEmail);

    labelSenha = new Label(510, 110, "Crie uma senha:");

    body.add(labelSenha);

    inputSenha = new JPasswordField("**********", 50); // 10 *
    inputSenha.setBounds(485, 135, 445, 45);
    inputSenha.setFont(fonte);
    inputSenha.setForeground(cinza);
    inputSenha.setHorizontalAlignment(SwingConstants.LEFT);
    inputSenha.setToolTipText("No mínimo 8 caracteres, uma letra maiúscula, uma minúscula, um número e um caractere especial.");

    body.add(inputSenha);

    labelSkill = new Label(45, 220, "Skills:");

    body.add(labelSkill);

    boxBack = new Checkbox(20, 255, "Back-end");
    boxBack.setBackground(corFundo);

    body.add(boxBack);

    boxFront = new Checkbox(325, 255, "Front-end");
    boxFront.setBackground(corFundo);

    body.add(boxFront);

    boxBanco = new Checkbox(630, 255, "Banco de dados");
    boxBanco.setBackground(corFundo);

    body.add(boxBanco);

    labelIdioma1 = new Label(45, 315, "Idioma preferencial:");

    body.add(labelIdioma1);

    comboIdioma1 = new JComboBox<>();
    comboIdioma1.setModel(new DefaultComboBoxModel<>(idiomas));
    comboIdioma1.setBounds(20, 345, 445, 45);
    comboIdioma1.setFont(fonte);
    comboIdioma1.setForeground(corFonte);
    comboIdioma1.setBackground(branco);

    body.add(comboIdioma1);

    labelIdioma2 = new Label(510, 315, "Idioma secundário:");

    body.add(labelIdioma2);

    comboIdioma2 = new JComboBox<>();
    comboIdioma2.setModel(new DefaultComboBoxModel<>(idiomas));
    comboIdioma2.setBounds(485, 345, 445, 45);
    comboIdioma2.setFont(fonte);
    comboIdioma2.setForeground(corFonte);
    comboIdioma2.setBackground(branco);
    comboIdioma2.setToolTipText("Se o idioma secundário for igual ao preferêncial constará como \"Não possui\" no banco de dados.");

    body.add(comboIdioma2);

    btnCadastrar = new Button(205, 440, "Fazer cadastro");
    btnCadastrar.setBackground(azul, azulForte);
    btnCadastrar.setForeground(branco);

    body.add(btnCadastrar);

    btnLimpar = new Button(500, 440, "Limpar campos");
    btnLimpar.setBackground(vermelho, vermelhoForte);
    btnLimpar.setForeground(branco);

    body.add(btnLimpar);

    inputNome.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputCidade.getText().trim().isEmpty())
          inputCidade.reset();

        if (inputEmail.getText().trim().isEmpty())
          inputEmail.reset();

        if (String.valueOf(inputSenha.getPassword()).isEmpty()) {
          inputSenha.setForeground(cinza);
          inputSenha.setText("**********");
        }
      }
    });

    inputCidade.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputNome.getText().trim().isEmpty())
          inputNome.reset();

        if (inputEmail.getText().trim().isEmpty())
          inputEmail.reset();

        if (String.valueOf(inputSenha.getPassword()).isEmpty()) {
          inputSenha.setForeground(cinza);
          inputSenha.setText("**********");
        }
      }
    });

    inputEmail.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (inputNome.getText().trim().isEmpty())
          inputNome.reset();

        if (inputCidade.getText().trim().isEmpty())
          inputCidade.reset();

        if (String.valueOf(inputSenha.getPassword()).isEmpty()) {
          inputSenha.setForeground(cinza);
          inputSenha.setText("**********");
        }
      }
    });

    inputSenha.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (String.valueOf(inputSenha.getPassword()).equals("**********")) {
          inputSenha.setForeground(corFonte);
          inputSenha.setText("");
        }

        if (inputNome.getText().trim().isEmpty())
          inputNome.reset();

        if (inputCidade.getText().trim().isEmpty())
          inputCidade.reset();

        if (inputEmail.getText().trim().isEmpty())
          inputEmail.reset();
      }
    });

    btnCadastrar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          String nome = inputNome.getText().trim();
          String cidade = inputCidade.getText().trim();
          String email = inputEmail.getText().trim();
          String senha = String.valueOf(inputSenha.getPassword());
          ArrayList<String> skills = new ArrayList<>();

          if (boxBack.isSelected())
            skills.add(boxBack.getName());

          if (boxFront.isSelected())
            skills.add(boxFront.getName());

          if (boxBanco.isSelected())
            skills.add(boxBanco.getName());

          if (nome.equals(inputNome.getPlaceholder())
              || cidade.equals(inputCidade.getPlaceholder())
              || email.equals(inputEmail.getPlaceholder())
              || senha.equals("**********"))
            throw new IllegalArgumentException("Todos os campos de texto devem ser preenchidos!");

          cadastrar(nome, cidade, email, senha, skills, String.valueOf(comboIdioma1.getSelectedItem()),
              String.valueOf(comboIdioma2.getSelectedItem()));
          limparCampos();
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(body, String.format("Erro ao cadastrar usuário:\n%s", ex.getMessage()),
              "Formulário - Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnLimpar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int res;
        String[] options = { "Sim", "Não" };

        res = JOptionPane.showOptionDialog(body,
            "Tem certeza que deseja limpar todos os campos do formulário?\nVocê não pode desfazer esta ação!",
            "Formulário - Limpar campos", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
            options[0]);

        if (res != 0)
          return;

        limparCampos();
      }
    });
  }

  private void cadastrar(String nome, String cidade, String email, String senha, ArrayList<String> skills,
      String idiomaPrincicpal, String idiomaSecundario) {
    Usuario u = new Usuario(nome, cidade, email, senha, idiomaPrincicpal);
    u.setIdiomaSecundario(idiomaSecundario);

    for (String s : skills)
      u.addSkill(s);
    System.out.println(u);
  }

  private void limparCampos() {
    inputNome.reset();
    inputCidade.reset();
    inputEmail.reset();

    inputSenha.setForeground(cinza);
    inputSenha.setText("**********");

    boxBack.setSelected(false);
    boxFront.setSelected(false);
    boxBanco.setSelected(false);

    comboIdioma1.setSelectedIndex(0);
    comboIdioma2.setSelectedIndex(0);
  }
}
