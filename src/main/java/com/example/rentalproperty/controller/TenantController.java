package com.example.rentalproperty.controller;

import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tenant")
public class TenantController {
    private final TenantService tenantService;

    @GetMapping("/get/{id}")
    public Tenant getTenantById(@PathVariable("id") UUID id) {
        return tenantService.getTenantById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTenantByID(@PathVariable("id") UUID id){
        tenantService.deleteTenantById(id);
        return ResponseEntity.ok("Tenant with id " + id + " deleted");
    }

    @PostMapping("/create")
    public TenantAfterCreatingDto createTenant(@RequestBody TenantCreateDto tenantCreateDto){
        return tenantService.createTenant(tenantCreateDto);
    }

    @PutMapping("update/{id}/{updatePreferenceDistrict}")
    public Tenant updatePreferenceDistrict(@PathVariable("id") UUID id, @PathVariable String updatePreferenceDistrict){
        return tenantService.updateTenantPreferenceDistrict(id, updatePreferenceDistrict);
    }
}
