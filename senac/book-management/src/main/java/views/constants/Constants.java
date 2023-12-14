package views.constants;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

public class Constants {
	// fonts
	public static final Font TITLE_FONT = new Font("Yu Gothic UI Semibold", Font.PLAIN, 24);
	public static final Font DEFAULT_FONT = new Font("Yu Gothic UI", Font.PLAIN, 14);
	public static final Font SERIF_FONT = new Font("Lucida Bright", Font.PLAIN, 14);
	public static final Font MONOSPACE_FONT = new Font("Lucida Console", Font.PLAIN, 14);
	public static final Font SMALL_FONT = new Font("Yu Gothic UI", Font.PLAIN, 12);
	public static final Font MEDIUM_FONT = new Font("Yu Gothic UI", Font.PLAIN, 16);
	public static final Font LARGE_FONT = new Font("Yu Gothic UI Medium", Font.PLAIN, 18);

	// colors
	public static final Color FONT_COLOR = new Color(42, 42, 42);
	public static final Color BACKGROUND_COLOR = new Color(234, 234, 234);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color BLUE = new Color(0, 129, 184);
	public static final Color LIGHT_BLUE = new Color(134, 187, 216);
	public static final Color DARK_BLUE = new Color(22, 70, 163);
	public static final Color RED = new Color(222, 16, 16);
	public static final Color DARK_RED = new Color(146, 5, 5);
	public static final Color GREEN = new Color(0, 164, 0);
	public static final Color DARK_GREEN = new Color(30, 113, 37);
	public static final Color BURNT_YELLOW = new Color(221, 127, 3);

	// formats
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
