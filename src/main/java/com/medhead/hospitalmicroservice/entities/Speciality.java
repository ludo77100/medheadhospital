package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId ;

    private String specialityName ;

    @ManyToOne
    @JoinColumn(name = "speciality_group_id")
    private SpecialityGroup specialityGroup ;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bed> beds ;

    @ManyToMany(mappedBy = "specialities")
    private Set<Hospital> hospitals ;

}
