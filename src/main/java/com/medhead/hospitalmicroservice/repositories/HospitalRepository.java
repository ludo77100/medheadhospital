package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @Query("SELECT h FROM Hospital h JOIN h.bedSet b WHERE b.speciality.specialityId = :specialityId AND b.isFree = true")
    List<Hospital> findHospitalsWithFreeBedsBySpeciality(@Param("specialityId") Long specialityId);
}
