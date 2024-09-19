package fr.maxime.exo_01_apirest_spring.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO {
    private long idFilm;
    private String nom;
    private LocalDate dateDeSortie;
    private String description;
    private int duree;
    private String genre;
    private RealisateurDTO realisateur;
}
