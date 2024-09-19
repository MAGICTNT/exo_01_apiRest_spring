package fr.maxime.exo_01_apirest_spring.mapper;

import fr.maxime.exo_01_apirest_spring.dto.FilmDTO;
import fr.maxime.exo_01_apirest_spring.entity.Film;

public class FilmMapper {

    public static FilmDTO toDTO(Film film) {
        if (film == null) {
            return null;
        }
        return FilmDTO.builder()
                .idFilm(film.getIdFilm())
                .nom(film.getNom())
                .dateDeSortie(film.getDateDeSortie())
                .description(film.getDescription())
                .duree(film.getDuree())
                .genre(film.getGenre())
                .realisateur(RealisateurMapper.toDTO(film.getRealisateur()))
                .build();
    }

    public static Film toEntity(FilmDTO filmDTO) {
        if (filmDTO == null) {
            return null;
        }
        return Film.builder()
                .idFilm(filmDTO.getIdFilm())
                .nom(filmDTO.getNom())
                .dateDeSortie(filmDTO.getDateDeSortie())
                .description(filmDTO.getDescription())
                .duree(filmDTO.getDuree())
                .genre(filmDTO.getGenre())
                .realisateur(RealisateurMapper.toEntity(filmDTO.getRealisateur()))
                .build();
    }
}
