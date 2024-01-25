package xlucaspx.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlucaspx.adopet.api.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {}
