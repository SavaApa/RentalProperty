package com.example.rentalproperty.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Contract {
    private UUID id;
    private Property property;
    private Tenant tenant;
    private Landlord landlord;
    private LocalDate startDate;
    private LocalDate endDate;
}
