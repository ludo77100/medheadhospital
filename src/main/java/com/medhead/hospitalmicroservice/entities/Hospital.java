package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalId ;

    private String hospitalName ;

    private double hospitalLatitude ;

    private double hospitalLongitude ;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bed> bedSet ;

    @ManyToMany
    @JoinTable(
            name = "hospital_specialities",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    @JsonIgnore
    private Set<Speciality> specialities ;

    public Hospital() {
    }

    public Hospital(Long hospitalId, String hospitalName, double hospitalLatitude, double hospitalLongitude, Set<Bed> bedSet, Set<Speciality> specialities) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalLatitude = hospitalLatitude;
        this.hospitalLongitude = hospitalLongitude;
        this.bedSet = bedSet;
        this.specialities = specialities;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public double getHospitalLatitude() {
        return hospitalLatitude;
    }

    public void setHospitalLatitude(double hospitalLatitude) {
        this.hospitalLatitude = hospitalLatitude;
    }

    public double getHospitalLongitude() {
        return hospitalLongitude;
    }

    public void setHospitalLongitude(double hospitalLongitude) {
        this.hospitalLongitude = hospitalLongitude;
    }

    public Set<Bed> getBedSet() {
        return bedSet;
    }

    public void setBedSet(Set<Bed> bedSet) {
        this.bedSet = bedSet;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalLatitude=" + hospitalLatitude +
                ", hospitalLongitude=" + hospitalLongitude +
                '}';
    }
}
