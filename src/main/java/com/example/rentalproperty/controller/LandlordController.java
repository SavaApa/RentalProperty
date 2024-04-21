package com.example.rentalproperty.controller;

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

    @GetMapping("/get/{id}")
    public Landlord getLandlordById(@PathVariable("id") UUID id){
        return landlordService.getLandlordById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLandlordId(@PathVariable("id") UUID id){
        landlordService.deleteLandlordById(id);
        return ResponseEntity.ok("Landlord with id " + id + " deleted");
    }
}
