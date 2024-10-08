package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping("/save")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<Bed>> addBedsBulk(@RequestParam Long hospitalId, @RequestParam Long specialityId, @RequestParam int bedAmount){
        List<Bed> bedList = bedService.bulkSave(hospitalId, specialityId, bedAmount);
        return new ResponseEntity<>(bedList, HttpStatus.OK);
    }
}
