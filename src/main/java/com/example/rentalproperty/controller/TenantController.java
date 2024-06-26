package com.example.rentalproperty.controller;

import com.example.rentalproperty.annotation.ChangeTenant;
import com.example.rentalproperty.annotation.CreateTenant;
import com.example.rentalproperty.annotation.DeleteTenant;
import com.example.rentalproperty.annotation.GetTenant;
import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.service.TenantService;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/tenant")
public class TenantController {
    private final TenantService tenantService;

    @PreAuthorize("hasAnyRole('TENANT', 'ADMIN', 'LANDLORD')")
    @GetTenant(path = "/get/{id}")
    public Tenant getTenantById(@UuidFormatChecker @PathVariable("id") UUID id) {
        return tenantService.getTenantById(id);
    }

    @PreAuthorize("hasAnyRole('TENANT', 'ADMIN')")
    @DeleteTenant(path = "/delete/{id}")
    public ResponseEntity<String> deleteTenantByID(@PathVariable("id") UUID id){
        tenantService.deleteTenantById(id);
        return ResponseEntity.ok("Tenant with id " + id + " deleted");
    }

    @PreAuthorize("hasAnyRole('TENANT', 'ADMIN')")
    @CreateTenant(path = "/create")
    public TenantAfterCreatingDto createTenant(@RequestBody TenantCreateDto tenantCreateDto){
        return tenantService.createTenant(tenantCreateDto);
    }

    @PreAuthorize("hasAnyRole('TENANT', 'ADMIN')")
    @ChangeTenant(path = "update/{id}")
    public Tenant updateTenant(@PathVariable("id") UUID id, @RequestBody Tenant tenant){
        return tenantService.updateTenant(id, tenant);
    }
}
