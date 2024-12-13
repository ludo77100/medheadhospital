package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.ClosestHospital;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.routing.Routing;
import com.medhead.hospitalmicroservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des hôpitaux.
 * Cette classe permet de récupérer des informations sur les hôpitaux, y compris la liste de tous les hôpitaux,
 * la recherche d'hôpitaux avec des lits disponibles par spécialité et la recherche des hôpitaux les plus proches.
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private Routing routing ;

    /**
     * Récupère la liste de tous les hôpitaux.
     *
     * @return Une réponse HTTP contenant la liste de tous les hôpitaux et le statut HTTP 200 (OK) si l'opération réussit.
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/all")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Hospital>> findAllHospitall(){
        List<Hospital> hospitalList = hospitalService.findAll();
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    /**
     * Récupère un hôpital en fonction de son identifiant.
     *
     * @param hospitalId L'identifiant de l'hôpital à récupérer.
     * @return Une réponse HTTP contenant l'hôpital correspondant et le statut HTTP 200 (OK) si l'hôpital est trouvé.
     *         Si l'hôpital n'est pas trouvé, la réponse renvoie un statut HTTP 404 (Not Found).
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/{hospitalId}")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<Hospital> findHospitalById(@PathVariable Long hospitalId) {
        Optional<Hospital> hospital = hospitalService.findById(hospitalId) ;
        return hospital.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Récupère la liste des hôpitaux disposant de lits disponibles pour une spécialité donnée.
     *
     * @param specialityId L'identifiant de la spécialité recherchée.
     * @return Une réponse HTTP contenant la liste des hôpitaux disposant de lits libres pour la spécialité demandée
     *         et le statut HTTP 200 (OK) si l'opération réussit.
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/withfreebedbyspeciality")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Hospital>> findHospitalsWithFreeBeds(@RequestParam Long specialityId) {
        List<Hospital> hospitalList = hospitalService.findHospitalWithFreeBedsForOneSpeciality(specialityId) ;
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    /**
     * Récupère la liste des hôpitaux les plus proches de l'utilisateur disposant de lits disponibles pour une spécialité donnée.
     *
     * @param specialityId L'identifiant de la spécialité recherchée.
     * @param userLatStr La latitude de l'utilisateur sous forme de chaîne de caractères.
     * @param userLonStr La longitude de l'utilisateur sous forme de chaîne de caractères.
     * @return Une réponse HTTP contenant la liste des hôpitaux les plus proches disposant de lits disponibles pour la spécialité
     *         et le statut HTTP 200 (OK) si l'opération réussit.
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/closest")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<ClosestHospital>> findClosestHospitalWithFreeBedsBySpeciality(@RequestParam Long specialityId,
                                                                                       @RequestParam String userLatStr,
                                                                                       @RequestParam String userLonStr) {

        double userLat = Double.parseDouble(userLatStr);
        double userLon = Double.parseDouble(userLonStr);

        List<Hospital> hospitalList = hospitalService.findHospitalWithFreeBedsForOneSpeciality(specialityId) ;
        List<ClosestHospital> closestHospitalList = routing.getClosestHospital(hospitalList, userLat, userLon, specialityId);

        return new ResponseEntity<>(closestHospitalList, HttpStatus.OK);
    }

}
