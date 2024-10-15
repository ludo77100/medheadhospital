package com.medhead.hospitalmicroservice.configurations;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphHopperConfig {

    @Bean
    public GraphHopper graphHopper() {
        GraphHopper hopper = new GraphHopper();
        hopper.setOSMFile("src/main/resources/greater-london-latest.osm.pbf"); // Chemin vers le fichier OSM
        hopper.setGraphHopperLocation("graph-folder");

        Profile carProfile = new Profile("car")
                .setVehicle("car")
                .setWeighting("fastest");
        hopper.setProfiles(carProfile);
        hopper.importOrLoad();

        return hopper;
    }
}