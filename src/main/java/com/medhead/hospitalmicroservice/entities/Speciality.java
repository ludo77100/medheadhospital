package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId ;

    private String specialityName ;

    @ManyToOne
    @JoinColumn(name = "speciality_group_id")
    @JsonIgnore
    private SpecialityGroup specialityGroup ;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Bed> beds ;

    @ManyToMany(mappedBy = "specialities")
    @JsonIgnore
    private Set<Hospital> hospitals ;

    public Speciality() {
    }

    public Speciality(Long specialityId, String specialityName, SpecialityGroup specialityGroup, Set<Bed> beds, Set<Hospital> hospitals) {
        this.specialityId = specialityId;
        this.specialityName = specialityName;
        this.specialityGroup = specialityGroup;
        this.beds = beds;
        this.hospitals = hospitals;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public SpecialityGroup getSpecialityGroup() {
        return specialityGroup;
    }

    public void setSpecialityGroup(SpecialityGroup specialityGroup) {
        this.specialityGroup = specialityGroup;
    }

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public Set<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityId=" + specialityId +
                ", specialityName='" + specialityName + '\'' +
                ", specialityGroup=" + specialityGroup +
                ", beds=" + beds +
                ", hospitals=" + hospitals +
                '}';
    }
}
