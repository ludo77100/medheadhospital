package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bedId ;

    private String bedCode;

    private boolean isFree ;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Bed() {
    }

    public Bed(Long bedId, String bedCode, boolean isFree, Hospital hospital, Speciality speciality) {
        this.bedId = bedId;
        this.bedCode = bedCode;
        this.isFree = isFree;
        this.hospital = hospital;
        this.speciality = speciality;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "bedId=" + bedId +
                ", bedCode='" + bedCode + '\'' +
                ", isFree=" + isFree +
                ", hospital=" + hospital +
                ", speciality=" + speciality +
                '}';
    }
}
