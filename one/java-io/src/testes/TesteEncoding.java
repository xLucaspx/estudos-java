package testes;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ç";
		System.out.println(s.codePointAt(0));

		byte[] bytes = s.getBytes();
		System.out.print(bytes.length + " - ");

		Charset charset = Charset.defaultCharset();
		System.out.print(charset.displayName() + " - ");

		// String newS = new String(bytes);
		// devemos sempre usar a codificação correta para evitar problemas
		String newS = new String(bytes, charset);
		System.out.println(newS);

		bytes = s.getBytes("windows-1252");
		System.out.print(bytes.length + " - windows-1252 - ");

		// newS = new String(bytes);
		newS = new String(bytes, "windows-1252");
		System.out.println(newS);

		bytes = s.getBytes("UTF-16");
		System.out.print(bytes.length + " - UTF-16 - ");

		// newS = new String(bytes);
		newS = new String(bytes, "UTF-16");
		System.out.println(newS);

		bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.print(bytes.length + " - US-ASCII - ");

		// newS = new String(bytes);
		newS = new String(bytes, "US-ASCII");
		System.out.println(newS);
	}
}
