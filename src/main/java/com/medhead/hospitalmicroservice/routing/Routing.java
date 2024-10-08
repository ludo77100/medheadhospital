package com.medhead.hospitalmicroservice.routing;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import com.graphhopper.util.shapes.GHPoint;
import com.medhead.hospitalmicroservice.entities.Hospital;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.List;

@Service
public class Routing {

    GraphHopper hopper = new GraphHopper();

    public void graphHopperInit() {

        String osmPath = Paths.get("src/main/resources/greater-london-latest.osm.pbf").toString();

        // Initialisation de GraphHopper
        hopper.setGraphHopperLocation("graph-folder");
        hopper.setOSMFile(osmPath);

        // Définir le profil pour un véhicule spécifique (ex. voiture)
        Profile carProfile = new Profile("car")
                .setVehicle("car")  // Définissez le véhicule ici
                .setWeighting("fastest");  // Méthode de calcul du profil, ex. le plus rapide

        hopper.setProfiles(carProfile);

        // Chargez les données et préparez GraphHopper
        hopper.importOrLoad();
        System.out.println("Initialisation de graphopper");
    }

    public Hospital getClosestHospital(List<Hospital> hospitalList, double userLat, double userLon) {

        this.graphHopperInit();

        long shorterTime = 1000000 ;
        Hospital closestHospital = new Hospital();

        for(Hospital hospital: hospitalList){
            // Créez une requête de routage
            GHRequest request = new GHRequest(
                    new GHPoint(userLat, userLon), // Point de départ (latitude, longitude)
                    new GHPoint(hospital.getHospitalLatitude(), hospital.getHospitalLongitude())  // Point d'arrivée (latitude, longitude)
            ).setProfile("car");

            // Exécutez la requête
            GHResponse response = hopper.route(request);

            // Gérer les résultats
            if (response.hasErrors()) {
                System.out.println("Erreur : " + response.getErrors());
            } else {
                if (response.getBest().getTime() < shorterTime){
                    shorterTime = response.getBest().getTime();
                    closestHospital = hospital;
                }
                System.out.println("Distance : " + response.getBest().getDistance() + " mètres");
                System.out.println("Durée : " + response.getBest().getTime() / 1000.0 / 60.0 + " minutes");
            }
        }

        return closestHospital ;
    }
}