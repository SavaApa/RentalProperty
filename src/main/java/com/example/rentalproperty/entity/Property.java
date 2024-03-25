package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.TypeProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class Property {
    private UUID id;
    private TypeProperty typeProperty;
    private String address;
    private int num_rooms;
    private BigDecimal price;
    private String district;
    private boolean parkingSpace;
    private boolean pets;
}
