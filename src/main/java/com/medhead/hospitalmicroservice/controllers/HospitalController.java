package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/all")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Hospital>> findAllHospitall(){
        List<Hospital> hospitalList = hospitalService.findAll();
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    @GetMapping("/{hospitalId}")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<Hospital> findHospitalById(@PathVariable Long hospitalId) {
        Optional<Hospital> hospital = hospitalService.findById(hospitalId) ;
        return hospital.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/bedlist")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Hospital>> findHospitalsWithFreeBeds(@RequestParam Speciality speciality) {
        List<Hospital> hospitalList = hospitalService.findHospitalWithFreeBedsForOneSpeciality(speciality) ;
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

}
