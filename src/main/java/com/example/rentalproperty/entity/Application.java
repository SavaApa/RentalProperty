package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.ApplicationStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private UUID id;
    private Property property;
    private Tenant tenant;
    private LocalDate beganDate;
    private ApplicationStatus applicationStatus;
}
