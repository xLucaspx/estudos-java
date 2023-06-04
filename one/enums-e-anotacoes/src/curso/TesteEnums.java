package curso;

public class TesteEnums {
  public static void main(String[] args) {
		Thread t = new Thread(() -> System.out.println("rodando"));

		t.setPriority(Thread.MAX_PRIORITY); // equivalente a t.setPriority(10), porém muito mais legível
		System.out.println(Thread.MAX_PRIORITY);

		t.start();

		Prioridade pMin = Prioridade.MIN;
		Prioridade pReg = Prioridade.REG;
		Prioridade pMax = Prioridade.MAX;

		System.out.println(pMin.name() + ": ordinal = " + pMin.ordinal() + " valor = " + pMin.getValor());
		System.out.println(pReg.name() + ": ordinal = " + pReg.ordinal() + " valor = " + pReg.getValor());
		System.out.println(pMax.name() + ": ordinal = " + pMax.ordinal() + " valor = " + pMax.getValor());
	}
}
