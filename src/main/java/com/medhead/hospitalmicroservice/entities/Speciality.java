package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


/**
 * Représente une spécialité médicale dans le système.
 *
 * Chaque spécialité est associée à un groupe de spécialités
 * et est reliée à des lits d'hôpital ainsi qu'à des hôpitaux
 *
 * Principales relations :
 * - Une spécialité appartient à un groupe de spécialités (relation @ManyToOne).
 * - Une spécialité est liée à plusieurs lits (relation @OneToMany).
 * - Une spécialité peut être associée à plusieurs hôpitaux (relation @ManyToMany).
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId ;

    private String specialityName ;

    /**
     * Groupe de spécialités auquel appartient cette spécialité.
     *
     * Relation :
     * - @ManyToOne : Chaque spécialité appartient à un seul groupe de spécialités.
     * - @JsonIgnore : Empêche la sérialisation JSON pour éviter les boucles infinies lors des requêtes REST.
     */
    @ManyToOne
    @JoinColumn(name = "speciality_group_id")
    @JsonIgnore
    private SpecialityGroup specialityGroup ;

    /**
     * Ensemble des lits associés à cette spécialité.
     *
     * Relation :
     * - @OneToMany : Une spécialité peut avoir plusieurs lits.
     * - @JsonIgnore : Empêche la sérialisation JSON pour éviter les boucles infinies lors des requêtes REST.
     */
    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Bed> beds ;

    /**
     * Ensemble des hôpitaux associés à cette spécialité.
     *
     * Relation :
     * - @ManyToMany : Une spécialité peut être associée à plusieurs hôpitaux et un hôpital peut proposer plusieurs spécialités.
     * - @JsonIgnore : Empêche la sérialisation JSON pour éviter les boucles infinies lors des requêtes REST.
     */
    @ManyToMany(mappedBy = "specialities")
    @JsonIgnore
    private Set<Hospital> hospitals ;

}
