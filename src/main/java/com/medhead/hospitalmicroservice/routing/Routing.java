package com.medhead.hospitalmicroservice.routing;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.util.shapes.GHPoint;
import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.ClosestHospital;
import com.medhead.hospitalmicroservice.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Service de routage permettant de trouver les hôpitaux les plus proches en fonction de la position de l'utilisateur.
 *
 * Ce service utilise la bibliothèque GraphHopper pour calculer les distances et les temps de trajet entre la position de l'utilisateur et les hôpitaux.
 * Le service permet également d'identifier le lit disponible associé à la spécialité médicale demandée.
 *
 * Fonctionnalités principales :
 * - Calculer la distance et le temps de trajet (en utilisant le mode de déplacement "voiture").
 * - Identifier les hôpitaux les plus proches en fonction de la position de l'utilisateur.
 * - Filtrer les hôpitaux disposant d'un lit libre pour une spécialité donnée.
 *
 *
 * Technologies utilisées :
 * - GraphHopper : Bibliothèque de calcul d'itinéraires.
 */
@Service
public class Routing {

    private final GraphHopper hopper;

    /**
     * Indique si l'instance de GraphHopper a déjà été initialisée.
     */
    private boolean initialized = false;

    @Autowired
    public Routing(GraphHopper hopper) {
        this.hopper = hopper;
        if (!initialized) {
            initialized = true;
        }
    }


    /**
     * Recherche les hôpitaux les plus proches disposant de lits disponibles pour une spécialité donnée.
     *
     * @param hospitalList Liste des hôpitaux à analyser.
     * @param userLat Latitude de l'utilisateur.
     * @param userLon Longitude de l'utilisateur.
     * @param specialityId Identifiant de la spécialité recherchée.
     *
     * @return Liste des hôpitaux les plus proches avec leurs distances, temps de trajet et lits disponibles.
     *
     * @throws RuntimeException Si une erreur se produit pendant le calcul du routage.
     */
    public List<ClosestHospital> getClosestHospital(List<Hospital> hospitalList, double userLat, double userLon, Long specialityId) {
        List<ClosestHospital> closestHospitalList = new ArrayList<>();

        for (Hospital hospital : hospitalList) {
            // Création de la requête GraphHopper pour calculer l'itinéraire
            GHRequest request = new GHRequest(
                    new GHPoint(userLat, userLon),
                    new GHPoint(hospital.getHospitalLatitude(), hospital.getHospitalLongitude())
            ).setProfile("car");

            // Exécution de la requête et récupération de la réponse
            GHResponse response = hopper.route(request);

            if (response.hasErrors()) {
                throw new RuntimeException("Une erreur s'est produite lors du routing");
            } else {

                // Création d'un objet ClosestHospital et affectation des distances et temps de trajet
                ClosestHospital closestHospital = new ClosestHospital();

                closestHospital.setHospital(hospital);
                closestHospital.setDistance(response.getBest().getDistance() / 1000); // Conversion en kilomètres
                closestHospital.setTime(response.getBest().getTime() / 1000 / 60); // Conversion en minutes

                closestHospitalList.add(closestHospital);
            }

            // Recherche du lit disponible correspondant à la spécialité demandée
            for (ClosestHospital closestHospital : closestHospitalList){
                for (Bed bed: closestHospital.getHospital().getBedSet()) {
                    if (bed.getSpeciality().getSpecialityId().equals(specialityId)) {
                        closestHospital.setBedId(bed.getBedId());
                        closestHospital.setBedCode(bed.getBedCode());
                    }
                }
            }

            // Tri de la liste des hôpitaux par temps de trajet croissant
            closestHospitalList.sort(Comparator.comparing(ClosestHospital::getTime));

        }

        return closestHospitalList;
    }
}