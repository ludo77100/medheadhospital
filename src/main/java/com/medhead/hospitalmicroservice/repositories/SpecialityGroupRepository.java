package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityGroupRepository extends JpaRepository<SpecialityGroup, Long> {
}
