package fr.maxime.exo_01_apirest_spring.controller;
import fr.maxime.exo_01_apirest_spring.entity.Film;
import fr.maxime.exo_01_apirest_spring.entity.Realisateur;
import fr.maxime.exo_01_apirest_spring.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue/realisateur")
public class RealisateurController {

    @Autowired
    private RealisateurService realisateurService;

    @GetMapping
    public List<Realisateur> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable Long id) {
        Realisateur realisateur = realisateurService.getRealisateurById(id);
        if (realisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(realisateur);
    }

    @GetMapping("/{id}/films")
    public ResponseEntity<List<Film>> getFilmsByRealisateur(@PathVariable Long id) {
        List<Film> films = realisateurService.getFilmsByRealisateur(id);
        if (films == null || films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }

    @PostMapping
    public ResponseEntity<Realisateur> createRealisateur(@RequestBody Realisateur realisateur) {
        Realisateur createdRealisateur = realisateurService.saveRealisateur(realisateur);
        return ResponseEntity.ok(createdRealisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Realisateur> updateRealisateur(@PathVariable Long id, @RequestBody Realisateur realisateur) {
        Realisateur updatedRealisateur = realisateurService.updateRealisateur(id, realisateur);
        if (updatedRealisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRealisateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealisateur(@PathVariable Long id) {
        realisateurService.deleteRealisateur(id);
        return ResponseEntity.noContent().build();
    }
}
