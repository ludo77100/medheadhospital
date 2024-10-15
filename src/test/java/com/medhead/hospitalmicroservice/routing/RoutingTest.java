package com.medhead.hospitalmicroservice.routing;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.ClosestHospital;
import com.medhead.hospitalmicroservice.entities.Hospital;
import com.medhead.hospitalmicroservice.entities.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoutingTest {

    @Mock
    private GraphHopper mockHopper;

    private List<Hospital> hospitalList;
    private double userLat;
    private double userLon;
    private Long specialityId;

    private Routing routing;

    @BeforeEach
    public void setUp() {
        routing = new Routing(mockHopper);

        userLat = 51.5074; // Latitude de Londres
        userLon = -0.1278; // Longitude de Londres

        specialityId = 1L;

        hospitalList = new ArrayList<>();
        Hospital hospital = new Hospital();
        hospital.setHospitalId(1L);
        hospital.setHospitalName("Test Hospital");
        hospital.setHospitalLatitude(51.5007); // Latitude fictive
        hospital.setHospitalLongitude(-0.1246); // Longitude fictive

        Bed bed = new Bed();
        bed.setBedId(1L);
        bed.setBedCode("2-22-B1");
        Speciality speciality = new Speciality();
        speciality.setSpecialityId(specialityId);
        bed.setSpeciality(speciality);
        Set<Bed> bedSet = new HashSet<>();
        bedSet.add(bed);
        hospital.setBedSet(bedSet);

        hospitalList.add(hospital);
    }

    @Test
    public void getClosestHospital_ShouldReturnListOfClosestHospitals() {

        GHResponse mockResponse = new GHResponse();
        ResponsePath responsePath = new ResponsePath();
        responsePath.setDistance(1000.0);
        responsePath.setTime(120000); // Temps en millisecondes
        mockResponse.add(responsePath);

        when(mockHopper.route(any(GHRequest.class))).thenReturn(mockResponse);

        List<ClosestHospital> result = routing.getClosestHospital(hospitalList, userLat, userLon, specialityId);

        verify(mockHopper).route(any(GHRequest.class));
        assertEquals(1.0, result.get(0).getDistance(), 0.01);
        assertEquals(2.0, result.get(0).getTime(), 0.01);
    }
}