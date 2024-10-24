package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

    @Query("SELECT b FROM Bed b WHERE b.speciality.id = :specialityId AND b.isFree = true")
    List<Bed> findFreeBedsBySpecialityId(@Param("specialityId") Long specialityId);

    Optional<Bed> findTopByOrderByBedIdDesc();
}
