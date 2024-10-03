package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;

import java.util.HashSet;
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
    private Set<Speciality> specialities ;
}
