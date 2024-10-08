package com.medhead.hospitalmicroservice.repositories;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

    @Query("SELECT b FROM Bed b WHERE b.isFree = true AND b.speciality = :speciality")
    List<Bed> findFreeBedsBySpeciality(Speciality speciality);

    @Query("SELECT b FROM Bed b WHERE b.hospital.id = :hospitalId AND b.speciality.id = :specialityId ORDER BY b.bedId DESC")
    Bed findLastAddedBedByHospitalAndSpeciality(@Param("hospitalId") Long hospitalId, @Param("specialityId") Long specialityId);

    Optional<Bed> findTopByOrderByBedIdDesc();
}
