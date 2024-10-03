package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityGroupRepository extends JpaRepository<SpecialityGroup, Long> {
}
