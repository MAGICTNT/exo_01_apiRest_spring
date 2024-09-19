package fr.maxime.exo_01_apirest_spring.controller;

import fr.maxime.exo_01_apirest_spring.dto.FilmDTO;
import fr.maxime.exo_01_apirest_spring.dto.RealisateurDTO;
import fr.maxime.exo_01_apirest_spring.entity.Realisateur;
import fr.maxime.exo_01_apirest_spring.mapper.FilmMapper;
import fr.maxime.exo_01_apirest_spring.mapper.RealisateurMapper;
import fr.maxime.exo_01_apirest_spring.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mapper/catalogue/realisateur")
public class RealisateurMapperController {
    @Autowired
    private RealisateurService realisateurService;

    @GetMapping
    public List<RealisateurDTO> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs().stream()
                .map(RealisateurMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RealisateurDTO getRealisateurById(@PathVariable Long id) {
        return RealisateurMapper.toDTO(realisateurService.getRealisateurById(id));
    }

    @GetMapping("/{id}/films")
    public List<FilmDTO> getFilmsByRealisateur(@PathVariable Long id) {
        return realisateurService.getFilmsByRealisateur(id).stream()
                .map(FilmMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public RealisateurDTO createRealisateur(@RequestBody RealisateurDTO realisateurDTO) {
        Realisateur realisateur = RealisateurMapper.toEntity(realisateurDTO);
        return RealisateurMapper.toDTO(realisateurService.saveRealisateur(realisateur));
    }

    @PutMapping("/{id}")
    public RealisateurDTO updateRealisateur(@PathVariable Long id, @RequestBody RealisateurDTO realisateurDTO) {
        Realisateur realisateur = RealisateurMapper.toEntity(realisateurDTO);
        return RealisateurMapper.toDTO(realisateurService.updateRealisateur(id, realisateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealisateur(@PathVariable Long id) {
        realisateurService.deleteRealisateur(id);
        return ResponseEntity.noContent().build();
    }
}
