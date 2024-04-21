package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.LandlordAfterCreatingDto;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.entity.Landlord;

import java.util.UUID;

public interface LandlordService {
    Landlord getLandlordById(UUID id);

    void deleteLandlordById(UUID id);

    LandlordAfterCreatingDto createLandlord(LandlordCreateDto landlordCreateDto);

    Landlord updateLandlordNumProperty(UUID id, int updateNumProperty);
}
