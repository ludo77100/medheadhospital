package com.medhead.hospitalmicroservice.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosestHospitalTest {


    @Test
    public void testSetDistance() {

        // Arrange
        ClosestHospital closestHospital = new ClosestHospital();
        double inputDistance = 123.456;
        double expectedDistance = new BigDecimal(inputDistance)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        // Act
        closestHospital.setDistance(inputDistance);

        // Assert
        assertEquals(expectedDistance, closestHospital.getDistance(), 0.001,
                "La distance doit être arrondie à 2 chiffres après la virgule");
    }

}
