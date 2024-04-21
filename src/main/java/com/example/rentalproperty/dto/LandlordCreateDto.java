package com.example.rentalproperty.dto;


import lombok.Value;

@Value
public class LandlordCreateDto {
    int numProperty;
    int rentedOut;
    int numFree;
}
