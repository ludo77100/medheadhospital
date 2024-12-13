package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des lits d'hôpitaux.
 * Cette classe permet d'effectuer des opérations de création en masse et de changement d'état des lits.
 * Les accès aux différentes méthodes sont sécurisés par des rôles utilisateur.
 */
@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    /**
     * Ajoute plusieurs lits à un hôpital pour une spécialité donnée.
     *
     * @param hospitalId L'identifiant de l'hôpital auquel les lits doivent être ajoutés.
     * @param specialityId L'identifiant de la spécialité associée aux lits.
     * @param bedAmount Le nombre de lits à ajouter.
     * @return Une réponse HTTP contenant la liste des lits ajoutés et le statut HTTP 200 (OK) si l'opération réussit.
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @PostMapping("/save")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Bed>> addBedsBulk(@RequestParam Long hospitalId, @RequestParam Long specialityId, @RequestParam int bedAmount) {
        List<Bed> bedList = bedService.bulkSave(hospitalId, specialityId, bedAmount);
        return new ResponseEntity<>(bedList, HttpStatus.OK);
    }

    /**
     * Change l'état d'un lit spécifique.
     * Par exemple, un lit peut passer d'un état "disponible" à "occupé".
     *
     * @param bedId L'identifiant du lit dont l'état doit être modifié.
     * @return Une réponse HTTP contenant le lit mis à jour et le statut HTTP 200 (OK) si l'opération réussit.
     *         Si le lit n'est pas trouvé, la réponse renvoie un statut HTTP 404 (Not Found).
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/changestate")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<Bed> changeBedState(@RequestParam Long bedId) {
        return bedService.changeBedState(bedId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}