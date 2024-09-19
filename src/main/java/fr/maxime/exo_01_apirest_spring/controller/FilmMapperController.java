package fr.maxime.exo_01_apirest_spring.controller;

import fr.maxime.exo_01_apirest_spring.dto.FilmDTO;
import fr.maxime.exo_01_apirest_spring.entity.Film;
import fr.maxime.exo_01_apirest_spring.mapper.FilmMapper;
import fr.maxime.exo_01_apirest_spring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mapper/catalogue/films")
public class FilmMapperController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<FilmDTO> getAllFilms() {
        return filmService.getAllFilms().stream()
                .map(FilmMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FilmDTO getFilmById(@PathVariable Long id) {
        return FilmMapper.toDTO(filmService.getFilmById(id));
    }

    @PostMapping
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO) {
        Film film = FilmMapper.toEntity(filmDTO);
        return FilmMapper.toDTO(filmService.saveFilm(film));
    }

    @PutMapping("/{id}")
    public FilmDTO updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        Film film = FilmMapper.toEntity(filmDTO);
        return FilmMapper.toDTO(filmService.updateFilm(id, film));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
