package fr.maxime.exo_01_apirest_spring.service;

import fr.maxime.exo_01_apirest_spring.entity.Film;
import fr.maxime.exo_01_apirest_spring.entity.Realisateur;
import fr.maxime.exo_01_apirest_spring.exception.ResourceNotFoundException;
import fr.maxime.exo_01_apirest_spring.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository realisateurRepository;

    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    public Realisateur getRealisateurById(Long id) {
        return realisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Realisateur not found with id " + id));
    }

    public Realisateur saveRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public Realisateur updateRealisateur(Long id, Realisateur realisateurDetails) {
        Realisateur realisateur = getRealisateurById(id);
        realisateur.setNom(realisateurDetails.getNom());
        realisateur.setPrenom(realisateurDetails.getPrenom());
        realisateur.setDateDeNaissance(realisateurDetails.getDateDeNaissance());
        realisateur.setNationalite(realisateurDetails.getNationalite());
        return realisateurRepository.save(realisateur);
    }

    public void deleteRealisateur(Long id) {
        Realisateur realisateur = getRealisateurById(id);
        realisateurRepository.delete(realisateur);
    }

    public List<Film> getFilmsByRealisateur(Long realisateurId) {
        Realisateur realisateur = getRealisateurById(realisateurId);
        return realisateur.getFilms();
    }
}
