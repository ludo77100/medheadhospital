package com.medhead.hospitalmicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpecialityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "speciality_group_id")
    private Long specialityGroupId ;

    private String specialityGroupName ;

    @OneToMany(mappedBy = "specialityGroup", cascade = CascadeType.DETACH, orphanRemoval = true)
    private Set<Speciality> speciality ;
}
