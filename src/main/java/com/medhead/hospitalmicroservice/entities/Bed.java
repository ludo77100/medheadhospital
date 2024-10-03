package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;

@Entity
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bedId ;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Bed() {
    }

    public Bed(Long bedId, Hospital hospital, Speciality speciality) {
        this.bedId = bedId;
        this.hospital = hospital;
        this.speciality = speciality;
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
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
                '}';
    }
}
