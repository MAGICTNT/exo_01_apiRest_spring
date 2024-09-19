package fr.maxime.exo_01_apirest_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "realisateur")
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_realisateur")
    private long idRealisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance;

    @Column(name = "nationalite")
    private String nationalite;

    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL)
    private List<Film> films;
}
