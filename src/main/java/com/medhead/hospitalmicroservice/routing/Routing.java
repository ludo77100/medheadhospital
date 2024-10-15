package com.medhead.hospitalmicroservice.routing;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import com.graphhopper.util.shapes.GHPoint;
import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.ClosestHospital;
import com.medhead.hospitalmicroservice.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class Routing {

    private final GraphHopper hopper;
    private boolean initialized = false;

    @Autowired
    public Routing(GraphHopper hopper) {
        this.hopper = hopper;
        if (!initialized) {
//            initGraphHopper();
            initialized = true;
        }
    }

/*    private void initGraphHopper() {
        if (!initialized) {
            String osmPath = Paths.get("src/main/resources/greater-london-latest.osm.pbf").toString();
            hopper.setGraphHopperLocation("graph-folder");
            hopper.setOSMFile(osmPath);

            Profile carProfile = new Profile("car")
                    .setVehicle("car")
                    .setWeighting("fastest");
            hopper.setProfiles(carProfile);
            hopper.importOrLoad();
        }
    }*/


/*    public Routing() {
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
    }*/

    public List<ClosestHospital> getClosestHospital(List<Hospital> hospitalList, double userLat, double userLon, Long specialityId) {
        List<ClosestHospital> closestHospitalList = new ArrayList<>();

        for (Hospital hospital : hospitalList) {
            GHRequest request = new GHRequest(
                    new GHPoint(userLat, userLon),
                    new GHPoint(hospital.getHospitalLatitude(), hospital.getHospitalLongitude())
            ).setProfile("car");

            GHResponse response = hopper.route(request);

            if (response.hasErrors()) {
                System.out.println("Erreur : " + response.getErrors());
            } else {
                System.out.println("Distance : " + response.getBest().getDistance() + " mètres");
                System.out.println("Durée : " + response.getBest().getTime() / 1000.0 / 60.0 + " minutes");
                System.out.println(hospital.getHospitalName());

                ClosestHospital closestHospital = new ClosestHospital();

                closestHospital.setHospital(hospital);
                closestHospital.setDistance(response.getBest().getDistance() / 1000);
                closestHospital.setTime(response.getBest().getTime() / 1000 / 60);

                closestHospitalList.add(closestHospital);
            }

            for (ClosestHospital closestHospital : closestHospitalList){
                for (Bed bed: closestHospital.getHospital().getBedSet()) {
                    if (bed.getSpeciality().getSpecialityId().equals(specialityId)) {
                        closestHospital.setBedId(bed.getBedId());
                        closestHospital.setBedCode(bed.getBedCode());
                    }
                }
            }

            closestHospitalList.sort(Comparator.comparing(ClosestHospital::getTime));

        }

        return closestHospitalList;
    }
}