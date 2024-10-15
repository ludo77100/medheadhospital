package com.medhead.hospitalmicroservice.controllers;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.repositories.BedRepository;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.repositories.SpecialityGroupRepository;
import com.medhead.hospitalmicroservice.repositories.SpecialityRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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

    @Autowired
    private BedRepository bedRepository ;

    @Autowired
    private HospitalRepository hospitalRepository ;

    @BeforeEach
    void setUp() {
        specialityGroupRepository.deleteAll();

        Set<Speciality> specialitySet1 = new HashSet<>();
        Set<Speciality> specialitySet2 = new HashSet<>();

        Set<Hospital> hospitalSet1 = new HashSet<>() ;
        Set<Hospital> hospitalSet2 = new HashSet<>() ;

        Set<Bed> bedSet1 = new HashSet<>();
        Set<Bed> bedSet2 = new HashSet<>();


        SpecialityGroup group1 = new SpecialityGroup(1L, "group1", specialitySet1);
        SpecialityGroup group2 = new SpecialityGroup(2L, "group2", specialitySet2);

        specialityGroupRepository.saveAll(Arrays.asList(group1, group2));

        Speciality speciality1 = new Speciality(1L, "speciality1", group1, bedSet1, hospitalSet1);
        Speciality speciality2 = new Speciality(2L, "speciality2", group1, bedSet1, hospitalSet1);
        Speciality speciality3 = new Speciality(3L, "speciality3", group1, bedSet1, hospitalSet1);
        Speciality speciality4 = new Speciality(4L, "speciality4", group1, bedSet1, hospitalSet1);
        Speciality speciality5 = new Speciality(5L, "speciality5", group2, bedSet2, hospitalSet2);
        Speciality speciality6 = new Speciality(6L, "speciality6", group2, bedSet2, hospitalSet2);
        Speciality speciality7 = new Speciality(7L, "speciality7", group2, bedSet2, hospitalSet2);

        specialityRepository.saveAll(Arrays.asList(speciality1, speciality2, speciality3, speciality4,speciality5,speciality6,speciality7));

        specialitySet1.add(speciality1);
        specialitySet1.add(speciality2);
        specialitySet1.add(speciality3);
        specialitySet1.add(speciality4);

        specialitySet2.add(speciality5);
        specialitySet2.add(speciality6);
        specialitySet2.add(speciality7);

        Hospital hospital1 = new Hospital(1L, "hospital1", 51.5007, -0.1246, bedSet1, specialitySet1);
        Hospital hospital2 = new Hospital(2L, "hospital2", 51.5007, -0.1246, bedSet2, specialitySet2);

        hospitalRepository.save(hospital1);
        hospitalRepository.save(hospital2);

        Bed bed1 = new Bed(1L, "1-1-B1", true, hospital1, speciality1);
        bedRepository.save(bed1);
        Bed bed2 = new Bed(2L, "2-2-B2", true, hospital2, speciality2);
        bedRepository.save(bed2);
        Bed bed3 = new Bed(3L, "1-3-B3", true, hospital1, speciality3);
        bedRepository.save(bed3);
        Bed bed4 = new Bed(4L, "2-4-B4", true, hospital2, speciality4);
        bedRepository.save(bed4);
        Bed bed5 = new Bed(5L, "1-5-B5", true, hospital1, speciality5);
        bedRepository.save(bed5);
        Bed bed6 = new Bed(6L, "2-6-B6", true, hospital2, speciality6);
        bedRepository.save(bed6);
        Bed bed7 = new Bed(7L, "1-7-B7", true, hospital1, speciality7);
        bedRepository.save(bed7);

        bedSet1.addAll(Arrays.asList(bed1, bed3, bed5, bed7));
        bedSet2.addAll(Arrays.asList(bed2, bed4, bed6));

        specialityGroupRepository.save(group1);
        specialityGroupRepository.save(group2);

    }

    @Test
    public void shouldGetAllSpecialityGroupsWithChildren() throws Exception {
        //Act & Asserts
        ResultActions result = mockMvc.perform(get("/specialityGroup/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].specialityGroupName").value("group1"))
                .andExpect(jsonPath("$[0].speciality.size()").value(4))
                .andExpect(jsonPath("$[0].speciality[*].specialityName")
                        .value(Matchers.containsInAnyOrder("speciality1", "speciality2", "speciality3", "speciality4")))
                .andExpect(jsonPath("$[1].specialityGroupName").value("group2"))
                .andExpect(jsonPath("$[1].speciality.size()").value(3))
                .andExpect(jsonPath("$[1].speciality[*].specialityName")
                        .value(Matchers.containsInAnyOrder("speciality5", "speciality6", "speciality7")));

        String jsonResponse = result.andReturn().getResponse().getContentAsString();
        System.out.println("JSON Response: " + jsonResponse);
    }
}
