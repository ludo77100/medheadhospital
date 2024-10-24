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

}
