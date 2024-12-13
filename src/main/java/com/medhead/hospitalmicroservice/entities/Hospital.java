package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Représente un hôpital dans le système.
 *
 * Un hôpital est une entité essentielle du système, associée à des lits et des spécialités médicales.
 * Chaque hôpital possède un nom, une position géographique (latitude et longitude)
 * et est relié à des lits et des spécialités médicales.
 *
 * Principales relations :
 * - Un hôpital peut avoir plusieurs lits (relation @OneToMany)
 * - Un hôpital peut proposer plusieurs spécialités médicales (relation @ManyToMany)
 *
 * Utilisation typique :
 * - Suivre les disponibilités des lits d'un hôpital.
 * - Localiser l'hôpital sur une carte via ses coordonnées GPS.
 * - Lister les spécialités médicales prises en charge par l'hôpital.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hospital {

    /**
     * Identifiant unique de l'hôpital.
     * Ce champ est généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalId;

    /**
     * Nom de l'hôpital.
     * Ce champ permet d'identifier l'hôpital dans les listes et les recherches.
     */
    private String hospitalName;

    /**
     * Latitude de la position géographique de l'hôpital.
     * Cette valeur est utilisée pour calculer les distances entre les hôpitaux et les utilisateurs.
     *
     */
    private double hospitalLatitude;

    /**
     * Longitude de la position géographique de l'hôpital.
     * Cette valeur est utilisée pour calculer les distances entre les hôpitaux et les utilisateurs.
     *
     */
    private double hospitalLongitude;

    /**
     * Ensemble des lits associés à cet hôpital.
     *
     */
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bed> bedSet;

    /**
     * Ensemble des spécialités médicales associées à cet hôpital.
     *
     */
    @ManyToMany
    @JoinTable(
            name = "hospital_specialities",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    @JsonIgnore
    private Set<Speciality> specialities;

}