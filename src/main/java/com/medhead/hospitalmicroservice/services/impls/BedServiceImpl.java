package com.medhead.hospitalmicroservice.services.impls;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.repositories.BedRepository;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.repositories.SpecialityRepository;
import com.medhead.hospitalmicroservice.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service d'implémentation de la gestion des lits (BedService)
 *
 * Cette classe implémente les opérations associées à la gestion des lits d'hôpital.
 *
 * Principales fonctionnalités :
 * - Rechercher les lits disponibles par spécialité.
 * - Changer l'état d'un lit (de "libre" à "occupé" ou inversement).
 * - Créer plusieurs lits en masse dans un hôpital pour une spécialité donnée.
 *
 */

 @Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private HospitalRepository hospitalRepository ;

    @Autowired
    private SpecialityRepository specialityRepository ;


    /**
     * Récupère la liste des lits libres associés à une spécialité donnée.
     *
     * @param specialityId Identifiant de la spécialité pour laquelle on recherche les lits disponibles.
     *
     * @return Une liste de lits disponibles.
     */
    @Override
    public List<Bed> findFreeBedsBySpecialityId(Long specialityId) {
        return bedRepository.findFreeBedsBySpecialityId(specialityId);
    }

    /**
     * Change l'état d'un lit (libre ou occupé) à partir de son identifiant.
     *
     * - Si le lit est "libre", il devient "occupé".
     * - Si le lit est "occupé", il devient "libre".
     *
     * @param bedId Identifiant du lit à modifier.
     *
     * @return le lit mis à jour, ou Optional.empty() si le lit n'existe pas.
     */
    @Override
    public Optional<Bed> changeBedState(Long bedId) {
        return bedRepository.findById(bedId).map(bed -> {
            bed.setFree(!bed.isFree()); // Inverse l'état de disponibilité
            bedRepository.save(bed);    // Sauvegarde le lit mis à jour
            return bed;
        });
    }

    /**
     * Crée plusieurs lits pour un hôpital et une spécialité donnés.
     *
     * - Récupère l'hôpital et la spécialité correspondants.
     * - Crée des lits, génère des codes de lit uniques au format hospitalId-specialityId-Bcode
     * - Le code de lit est incrémenté automatiquement à partir du dernier code existant.
     *
     * @param hospitalId Identifiant de l'hôpital où les lits doivent être créés.
     * @param specialityId Identifiant de la spécialité pour laquelle les lits sont créés.
     * @param bedAmount Nombre de lits à créer.
     *
     * @return La liste des lits nouvellement créé
     *
     * @throws IllegalArgumentException Si l'hôpital ou la spécialité n'existent pas.
     */
    @Override
    public List<Bed> bulkSave(Long hospitalId, Long specialityId, int bedAmount) {

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found with ID: " + hospitalId));
        Speciality speciality = specialityRepository.findById(specialityId)
                .orElseThrow(() -> new IllegalArgumentException("Speciality not found with ID: " + specialityId));

        Bed lastBedAdded = bedRepository.findTopByOrderByBedIdDesc().orElse(null);
        int newBedCode = (lastBedAdded == null) ? 0 : extractInt(lastBedAdded.getBedCode());

        List<Bed> newBedList = new ArrayList<>();
        for (int i = 0; i < bedAmount; i++) {
            Bed newBed = new Bed();
            newBedCode++; // Incrémentation du code de lit

            newBed.setHospital(hospital);
            newBed.setSpeciality(speciality);
            newBed.setFree(true);
            newBed.setBedCode(hospitalId + "-" + specialityId + "-B" + newBedCode);

            bedRepository.save(newBed);
            newBedList.add(newBed);
        }
        return newBedList;
    }


    /**
     * Extrait le numéro du lit à partir du code de lit.
     *
     * Logique métier :
     * - Le code de lit est au format hospitalId-specialityId-Bcode
     * - Cette méthode extrait la partie numérique après "B".
     *
     * @param input Le code du lit à analyser (par exemple, "1-2-B45").
     *
     * @return Le numéro de lit sous forme d'entier.
     *
     * @throws IllegalArgumentException Si le format du code de lit est incorrect.
     */
    public int extractInt(String input) {
        int index = input.lastIndexOf("B");
        if (index == -1 || index + 1 >= input.length()) {
            throw new IllegalArgumentException("Le format de chaîne n'est pas valide ou il n'y a pas de caractère après 'B'.");
        }

        String numberStr = input.substring(index + 1);

        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Les caractères après 'B' ne sont pas un nombre valide.", e);
        }
    }
}
