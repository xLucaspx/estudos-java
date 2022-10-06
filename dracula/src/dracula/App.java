package dracula;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> comments = new ArrayList<>();
		comments.add(78);
		comments.add(92);
		comments.add(135);

		ArrayList<Integer> strings = new ArrayList<>();
		strings.add(255);
		strings.add(139);
		strings.add(11);

		ArrayList<Integer> numbersAndText = new ArrayList<>();
		numbersAndText.add(255);
		numbersAndText.add(32);
		numbersAndText.add(160);

		ArrayList<Integer> background = new ArrayList<>();
		background.add(45);
		background.add(47);
		background.add(62);

		ArrayList<Integer> keyWords = new ArrayList<>();
		keyWords.add(142);
		keyWords.add(73);
		keyWords.add(245);

		ArrayList<Integer> specialWords = new ArrayList<>();
		specialWords.add(28);
		specialWords.add(249);
		specialWords.add(83);

		ArrayList<Integer> dataTypes = new ArrayList<>();
		dataTypes.add(46);
		dataTypes.add(216);
		dataTypes.add(252);

		String tableLine = String.format("|%22s|%22s|", "", "").replace(' ', '-');
		String cornerLine = String.format("*%22s*%22s*", "", "").replace(' ', '-');

		ArrayList<String> texto = new ArrayList<>();
		
		String text0 = "Drácula para visualG3 \n";
		String text1 = "Cores em RGB para alterar em \"Manutenção\" -> \"Configurações\":\n";
		String text2 = cornerLine;
		String text3 = String.format("| %20s | %20s |", "Elemento", "[R, G, B]");
		String text4 = tableLine;
		String text5 = String.format("| %20s | %20s |", "Comentários", comments);
		String text6 = tableLine;
		String text7 = String.format("| %20s | %20s |", "Constantes caracter", strings);
		String text8 = tableLine;
		String text9 = String.format("| %20s | %20s |", "Constantes numéricas", numbersAndText);
		String text10 = tableLine;
		String text11 = String.format("| %20s | %20s |", "Fundo do editor", background);
		String text12 = tableLine;
		String text13 = String.format("| %20s | %20s |", "Palavras-chave", keyWords);
		String text14 = tableLine;
		String text15 = String.format("| %20s | %20s |", "Palavras especiais", specialWords);
		String text16 = tableLine;
		String text17 = String.format("| %20s | %20s |", "Tipos de dados", dataTypes);
		String text18 = tableLine;
		String text19 = String.format("| %20s | %20s |", "Texto em geral", numbersAndText);
		String text20 = cornerLine;
		String text21 = "\nAproveite!";
		
		texto.add(text0);
		texto.add(text1);
		texto.add(text2);
		texto.add(text3);
		texto.add(text4);
		texto.add(text5);
		texto.add(text6);
		texto.add(text7);
		texto.add(text8);
		texto.add(text9);
		texto.add(text10);
		texto.add(text11);
		texto.add(text12);
		texto.add(text13);
		texto.add(text14);
		texto.add(text15);
		texto.add(text16);
		texto.add(text17);
		texto.add(text18);
		texto.add(text19);
		texto.add(text20);
		texto.add(text21);
		
		PrintStream ps = new PrintStream(new File("dracula-colours-for-visualg.txt"));
		
		texto.forEach(text -> ps.println(text));

		ps.close();
	}
}
