package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.repositories.SpecialityGroupRepository;
import com.medhead.hospitalmicroservice.repositories.SpecialityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "SUPER_ADMIN")
public class SpecialityGroupControllerIT {

    @Autowired
    MockMvc mockMvc ;

    @Autowired
    private SpecialityGroupRepository specialityGroupRepository;

    @Autowired
    private SpecialityRepository specialityRepository ;

    @BeforeEach
    void setUp() {
        specialityGroupRepository.deleteAll();

        Set<Speciality> specialitySet1 = new HashSet<>();
        Set<Speciality> specialitySet2 = new HashSet<>();

        Set<Bed> bedSet = new HashSet<>();

        Set<Hospital> hospitalSet = new HashSet<>() ;

        SpecialityGroup group1 = new SpecialityGroup(1L, "group1", specialitySet1);
        SpecialityGroup group2 = new SpecialityGroup(2L, "group2", specialitySet2);

        specialityGroupRepository.saveAll(Arrays.asList(group1, group2));

        Speciality speciality1 = new Speciality(1L, "speciality1", group1, bedSet, hospitalSet);
        Speciality speciality2 = new Speciality(2L, "speciality2", group1, bedSet, hospitalSet);
        Speciality speciality3 = new Speciality(3L, "speciality3", group1, bedSet, hospitalSet);
        Speciality speciality4 = new Speciality(4L, "speciality4", group1, bedSet, hospitalSet);
        Speciality speciality5 = new Speciality(5L, "speciality5", group2, bedSet, hospitalSet);
        Speciality speciality6 = new Speciality(6L, "speciality6", group2, bedSet, hospitalSet);
        Speciality speciality7 = new Speciality(7L, "speciality7", group2, bedSet, hospitalSet);

        specialityRepository.saveAll(Arrays.asList(speciality1, speciality2, speciality3, speciality4,speciality5,speciality6,speciality7));

        specialitySet1.add(speciality1);
        specialitySet1.add(speciality2);
        specialitySet1.add(speciality3);
        specialitySet1.add(speciality4);

        specialitySet2.add(speciality5);
        specialitySet2.add(speciality6);
        specialitySet2.add(speciality7);

        specialityGroupRepository.save(group1);
        specialityGroupRepository.save(group2);

    }

    @Test
    public void shouldGetAllSpecialityGroups() throws Exception {
        //Act & Asserts
        mockMvc.perform(get("/specialityGroup/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }
}
