package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.LandlordAfterCreatingDto;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.entity.Landlord;
import com.example.rentalproperty.exception.LandlordDoesntExistException;
import com.example.rentalproperty.exception.errorMessage.ErrorMessage;
import com.example.rentalproperty.mapper.LandlordMapper;
import com.example.rentalproperty.repository.LandlordRepository;
import com.example.rentalproperty.service.LandlordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LandlordServiceImpl implements LandlordService {

    private final LandlordRepository landlordRepository;
    private final LandlordMapper landlordMapper;


    @Override
    public Landlord getLandlordById(UUID id) {
        Landlord landlord = landlordRepository.findLandlordById(id);
        if (landlord == null) {
            throw new LandlordDoesntExistException(ErrorMessage.NOT_EXIST);
        }
        return landlord;
    }

    @Override
    public void deleteLandlordById(UUID id) {
        if (!landlordRepository.existsById(id)) {
            throw new LandlordDoesntExistException(ErrorMessage.NOT_EXIST);
        }
    }

    @Override
    public LandlordAfterCreatingDto createLandlord(LandlordCreateDto landlordCreateDto) {
        Landlord landlord = landlordRepository.findLandlordByNumProperty(landlordCreateDto.getNumProperty());
        if (landlord != null) {
            throw new RuntimeException("Landlord with preference district already exists");
        }

        Landlord entity = landlordMapper.toEntity(landlordCreateDto);
        Landlord landlordAfterCreation = landlordRepository.save(entity);
        return landlordMapper.toDto(landlordAfterCreation);
    }
}