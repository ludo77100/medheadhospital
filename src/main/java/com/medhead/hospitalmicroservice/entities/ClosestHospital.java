package com.medhead.hospitalmicroservice.entities;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Représente un hôpital le plus proche avec des informations supplémentaires
 * concernant la distance, le temps d'accès et la disponibilité d'un lit.
 *
 * Cette classe est utilisée pour fournir des résultats lors de la recherche d'hôpitaux
 * les plus proches disposant de lits libres pour une spécialité donnée.
 *
 * Propriétés principales :
 * - Distance entre l'utilisateur et l'hôpital
 * - Temps estimé pour accéder à l'hôpital
 * - Hôpital associé
 * - Informations sur le lit disponible (identifiant et code)
 *
 * Cette entité n'est pas liée à une table de base de données.
 * Elle sert de DTO (Data Transfer Object) pour faciliter la communication
 * entre les services et les contrôleurs.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClosestHospital {

    /**
     * Distance entre l'utilisateur et l'hôpital.
     * La distance est arrondie à 2 chiffres après la virgule.
     */
    private double distance;

    /**
     * Temps estimé pour atteindre l'hôpital depuis la position de l'utilisateur.
     * Ce champ permet d'estimer la durée de trajet.
     */
    private Long time;

    /**
     * Objet hospital représentant l'hôpital associé.
     * Cet objet contient des informations sur l'hôpital, telles que son nom et sa position géographique.
     */
    private Hospital hospital;

    /**
     * Identifiant du lit disponible à l'hôpital.
     * Ce champ permet de savoir quel lit spécifique est réservable.
     */
    private Long bedId;

    /**
     * Code unique identifiant le lit.
     * Ce code suit une convention de nommage spécifique
     */
    private String bedCode;

    /**
     * Définit la distance entre l'utilisateur et l'hôpital.
     *
     * La distance est automatiquement arrondie à 2 chiffres après la virgule à l'aide de la classe BigDecimal
     * et de la méthode setScale() avec le mode d'arrondi RoundingMode.HALF_UP
     *
     * @param distance La distance entre l'utilisateur et l'hôpital.
     */
    public void setDistance(double distance) {
        BigDecimal bd = BigDecimal.valueOf(distance)
                .setScale(2, RoundingMode.HALF_UP);
        this.distance = bd.doubleValue();
    }
}