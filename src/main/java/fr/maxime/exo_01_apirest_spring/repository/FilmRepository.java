package fr.maxime.exo_01_apirest_spring.repository;

import fr.maxime.exo_01_apirest_spring.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByRealisateurIdRealisateur(Long idRealisateur);
}
