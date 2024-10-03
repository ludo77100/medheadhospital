package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
}
