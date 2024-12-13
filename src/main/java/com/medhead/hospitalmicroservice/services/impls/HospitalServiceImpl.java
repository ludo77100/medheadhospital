package com.medhead.hospitalmicroservice.services.impls;

import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service d'implémentation de la gestion des hôpitaux (HospitalService)
 *
 * Cette classe implémente les opérations associées à la gestion des hôpitaux.
 *
 * Principales fonctionnalités :
 * - Rechercher tous les hôpitaux.
 * - Rechercher un hôpital par son identifiant.
 * - Rechercher les hôpitaux ayant des lits libres pour une spécialité médicale.
 *
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository ;

    /**
     * Récupère la liste de tous les hôpitaux.
     *
     * @return La liste de tous les hôpitaux.
     */
    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    /**
     * Recherche un hôpital par son identifiant.
     *
     * @param hospitalId Identifiant de l'hôpital recherché.
     *
     * @return Un Optional contenant l'hôpital trouvé, ou Optional.empty() si l'hôpital n'existe pas.
     */
    @Override
    public Optional<Hospital> findById(Long hospitalId) {
        return hospitalRepository.findById(hospitalId);
    }

    /**
     * Récupère la liste des hôpitaux ayant des lits disponibles pour une spécialité donnée.
     *
     * @param specialityId Identifiant de la spécialité médicale.
     *
     * @return Une liste d'hôpitaux possédant des lits disponibles pour cette spécialité.
     */
    @Override
    public List<Hospital> findHospitalWithFreeBedsForOneSpeciality(Long specialityId) {
        return hospitalRepository.findHospitalsWithFreeBedsBySpeciality(specialityId);
    }
}
