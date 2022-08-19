
public class TestaSomatoria {
	public static void main(String[] args) {
		int i = 0;
		int total = 0;
		
		while (i <= 10) {
			//total = total + i; o código abaixo faz a mesma coisa:
			total += i;
			i++;
			System.out.print(total + " ");
		}
	}
}
