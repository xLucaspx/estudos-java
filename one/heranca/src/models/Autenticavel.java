package models;

// interface pode ser definida como um "contrato", e
// quem "assina" esse contrato deve implementar seus metodos.
public interface Autenticavel {
	// public e abstract são opcionais, ou seja,
	// já são implícitos nos métodos da interface
	public abstract void setSenha(int senha);

	public abstract boolean autentica(int senha);
}
