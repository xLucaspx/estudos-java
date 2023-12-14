package api.domain.medico;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	// seguindo a convenção de nomenclatura o Spring consegue gerar o método automaticamente,
	// neste caso um bétodo que busca os registros WHERE ativo = TRUE;
	Page<Medico> findAllByAtivoTrue(Pageable paginacao);

	// se o método não segue o padrão de nomenclatura do Spring é necessário escrever o JPQL utilizando a anotação @Query.
	// esta consulta busca um médico aleatório da especialidade definida e que não tenha consulta agendada na data passada
	@Query("""
		SELECT m from Medico m
		WHERE m.ativo = TRUE
			AND m.especialidade = :especialidade
			AND m.id NOT IN (SELECT c.medico.id FROM Consulta c WHERE c.data = :data)
		ORDER BY rand()
		LIMIT 1
		""")
	Medico escolheMedicoLivreNaDataPorEspecialidade(@NotNull @Future LocalDateTime data, Especialidade especialidade);
}
