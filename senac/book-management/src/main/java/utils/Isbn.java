package utils;

public class Isbn {

	public static boolean isValidIsbn(String isbn) {
		return isbn.length() == 10 ? isValidIsbn10(isbn) : isValidIsbn13(isbn);
	}

	public static boolean isValidIsbn10(String isbn) {
		// length must be 10
		if (isbn == null || isbn.length() != 10) return false;

		// computing weighted sum of first 9 digits
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			// converting char to it's integer value
			int digit = isbn.charAt(i) - '0';

			if (digit < 0 || digit > 9) return false;

			sum += (digit * (10 - i));
		}

		// checking last digit
		char last = isbn.charAt(9);
		if (last != 'X' && (last < '0' || last > '9')) return false;

		// if last digit is 'X', add 10 to sum, else add its value
		sum += (last == 'X' ? 10 : (last - '0'));

		// return true if weighted sum of digits is divisible by 11
		return (sum % 11 == 0);
	}

	public static boolean isValidIsbn13(String isbn) {
		// length must be 13
		if (isbn == null || isbn.length() != 13) return false;

		// computing weighted sum of first 12 digits
		int sum = 0;

		for (int i = 0; i < 12; i++) {
			int digit = isbn.charAt(i) - '0';

			// ISBN-13 specific rule: if the digit index is an even number, it's added directly to the sum;
			// if it's an odd number, it's multiplied by 3 before being added to the sum.
			sum += ((i % 2 == 0) ? digit : (digit * 3));
		}

		// storing last digit
		int lastDigit = isbn.charAt(12) - '0';

		// calculating checksum: subtracting 10 from weighted sum mod 10; if the result is 10, it's set to 0
		int checksum = 10 - (sum % 10);

		if (checksum == 10) checksum = 0;

		// return true if the checksum is equal to the last digit of the ISBN
		return checksum == lastDigit;
	}

	public static String convertToIsbn13(String isbn10) {
		if (!isValidIsbn10(isbn10)) throw new IllegalArgumentException("O ISBN-10 inserido não é válido!");

		// add the '978' prefix to the first 9 digits of ISBN-10
		String baseIsbn = "978" + isbn10.substring(0, 9);

		// calculating ISBN-13 checksum
		int sum = 0;

		for (int i = 0; i < baseIsbn.length(); i++) {
			int digit = baseIsbn.charAt(i) - '0';
			sum += (i % 2 == 0) ? digit : digit * 3;
		}

		int checksum = 10 - (sum % 10);

		if (checksum == 10) checksum = 0;

		// join baseIsbn and checksum
		String isbn13 = baseIsbn + checksum;

		return isbn13;
	}
}
