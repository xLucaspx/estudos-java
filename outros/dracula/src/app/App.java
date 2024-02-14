package app;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		String tableLine = String.format("|%25s|%19s|", "", "").replace(' ', '-');
		String cornerLine = String.format("*%25s*%19s*", "", "").replace(' ', '-');

		ArrayList<String> table = new ArrayList<>();

		table.add(String.format("| %23s |  (%3s, %3s, %3s)  |", "Elemento", "R", "G", "B"));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Comentários", 78, 92, 135));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Constantes caracter", 255, 139, 11));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Constantes numéricas", 255, 106, 128));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Fundo do editor", 45, 47, 62));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Palavras-chave", 53, 129, 255));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Palavras especiais", 28, 249, 83));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Tipos de dados", 46, 216, 252));
		table.add(String.format("| %23s |  (%3d, %3d, %3d)  |", "Texto em geral", 255, 32, 160));

		try (PrintStream ps = new PrintStream(new File("dracula-colours-for-visualg.txt"))) {
			ps.println("Drácula para visualG3 \n");
			ps.println("Cores em RGB para alterar em \"Manutenção\" -> \"Configurações\":\n");
			ps.println(cornerLine);

			for (int i = 0; i < (table.size() - 1); i++) {
				ps.println(table.get(i));
				ps.println(tableLine);
			}

			ps.println(table.get(table.size() - 1));
			ps.println(cornerLine);
			ps.println("\nAproveite!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
