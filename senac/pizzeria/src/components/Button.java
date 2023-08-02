package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Button extends JPanel {
  private int width = 245;
  private int height = 45;
  private Font font = new Font("Roboto", Font.PLAIN, 18);
  private Color foregroundColor = new Color(75, 75, 75);

  private Color backgroundColor, hoverColor;
  private String text;

  public Button(int x, int y, String text) {
    setBounds(x, y, width, height);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setLayout(null);

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

  public Color getHoverColor() {
    return hoverColor == null ? getBackground() : hoverColor;
  }

  @Override
  public void setForeground(Color foreground) {
    this.removeAll();

    this.foregroundColor = foreground;
    JLabel textContent = createLabel(this.text, foreground);
    this.add(textContent);
  }

  public void setBackground(Color background, Color hover) {
    this.backgroundColor = background;
    this.hoverColor = hover;

    setBackground(background);

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        setBackground(hover);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setBackground(background);
      }
    });
  }
}
