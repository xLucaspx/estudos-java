package xlucaspx.adopet.api.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xlucaspx.adopet.api.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	Page<Pet> findAllByAdotadoFalse(Pageable paginacao);

	Page<Pet> findAllByAbrigoId(Long idAbrigo, Pageable paginacao);

	@Query("SELECT p.adotado FROM Pet p WHERE p.id = :id")
	Boolean findAdotadoById(@NotNull Long id);
}
