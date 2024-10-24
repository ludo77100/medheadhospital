package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SpecialityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "speciality_group_id")
    private Long specialityGroupId ;

    private String specialityGroupName ;

    @OneToMany(mappedBy = "specialityGroup", cascade = CascadeType.DETACH, orphanRemoval = true)
    private Set<Speciality> speciality ;

    public SpecialityGroup() {
    }

    public SpecialityGroup(Long specialityGroupId, String specialityGroupName, Set<Speciality> speciality) {
        this.specialityGroupId = specialityGroupId;
        this.specialityGroupName = specialityGroupName;
        this.speciality = speciality;
    }

    public Long getSpecialityGroupId() {
        return specialityGroupId;
    }

    public void setSpecialityGroupId(Long specialityGroupId) {
        this.specialityGroupId = specialityGroupId;
    }

    public String getSpecialityGroupName() {
        return specialityGroupName;
    }

    public void setSpecialityGroupName(String specialityGroupName) {
        this.specialityGroupName = specialityGroupName;
    }

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
