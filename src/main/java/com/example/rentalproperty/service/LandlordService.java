package com.example.rentalproperty.service;

import com.example.rentalproperty.entity.Landlord;

import java.util.UUID;

public interface LandlordService {
    Landlord getLandlordById(UUID id);

    void deleteLandlordById(UUID id);
}
