package com.example.rentalproperty.entity;

import java.util.Set;
import java.util.UUID;

public class Landlord {
    private UUID id;
    private Set<Application> applications;
    private Set<Property> properties;
}
