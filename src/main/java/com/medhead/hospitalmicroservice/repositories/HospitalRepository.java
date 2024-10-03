package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
