package api.paciente;

public record ListagemPacienteDto(String nome, String email, String cpf) {

	public ListagemPacienteDto(Paciente p) {
		this(p.getNome(), p.getEmail(), p.getCpf());
	}
}
