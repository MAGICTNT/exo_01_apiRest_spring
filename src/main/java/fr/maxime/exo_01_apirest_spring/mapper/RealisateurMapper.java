package fr.maxime.exo_01_apirest_spring.mapper;

import fr.maxime.exo_01_apirest_spring.dto.RealisateurDTO;
import fr.maxime.exo_01_apirest_spring.entity.Realisateur;

public class RealisateurMapper {

    public static RealisateurDTO toDTO(Realisateur realisateur) {
        if (realisateur == null) {
            return null;
        }
        return RealisateurDTO.builder()
                .idRealisateur(realisateur.getIdRealisateur())
                .nom(realisateur.getNom())
                .prenom(realisateur.getPrenom())
                .dateDeNaissance(realisateur.getDateDeNaissance())
                .nationalite(realisateur.getNationalite())
                .build();
    }

    public static Realisateur toEntity(RealisateurDTO realisateurDTO) {
        if (realisateurDTO == null) {
            return null;
        }
        return Realisateur.builder()
                .idRealisateur(realisateurDTO.getIdRealisateur())
                .nom(realisateurDTO.getNom())
                .prenom(realisateurDTO.getPrenom())
                .dateDeNaissance(realisateurDTO.getDateDeNaissance())
                .nationalite(realisateurDTO.getNationalite())
                .build();
    }
}
