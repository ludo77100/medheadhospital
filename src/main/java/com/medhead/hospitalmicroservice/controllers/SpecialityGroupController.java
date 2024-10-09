package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.services.SpecialityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specialityGroup")
public class SpecialityGroupController {

    @Autowired
    private SpecialityGroupService specialityGroupService ;

    @GetMapping("/all")
    @Secured("ROLE_SUPER_ADMIN")
    public ResponseEntity<List<SpecialityGroup>> findAllSpecialityGroup(){
        List<SpecialityGroup> specialityGroupDTOList = specialityGroupService.findAll();
        return new ResponseEntity<>(specialityGroupDTOList, HttpStatus.OK);
    }

}
