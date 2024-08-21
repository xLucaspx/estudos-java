import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matematica {
	public static String divide(int dividendo, int divisor, int precisao) {
		if (divisor == 0) {
			return null;
		}

		BigDecimal dividendoDecimal = BigDecimal.valueOf(dividendo);
		BigDecimal divisorDecimal = BigDecimal.valueOf(divisor);
		BigDecimal result = dividendoDecimal.divide(divisorDecimal, precisao, RoundingMode.HALF_UP);

		return result.toString().replaceAll("\\.?0*$", "");
	}
}
