package com.example.rentalproperty.controller;

import com.example.rentalproperty.annotation.ChangeLandlord;
import com.example.rentalproperty.annotation.CreateLandlord;
import com.example.rentalproperty.annotation.DeleteLandlord;
import com.example.rentalproperty.annotation.GetLandlord;
import com.example.rentalproperty.dto.LandlordAfterCreatingDto;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.entity.Landlord;
import com.example.rentalproperty.service.LandlordService;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/landlord")
public class LandlordController {
    private final LandlordService landlordService;

    @GetLandlord(path = "/get/{id}")
    public Landlord getLandlordById(@UuidFormatChecker @PathVariable("id") UUID id){
        return landlordService.getLandlordById(id);
    }

    @DeleteLandlord(path = "/delete/{id}")
    public ResponseEntity<String> deleteLandlordId(@PathVariable("id") UUID id){
        landlordService.deleteLandlordById(id);
        return ResponseEntity.ok("Landlord with id " + id + " deleted");
    }

    @CreateLandlord(path = "/create")
    public LandlordAfterCreatingDto createDto(@RequestBody LandlordCreateDto landlordCreateDto){
        return landlordService.createLandlord(landlordCreateDto);
    }

    @ChangeLandlord(path = "/update/{id}")
    public Landlord updateLandlord(@PathVariable("id") UUID id, @RequestBody Landlord landlord){
        return landlordService.updateLandlord(id, landlord);
    }
}
