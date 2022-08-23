
// enum é como se fosse uma classe, mas precisa da declaração dos objetos que vão receber um valor (ex.: min, normal, max)
public enum Prioridade {
	MIN(2), REG(7), MAX(10); // ordinal: equivale a: 0, 1, 2; esses objetos são instnciados automaticamente quando chamados em um metodo
	
	private int valor;
	
	private Prioridade(int valor) { //construtor é necessário para definir valores personalizados 
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
