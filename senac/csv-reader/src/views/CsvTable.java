package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import utils.CsvReader;

public class CsvTable extends JFrame {
  private JPanel contentPane, body;
  private JScrollPane tablePane;
  private JLabel title;
  private DefaultTableModel tableModel;
  private JTable table;

  private Color bgColor, fontColor, white;
  private Font font, titleFont;

  private List<List<String>> tableData;

  public CsvTable() {
    super("White Lotus Hotel - Reservas");

    setBounds(0, 0, 1160, 675);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setIconImage(Toolkit.getDefaultToolkit().getImage(CsvTable.class.getResource("/assets/logo.png")));

    bgColor = new Color(235, 235, 235);
    fontColor = new Color(45, 45, 45);
    white = new Color(255, 255, 255);

    font = new Font("Source Serif Pro", Font.PLAIN, 15);
    titleFont = new Font("Source Code Pro Light", Font.PLAIN, 24);

    contentPane = new JPanel();
    contentPane.setLayout(null);

    setContentPane(contentPane);

    body = new JPanel();
    body.setBounds(0, 0, 1160, 675);
    body.setBackground(bgColor);
    body.setLayout(null);

    contentPane.add(body);

    title = new JLabel("White Lotus Hotel - Reservas", SwingConstants.CENTER);
    title.setBounds(0, 15, 1160, 30);
    title.setFont(titleFont);
    title.setForeground(fontColor);

    body.add(title);

    try {
      tableData = CsvReader.parseCsvIntoList("src/assets/hotel-log.csv", ",");

      tableModel = new DefaultTableModel(tableData.remove(0).toArray(), 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };

      table = new JTable(tableModel);
      table.setBackground(white);
      table.setForeground(fontColor);
      table.setFont(font);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      TableColumn tableColumnId = table.getColumnModel().getColumn(0);
      TableColumn tableColumnHospede = table.getColumnModel().getColumn(1);
      TableColumn tableColumnIdade = table.getColumnModel().getColumn(2);
      TableColumn tableColumnNacionalidade = table.getColumnModel().getColumn(3);
      TableColumn tableColumnTelefone = table.getColumnModel().getColumn(4);
      TableColumn tableColumnCheckIn = table.getColumnModel().getColumn(5);
      TableColumn tableColumnCheckOut = table.getColumnModel().getColumn(6);
      TableColumn tableColumnPeriodo = table.getColumnModel().getColumn(7);
      TableColumn tableColumnDiaria = table.getColumnModel().getColumn(8);
      TableColumn tableColumnTotal = table.getColumnModel().getColumn(9);
      TableColumn tableColumnPagamento = table.getColumnModel().getColumn(10);

      tableColumnId.setPreferredWidth(35);
      tableColumnHospede.setPreferredWidth(210);
      tableColumnIdade.setPreferredWidth(45);
      tableColumnNacionalidade.setPreferredWidth(105);
      tableColumnTelefone.setPreferredWidth(105);
      tableColumnCheckIn.setPreferredWidth(85);
      tableColumnCheckOut.setPreferredWidth(85);
      tableColumnPeriodo.setPreferredWidth(70);
      tableColumnDiaria.setPreferredWidth(85);
      tableColumnTotal.setPreferredWidth(85);
      tableColumnPagamento.setPreferredWidth(210);

      tablePane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      tablePane.setBounds(10, 60, 1120, 555);
      tablePane.setBackground(white);

      body.add(tablePane);

      fillTable();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(body, "Ocorreu um erro ao tentar ler o arquivo CSV:\n"
          + e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }

  private void fillTable() {
    tableModel.getDataVector().clear();

    for (int i = 0; i < tableData.size(); i++) {
      List<String> row = tableData.get(i);
      tableModel.addRow(row.toArray());
    }
  }
}
