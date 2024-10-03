package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;

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


}
