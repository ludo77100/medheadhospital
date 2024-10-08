package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    List<Hospital> findAll();

    Optional<Hospital> findById(Long hospitalId);

    List<Hospital> findHospitalWithFreeBedsForOneSpeciality(Speciality speciality);
}
