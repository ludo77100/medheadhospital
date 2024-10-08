package com.medhead.hospitalmicroservice.services.impls;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.services.BedService;
import com.medhead.hospitalmicroservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository ;

    @Autowired
    private BedService bedService ;

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Optional<Hospital> findById(Long hospitalId) {
        return hospitalRepository.findById(hospitalId);
    }

    @Override
    public List<Hospital> findHospitalWithFreeBedsForOneSpeciality(Speciality speciality) {
        List<Bed> freeBedList = bedService.findFreeBedsBySpeciality(speciality);
        List<Hospital> hospitalList = new ArrayList<>();

        for (Bed bed : freeBedList){
           if (!hospitalList.contains(bed.getHospital())){
               hospitalList.add(bed.getHospital());
           }
        }
        return hospitalList;
    }
}
