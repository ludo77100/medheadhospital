package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.ClosestHospital;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.routing.Routing;
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

    @Autowired
    private Routing routing ;

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

    @GetMapping("/withfreebedbyspeciality")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Hospital>> findHospitalsWithFreeBeds(@RequestParam Long specialityId) {
        List<Hospital> hospitalList = hospitalService.findHospitalWithFreeBedsForOneSpeciality(specialityId) ;
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    @GetMapping("/closest")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<ClosestHospital>> findClosestHospitalWithFreeBedsBySpeciality(@RequestParam Long specialityId,
                                                                                       @RequestParam String userLatStr,
                                                                                       @RequestParam String userLonStr) {

        double userLat = Double.parseDouble(userLatStr);
        double userLon = Double.parseDouble(userLonStr);

        List<Hospital> hospitalList = hospitalService.findHospitalWithFreeBedsForOneSpeciality(specialityId) ;
        List<ClosestHospital> closestHospitalList = routing.getClosestHospital(hospitalList, userLat, userLon, specialityId);

        return new ResponseEntity<>(closestHospitalList, HttpStatus.OK);
    }

}
