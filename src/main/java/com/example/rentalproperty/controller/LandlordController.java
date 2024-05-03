package com.example.rentalproperty.controller;

import com.example.rentalproperty.annotation.ChangeLandlord;
import com.example.rentalproperty.annotation.CreateLandlord;
import com.example.rentalproperty.annotation.DeleteLandlord;
import com.example.rentalproperty.annotation.GetLandlord;
import com.example.rentalproperty.dto.LandlordAfterCreatingDto;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.entity.Landlord;
import com.example.rentalproperty.service.LandlordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/landlord")
public class LandlordController {
    private final LandlordService landlordService;

    @GetLandlord(path = "/get/{id}")
    public Landlord getLandlordById(@PathVariable("id") UUID id){
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

    @ChangeLandlord(path = "/update/{id}/{numProperty}")
    public Landlord updateNumProperty(@PathVariable("id") UUID id, @PathVariable int updateNumProperty){
        return landlordService.updateNumProperty(id, updateNumProperty);
    }

}
