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

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private HospitalRepository hospitalRepository ;

    @Autowired
    private SpecialityRepository specialityRepository ;

    @Override
    public List<Bed> findFreeBedsBySpeciality(Speciality speciality) {
        return bedRepository.findFreeBedsBySpeciality(speciality);
    }

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
