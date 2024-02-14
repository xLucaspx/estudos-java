package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SeparaArquivos {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		// read the string filename
		String baseFilename;
		System.out.println("Type the file name...");
		baseFilename = scan.nextLine();

		var start = System.currentTimeMillis();

		FileOutputStream fileC = new FileOutputStream("c_file_00.txt");
		OutputStreamWriter oswC = new OutputStreamWriter(fileC);
		BufferedWriter writerC = new BufferedWriter(oswC);

		FileOutputStream fileCpp = new FileOutputStream("cpp_file_00.txt");
		OutputStreamWriter oswCpp = new OutputStreamWriter(fileCpp);
		BufferedWriter writerCpp = new BufferedWriter(oswCpp);

		FileOutputStream fileCs = new FileOutputStream("cs_file_00.txt");
		OutputStreamWriter oswCs = new OutputStreamWriter(fileCs);
		BufferedWriter writerCs = new BufferedWriter(oswCs);

		FileInputStream fis = new FileInputStream(baseFilename);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();

		Pattern patternC = Pattern.compile(".*\\.c$");
		Pattern patternCpp = Pattern.compile(".*\\.cpp$");
		Pattern patternCs = Pattern.compile(".*\\.cs$");

		while (line != null) {
			if (patternC.matcher(line).matches()) {
				writerC.write(line);
				writerC.newLine();
			}

			if (patternCpp.matcher(line).matches()) {
				writerCpp.write(line);
				writerCpp.newLine();
			}

			if (patternCs.matcher(line).matches()) {
				writerCs.write(line);
				writerCs.newLine();
			}

			line = br.readLine();
		}

		writerC.close();
		writerCpp.close();
		writerCs.close();
		br.close();

		var end = System.currentTimeMillis();
		System.out.println("Done in %d milliseconds".formatted(end - start));
	}
}
