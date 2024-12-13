package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Représente un groupe de spécialités médicales dans le système.
 *
 * Un groupe de spécialités est une catégorie qui regroupe plusieurs spécialités médicales.
 * Par exemple, le groupe "Chirurgie" peut inclure des spécialités telles que la chirurgie orthopédique,
 * la chirurgie cardiaque, etc.
 *
 * Principales relations :
 * - Un groupe de spécialités est associé à plusieurs spécialités (relation @OneToMany).
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpecialityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "speciality_group_id")
    private Long specialityGroupId ;

    private String specialityGroupName ;

    /**
     * Ensemble des spécialités associées à ce groupe de spécialités.
     *
     **Relation :
     * - @OneToMany : Un groupe de spécialités peut contenir plusieurs spécialités.
     */
    @OneToMany(mappedBy = "specialityGroup", cascade = CascadeType.DETACH, orphanRemoval = true)
    private Set<Speciality> speciality ;
}
