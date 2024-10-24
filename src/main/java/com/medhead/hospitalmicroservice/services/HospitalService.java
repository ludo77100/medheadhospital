package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    List<Hospital> findAll();

    Optional<Hospital> findById(Long hospitalId);

    List<Hospital> findHospitalWithFreeBedsForOneSpeciality(Long specialityId);
}
