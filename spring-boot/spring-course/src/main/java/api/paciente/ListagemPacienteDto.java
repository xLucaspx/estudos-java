package api.paciente;

public record ListagemPacienteDto(int id, String nome, String email, String cpf) {

	public ListagemPacienteDto(Paciente p) {
		this(p.getId(), p.getNome(), p.getEmail(), p.getCpf());
	}
}
