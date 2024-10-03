package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
