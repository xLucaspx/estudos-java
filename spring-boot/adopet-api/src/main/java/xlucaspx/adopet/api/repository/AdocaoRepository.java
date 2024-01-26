package xlucaspx.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.StatusAdocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

	boolean existsByPetIdAndStatus(@NotNull Long idPet, StatusAdocao status);

	boolean existsByTutorIdAndStatus(@NotNull Long idTutor, StatusAdocao status);
	
	Long countByTutorIdAndStatus(@NotNull Long idTutor, StatusAdocao status);
}
