package com.medhead.hospitalmicroservice.services.impls;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.repositories.SpecialityGroupRepository;
import com.medhead.hospitalmicroservice.services.SpecialityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service d'implémentation de la gestion des groupes de spécialités (SpecialityGroupService)
 *
 * Cette classe implémente les opérations associées à la gestion des groupes de spécialités médicales.
 *
 * Principales fonctionnalités :
 * - Récupérer la liste de tous les groupes de spécialités.
 *
 */
@Service
public class SpecialityGroupServiceImpl implements SpecialityGroupService {

    @Autowired
    SpecialityGroupRepository specialityGroupRepository ;


    /**
     * Récupère la liste de tous les groupes de spécialités.
     *
     * @return La liste de tous les groupes de spécialités.
     */
    @Override
    public List<SpecialityGroup> findAll() {
        return specialityGroupRepository.findAll();
    }
}
