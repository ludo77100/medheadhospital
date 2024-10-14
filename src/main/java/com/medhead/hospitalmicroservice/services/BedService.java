package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BedService {

    List<Bed> bulkSave(Long hospitalId, Long specialityId, int bedAmount);

    List<Bed> findFreeBedsBySpecialityId(Long specialityId);

    Optional<Bed> changeBedState(Long bedId);
}
