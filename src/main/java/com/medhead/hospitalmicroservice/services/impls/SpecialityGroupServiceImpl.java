package com.medhead.hospitalmicroservice.services.impls;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.repositories.SpecialityGroupRepository;
import com.medhead.hospitalmicroservice.services.SpecialityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityGroupServiceImpl implements SpecialityGroupService {

    @Autowired
    SpecialityGroupRepository specialityGroupRepository ;

    @Override
    public List<SpecialityGroup> findAll() {
        return specialityGroupRepository.findAll();
    }
}
