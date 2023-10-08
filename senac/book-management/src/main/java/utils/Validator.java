package utils;

public class Validator {
	public static boolean isValidString(String s) {
		if (s == null) return false;

		return !(s.isEmpty() || s.isBlank());
	}
}
