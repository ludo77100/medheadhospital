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

    private final GraphHopper hopper;

    public Routing() {
        // Initialisation de GraphHopper une seule fois
        hopper = new GraphHopper();

        String osmPath = Paths.get("src/main/resources/greater-london-latest.osm.pbf").toString();
        hopper.setGraphHopperLocation("graph-folder");
        hopper.setOSMFile(osmPath);

        Profile carProfile = new Profile("car")
                .setVehicle("car")
                .setWeighting("fastest");

        hopper.setProfiles(carProfile);
        hopper.importOrLoad();
        System.out.println("GraphHopper initialisé");
    }

    public Hospital getClosestHospital(List<Hospital> hospitalList, double userLat, double userLon) {
        long shorterTime = Long.MAX_VALUE;
        Hospital closestHospital = null;

        for (Hospital hospital : hospitalList) {
            GHRequest request = new GHRequest(
                    new GHPoint(userLat, userLon),
                    new GHPoint(hospital.getHospitalLatitude(), hospital.getHospitalLongitude())
            ).setProfile("car");

            GHResponse response = hopper.route(request);

            if (response.hasErrors()) {
                System.out.println("Erreur : " + response.getErrors());
            } else {
                if (response.getBest().getTime() < shorterTime) {
                    shorterTime = response.getBest().getTime();
                    closestHospital = hospital;
                }
                System.out.println("Distance : " + response.getBest().getDistance() + " mètres");
                System.out.println("Durée : " + response.getBest().getTime() / 1000.0 / 60.0 + " minutes");
                System.out.println(hospital.getHospitalName());
            }
        }

        return closestHospital;
    }
}