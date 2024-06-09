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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/landlord")
public class LandlordController {
    private final LandlordService landlordService;

    @PreAuthorize("hasAnyRole('LANDLORD', 'TENANT', 'USER')")
    @GetLandlord(path = "/get/{id}")
    public Landlord getLandlordById(@UuidFormatChecker @PathVariable("id") UUID id){
        return landlordService.getLandlordById(id);
    }

    @PreAuthorize("hasAnyRole('LANDLORD', 'TENANT', 'USER')")
    @DeleteLandlord(path = "/delete/{id}")
    public ResponseEntity<String> deleteLandlordId(@PathVariable("id") UUID id){
        landlordService.deleteLandlordById(id);
        return ResponseEntity.ok("Landlord with id " + id + " deleted");
    }

    @PreAuthorize("hasAnyRole('LANDLORD', 'TENANT', 'USER')")
    @CreateLandlord(path = "/create")
    public LandlordAfterCreatingDto createDto(@RequestBody LandlordCreateDto landlordCreateDto){
        return landlordService.createLandlord(landlordCreateDto);
    }

    @PreAuthorize("hasAnyRole('LANDLORD', 'TENANT', 'USER')")
    @ChangeLandlord(path = "/update/{id}")
    public Landlord updateLandlord(@PathVariable("id") UUID id, @RequestBody Landlord landlord){
        return landlordService.updateLandlord(id, landlord);
    }
}
