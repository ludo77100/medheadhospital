package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.services.impls.HospitalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HospitalServiceImplTest {

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalServiceImpl hospitalService;

    private Hospital hospital;

    @BeforeEach
    void setUp() {
        hospital = new Hospital();
        hospital.setHospitalId(1L);
        hospital.setHospitalName("Test Hospital");
    }

    @Test
    void findAll_ShouldReturnListOfHospitals() {
        when(hospitalRepository.findAll()).thenReturn(List.of(hospital));

        List<Hospital> result = hospitalService.findAll();

        assertEquals(1, result.size());
        assertEquals("Test Hospital", result.get(0).getHospitalName());
        verify(hospitalRepository, times(1)).findAll();
    }

    @Test
    void findById_ShouldReturnHospital_WhenHospitalExists() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));

        Optional<Hospital> result = hospitalService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Hospital", result.get().getHospitalName());
        verify(hospitalRepository, times(1)).findById(1L);
    }

    @Test
    void findById_ShouldReturnEmptyOptional_WhenHospitalDoesNotExist() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Hospital> result = hospitalService.findById(1L);

        assertTrue(result.isEmpty());
        verify(hospitalRepository, times(1)).findById(1L);
    }

    @Test
    void findHospitalWithFreeBedsForOneSpeciality_ShouldReturnHospitalsWithFreeBeds() {
        when(hospitalRepository.findHospitalsWithFreeBedsBySpeciality(1L)).thenReturn(List.of(hospital));

        List<Hospital> result = hospitalService.findHospitalWithFreeBedsForOneSpeciality(1L);

        assertEquals(1, result.size());
        assertEquals("Test Hospital", result.get(0).getHospitalName());
        verify(hospitalRepository, times(1)).findHospitalsWithFreeBedsBySpeciality(1L);
    }
}