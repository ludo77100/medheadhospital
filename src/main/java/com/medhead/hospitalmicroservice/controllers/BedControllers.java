package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class BedControllers {

    @Autowired
    private BedService bedService;

    @GetMapping("/freeforspeciality")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Bed>> findFreeBedsForSpeciality(@RequestParam Speciality speciality) {
        List<Bed> bedList = bedService.findFreeBedsBySpeciality(speciality) ;
        return new ResponseEntity<>(bedList, HttpStatus.OK);
    }

    @PostMapping("/save")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Bed>> savePatient(@RequestParam Long hospitalId, @RequestParam Long specialityId, @RequestParam int bedAmount){
        List<Bed> bedList = bedService.bulkSave(hospitalId, specialityId, bedAmount);
        return new ResponseEntity<>(bedList, HttpStatus.OK);
    }
}
