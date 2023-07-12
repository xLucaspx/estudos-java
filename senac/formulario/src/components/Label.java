package components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

public class Label extends JLabel {
  private int width = 400;
  private int height = 20;
  private Font font = new Font("Roboto", Font.PLAIN, 18);
  private Color foregroundColor = new Color(75, 75, 75);

  private String textContent;

  public Label(int x, int y, String text) {
    super(text);
    this.textContent = text;
    setBounds(x, y, width, height);
    setFont(font);
    super.setForeground(foregroundColor);
  }

  public String getTextContent() {
    return textContent;
  }

  @Override
  public void setForeground(Color foreground) {
    this.foregroundColor = foreground;
    super.setForeground(foreground);
  }
}
