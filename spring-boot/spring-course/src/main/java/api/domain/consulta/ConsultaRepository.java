package api.domain.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

	boolean existsByMedicoIdAndData(int idMedico, LocalDateTime horario);

	boolean existsByPacienteIdAndDataBetween(int idMedico, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
