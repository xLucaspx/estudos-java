package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Checkbox extends JCheckBox {
  private int width = 185;
  private int height = 20;
  private Font font = new Font("Roboto", Font.PLAIN, 18);
  private Color foregroundColor = new Color(75, 75, 75);

  private Color backgroundColor;
  private String text;

  public Checkbox(int x, int y, String text) {
    setBounds(x, y, width, height);
    setLayout(null);
    setName(text);

    this.text = text;
    JLabel textContent = createLabel(text, foregroundColor);

    this.add(textContent);
  }

  private JLabel createLabel(String text, Color foregroundColor) {
    JLabel l = new JLabel(text, SwingConstants.CENTER);
    l.setBounds(0, 0, width, height);
    l.setFont(font);
    l.setForeground(foregroundColor);

    return l;
  }

  public Color getBackgroundColor() {
    return backgroundColor == null ? super.getBackground() : backgroundColor;
  }

  @Override
  public void setForeground(Color foreground) {
    this.removeAll();

    this.foregroundColor = foreground;
    JLabel textContent = createLabel(this.text, foreground);
    this.add(textContent);
  }

  @Override
  public void setBackground(Color background) {
    this.backgroundColor = background;
    super.setBackground(background);
  }
}
