package xlucaspx.adopet.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xlucaspx.adopet.api.model.Abrigo;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
	boolean existsByNome(String nome);

	boolean existsByTelefone(String telefone);

	boolean existsByEmail(String email);

	Optional<Abrigo> findByNome(String nome);
}
