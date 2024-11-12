package com.medhead.hospitalmicroservice.entities;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClosestHospital {

    private double distance ;

    private Long time ;

    private Hospital hospital ;

    private Long bedId ;

    private String bedCode ;

    public void setDistance(double distance) {
        BigDecimal bd = BigDecimal.valueOf(distance)
                .setScale(2, RoundingMode.HALF_UP);
        distance = bd.doubleValue();
        this.distance = distance;
    }
}
