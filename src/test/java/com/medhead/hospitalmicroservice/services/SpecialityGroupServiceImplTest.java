package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.SpecialityGroup;
import com.medhead.hospitalmicroservice.repositories.SpecialityGroupRepository;
import com.medhead.hospitalmicroservice.services.impls.SpecialityGroupServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialityGroupServiceImplTest {

    @Mock
    private SpecialityGroupRepository specialityGroupRepository;

    @InjectMocks
    private SpecialityGroupServiceImpl specialityGroupService;

    private SpecialityGroup specialityGroup;

    @BeforeEach
    void setUp() {
        specialityGroup = new SpecialityGroup();
        specialityGroup.setSpecialityGroupId(1L);
        specialityGroup.setSpecialityGroupName("Cardiology");
    }

    @Test
    void findAll_ShouldReturnListOfSpecialityGroups() {
        when(specialityGroupRepository.findAll()).thenReturn(List.of(specialityGroup));

        List<SpecialityGroup> result = specialityGroupService.findAll();

        assertEquals(1, result.size());
        assertEquals("Cardiology", result.get(0).getSpecialityGroupName());
        verify(specialityGroupRepository, times(1)).findAll();
    }
}