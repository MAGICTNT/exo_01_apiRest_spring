package fr.maxime.exo_01_apirest_spring.service;

import fr.maxime.exo_01_apirest_spring.entity.Film;
import fr.maxime.exo_01_apirest_spring.exception.ResourceNotFoundException;
import fr.maxime.exo_01_apirest_spring.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film not found with id " + id));
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public Film updateFilm(Long id, Film filmDetails) {
        Film film = getFilmById(id);
        film.setNom(filmDetails.getNom());
        film.setDateDeSortie(filmDetails.getDateDeSortie());
        film.setDescription(filmDetails.getDescription());
        film.setDuree(filmDetails.getDuree());
        film.setGenre(filmDetails.getGenre());
        film.setRealisateur(filmDetails.getRealisateur());
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        Film film = getFilmById(id);
        filmRepository.delete(film);
    }
}
