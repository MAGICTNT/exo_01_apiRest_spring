package fr.maxime.exo_01_apirest_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RealisateurDTO {
    private long idRealisateur;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String nationalite;
}
