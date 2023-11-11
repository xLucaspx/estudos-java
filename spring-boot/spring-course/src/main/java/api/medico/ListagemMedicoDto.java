package api.medico;

// para a listagem devmos devolver apenas 4 campos, então criamos um novo DTO que contenha apenas estes campos:
public record ListagemMedicoDto(int id, String nome, String email, String crm, Especialidade especialidade) {

	public ListagemMedicoDto(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
