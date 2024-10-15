package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.repositories.BedRepository;
import com.medhead.hospitalmicroservice.repositories.HospitalRepository;
import com.medhead.hospitalmicroservice.repositories.SpecialityRepository;
import com.medhead.hospitalmicroservice.services.impls.BedServiceImpl;
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
public class BedServiceImplTest {

    @Mock
    private BedRepository bedRepository;

    @Mock
    private HospitalRepository hospitalRepository;

    @Mock
    private SpecialityRepository specialityRepository;

    @InjectMocks
    private BedServiceImpl bedService;

    private Hospital hospital;
    private Speciality speciality;
    private Bed bed;

    @BeforeEach
    void setUp() {
        hospital = new Hospital();
        hospital.setHospitalId(1L);

        speciality = new Speciality();
        speciality.setSpecialityId(1L);

        bed = new Bed();
        bed.setBedId(1L);
        bed.setHospital(hospital);
        bed.setSpeciality(speciality);
        bed.setFree(true);
        bed.setBedCode("2-22-B1");
    }

    @Test
    void findFreeBedsBySpecialityId_ShouldReturnListOfFreeBeds() {
        List<Bed> beds = List.of(bed);
        when(bedRepository.findFreeBedsBySpecialityId(1L)).thenReturn(beds);

        List<Bed> result = bedService.findFreeBedsBySpecialityId(1L);

        assertEquals(1, result.size());
        assertTrue(result.get(0).isFree());
        verify(bedRepository, times(1)).findFreeBedsBySpecialityId(1L);
    }

    @Test
    void changeBedState_ShouldToggleFreeStateAndReturnUpdatedBed() {
        when(bedRepository.findById(1L)).thenReturn(Optional.of(bed));

        Optional<Bed> result = bedService.changeBedState(1L);

        assertTrue(result.isPresent());
        assertFalse(result.get().isFree());
        verify(bedRepository, times(1)).findById(1L);
        verify(bedRepository, times(1)).save(bed);
    }

    @Test
    void bulkSave_ShouldCreateAndSaveMultipleBeds() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));
        when(specialityRepository.findById(1L)).thenReturn(Optional.of(speciality));
        when(bedRepository.findTopByOrderByBedIdDesc()).thenReturn(Optional.of(bed));

        List<Bed> result = bedService.bulkSave(1L, 1L, 2);

        assertEquals(2, result.size());
        assertEquals("1-1-B2", result.get(0).getBedCode());
        assertEquals("1-1-B3", result.get(1).getBedCode());
        verify(hospitalRepository, times(1)).findById(1L);
        verify(specialityRepository, times(1)).findById(1L);
        verify(bedRepository, times(2)).save(any(Bed.class));
    }

    @Test
    void bulkSave_ShouldThrowException_WhenHospitalNotFound() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bedService.bulkSave(1L, 1L, 2);
        });

        assertEquals("Hospital not found with ID: 1", exception.getMessage());
        verify(hospitalRepository, times(1)).findById(1L);
    }

    @Test
    void bulkSave_ShouldThrowException_WhenSpecialityNotFound() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));
        when(specialityRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bedService.bulkSave(1L, 1L, 2);
        });

        assertEquals("Speciality not found with ID: 1", exception.getMessage());
        verify(specialityRepository, times(1)).findById(1L);
    }

    @Test
    void extractInt_ShouldReturnParsedInteger() {
        int result = bedService.extractInt("1-1-B123");
        assertEquals(123, result);
    }

    @Test
    void extractInt_ShouldThrowException_WhenFormatIsInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bedService.extractInt("invalid-code");
        });

        assertEquals("Le format de chaîne n'est pas valide ou il n'y a pas de caractère après 'B'.", exception.getMessage());
    }
}