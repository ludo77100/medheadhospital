package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;

import java.util.List;

public interface BedService {

    List<Bed> findFreeBedsBySpeciality(Speciality speciality);

    List<Bed> bulkSave(Long hospitalId, Long specialityId, int bedAmount);
}
