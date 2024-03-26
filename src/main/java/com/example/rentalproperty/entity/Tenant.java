package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.TypeProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tenants")
@NoArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "preference_property")
    private TypeProperty preferenceProperty;


    private String preferenceDistrict;
    private int preferenceNumRoom;
    private int preferenceMaxRent;
    private boolean petFriendly;
    private boolean parkingRequired;

    @OneToOne(mappedBy = "tenant")
    private Application application;

    @OneToMany(mappedBy = "tenant")
    private Set<Property> properties;
}
