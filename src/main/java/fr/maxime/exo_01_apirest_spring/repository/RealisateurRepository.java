package fr.maxime.exo_01_apirest_spring.repository;

import fr.maxime.exo_01_apirest_spring.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
}
