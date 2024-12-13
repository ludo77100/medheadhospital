package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/**
 * Représente un lit d'hôpital dans le système.
 *
 * Chaque lit est associé à un hôpital et à une spécialité médicale.
 * Un lit peut être disponible (libre) ou non (occupé),
 * ce qui permet de suivre en temps réel la disponibilité des lits dans les hôpitaux.
 *
 * Cette entité est utilisée pour :
 * - Gérer la disponibilité des lits dans un hôpital
 * - Associer les lits à des hôpitaux et des spécialités médicales
 * - Suivre les disponibilités en temps réel
 *
 * Relations :
 * - Un lit est associé à un hôpital (relation @ManyToOne)
 * - Un lit est associé à une spécialité médicale (relation @ManyToOne)
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bedId ;

    private String bedCode;

    /**
     * Indique si le lit est libre ou non.
     * - true : le lit est libre et peut être utilisé.
     * - false : le lit est occupé.
     */
    private boolean isFree ;


    /**
     * Référence à l'hôpital auquel ce lit est associé.
     *
     * La relation est de type @ManyToOne, ce qui signifie qu'un hôpital peut avoir plusieurs lits.
     * Le champ hospital_id est la clé étrangère dans la base de données.
     *
     * Annotation @JsonIgnore : Cette annotation empêche la sérialisation JSON de l'hôpital
     * pour éviter les boucles infinies lors de l'envoi de la réponse d'une API REST.
     */
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    /**
     * Référence à la spécialité médicale à laquelle ce lit est associé.
     *
     * La relation est de type @ManyToOne, ce qui signifie qu'un lit est associé à une spécialité.
     * Le champ speciality_id est la clé étrangère dans la base de données.
     */
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
