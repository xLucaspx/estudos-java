package api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	// seguindo a convenção de nomenclatura o Spring consegue gerar o método automaticamente,
	// neste caso um bétodo que busca os registros WHERE ativo = TRUE;
	Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
