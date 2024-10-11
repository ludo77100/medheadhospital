package com.medhead.hospitalmicroservice.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClosestHospital {

    private double distance ;

    private Long time ;

    private Hospital hospital ;

    private Long bedId ;

    private String bedCode ;

    public ClosestHospital() {
    }

    public ClosestHospital(double distance, Long time, Hospital hospital, Long bedId, String bedCode) {
        this.distance = distance;
        this.time = time;
        this.hospital = hospital;
        this.bedId = bedId;
        this.bedCode = bedCode;
    }

    public double getDistance() {
        return distance;
    }

    //TODO test unitaire
    public void setDistance(double distance) {
        BigDecimal bd = new BigDecimal(distance)
                .setScale(2, RoundingMode.HALF_UP);
        distance = bd.doubleValue();
        this.distance = distance;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
    }

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode;
    }

    @Override
    public String toString() {
        return "ClosestHospital{" +
                "distance=" + distance +
                ", time=" + time +
                ", hospital=" + hospital +
                ", bedId=" + bedId +
                ", bedCode='" + bedCode + '\'' +
                '}';
    }
}
