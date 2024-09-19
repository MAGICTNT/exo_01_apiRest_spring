package fr.maxime.exo_01_apirest_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private long idFilm;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_de_sortie")
    private LocalDate dateDeSortie;

    @Column(name = "description")
    private String description;

    @Column(name = "duree")
    private int duree;

    @Column(name = "genre")
    private String genre;


    @ManyToOne
    @JoinColumn(name = "id_realisateur", referencedColumnName = "id_realisateur")
    private Realisateur realisateur;
}
