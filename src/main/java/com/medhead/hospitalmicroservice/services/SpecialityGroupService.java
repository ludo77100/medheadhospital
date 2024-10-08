package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;

import java.util.List;

public interface SpecialityGroupService {
     List<SpecialityGroup> findAll();
}
