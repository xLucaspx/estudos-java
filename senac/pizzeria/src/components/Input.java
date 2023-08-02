package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Input extends JTextField {
  private int width = 475;
  private int height = 35;
  private Font font = new Font("Roboto", Font.PLAIN, 18);
  private Color foregroundColor = new Color(75, 75, 75);
  private Color placeholderColor = new Color(145, 145, 145);
  private Color backgroundColor = new Color(255, 255, 255);

  private String placeholder;

  public Input(int x, int y, String placeholder) {
    super(placeholder, 50);
    this.placeholder = placeholder;
    super.setBounds(x, y, width, height);
    super.setFont(font);
    super.setBackground(backgroundColor);
    super.setForeground(placeholderColor);
    super.setHorizontalAlignment(SwingConstants.LEFT);

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (getText().trim().equals(placeholder)) activate();
      }
    });
  }

  public void activate() {
    super.setForeground(foregroundColor);
    setText("");
  }

  public void reset() {
    super.setForeground(placeholderColor);
    setText(placeholder);
  }

  public String getPlaceholder() {
    return placeholder;
  }

  @Override
  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
    super.setSize(width, height);
  }

  @Override
  public void setFont(Font font) {
    this.font = font;
    super.setFont(font);
  }

  @Override
  public void setForeground(Color foreground) {
    this.foregroundColor = foreground;
    super.setForeground(foreground);
  }

  @Override
  public void setBackground(Color background) {
    this.backgroundColor = background;
    super.setBackground(background);
  }
}
