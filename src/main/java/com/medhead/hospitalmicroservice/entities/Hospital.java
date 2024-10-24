package com.medhead.hospitalmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
