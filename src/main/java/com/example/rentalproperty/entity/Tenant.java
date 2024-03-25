package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.TypeProperty;

import java.util.UUID;

public class Tenant {
    private UUID id;
    private TypeProperty preferenceProperty;
    private String preferenceDistrict;
    private int preferenceNumRoom;
    private int preferenceMaxRent;
    private boolean petFriendly;
    private boolean parkingRequired;
    private Application application;
}
