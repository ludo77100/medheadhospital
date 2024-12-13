package com.medhead.hospitalmicroservice.configurations;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration de GraphHopper
 *
 * Cette classe configure et initialise GraphHopper, le moteur de calcul d'itinéraires.
 *
 * Principales fonctionnalités :
 * - Initialisation de GraphHopper avec un fichier OSM (OpenStreetMap) contenant des données géographiques
 * - Configuration du profil de routage (véhicule, mode de calcul, etc.)
 * - Importation des données OSM dans le moteur GraphHopper
 */
@Configuration
public class GraphHopperConfig {

    /**
     * Configuration et initialisation de GraphHopper
     *
     * Cette méthode initialise et configure une instance de GraphHopper.
     *
     * Logique principale :
     * - Charge le fichier greater-london-latest.osm.pbf contenant les données OSM.
     * - Configure le répertoire de stockage de GraphHopper.
     * - Crée un profil de routage pour le mode de transport car (voiture).
     *
     * Configuration des paramètres :
     * - Fichier OSM : `src/main/resources/greater-london-latest.osm.pbf`
     * - GraphHopperLocation : Répertoire graph-folder où sont stockés les fichiers générés.
     * - Profil : Le profil de routage est défini pour les voitures avec l'option "fastest".
     *
     * @return GraphHopper configuré et prêt à être utilisé.
     */
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