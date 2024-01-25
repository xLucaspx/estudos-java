package xlucaspx.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlucaspx.adopet.api.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

	boolean existsByTelefone(String telefone);

	boolean existsByEmail(String email);
}
