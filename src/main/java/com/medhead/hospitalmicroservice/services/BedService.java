package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;

import java.util.List;

public interface BedService {

    List<Bed> bulkSave(Long hospitalId, Long specialityId, int bedAmount);

    List<Bed> findFreeBedsBySpecialityId(Long specialityId);
}
