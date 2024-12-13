package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.services.SpecialityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des groupes de spécialités.
 */
@RestController
@RequestMapping("/specialityGroup")
public class SpecialityGroupController {

    @Autowired
    private SpecialityGroupService specialityGroupService ;

    /**
     * Récupère la liste de tous les groupes de spécialités.
     *
     * @return Une réponse HTTP contenant la liste de tous les groupes de spécialités avec ses childrens et le statut HTTP 200 (OK) si l'opération réussit.
     * @secured ROLE_SUPER_ADMIN Indique que cette méthode est accessible uniquement aux utilisateurs ayant le rôle "ROLE_SUPER_ADMIN".
     */
    @GetMapping("/all")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<SpecialityGroup>> findAllSpecialityGroup(){
        List<SpecialityGroup> specialityGroupDTOList = specialityGroupService.findAll();
        return new ResponseEntity<>(specialityGroupDTOList, HttpStatus.OK);
    }

}
