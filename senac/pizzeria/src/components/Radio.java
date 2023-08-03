package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Radio extends JRadioButton {
  private int width = 200;
  private int height = 20;
  private int fontSize = 15; 
  private Font font = new Font("Roboto Black", Font.BOLD, fontSize);
  private Color foregroundColor = new Color(75, 75, 75);
  private Color backgroundColor = new Color(234, 234, 234);

  private String text;

  public Radio(int x, int y, String text) {
    setBounds(x, y, width, height);
    setLayout(null);
    setActionCommand(text);
    setFont(font);
    setForeground(foregroundColor);
    setBackground(backgroundColor);

    this.text = text;
    JLabel textContent = createLabel(text, foregroundColor);

    this.add(textContent);
  }

  @Override
  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
    super.setSize(width, height);
  }

  private JLabel createLabel(String text, Color foregroundColor) {
    JLabel l = new JLabel(text, SwingConstants.CENTER);
    l.setBounds(0, 0, width, height);
    l.setFont(font);
    l.setForeground(foregroundColor);

    return l;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    this.font = new Font("Roboto", Font.PLAIN, fontSize);
    this.removeAll();
    this.add(createLabel(this.text, foregroundColor));
  }

  @Override
  public void setForeground(Color foreground) {
    this.removeAll();

    this.foregroundColor = foreground;
    JLabel textContent = createLabel(this.text, foreground);
    this.add(textContent);
  }
}
