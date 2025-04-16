package br.edu.atitus.remediario.repositories;

import br.edu.atitus.remediario.entities.SalaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SalaRepository extends JpaRepository<SalaEntity, UUID> {
	
	
}
