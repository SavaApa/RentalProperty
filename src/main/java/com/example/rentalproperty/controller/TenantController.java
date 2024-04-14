package com.example.rentalproperty.controller;

import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tenant")
public class TenantController {
    private final TenantService tenantService;

    @GetMapping("/get/{id}")
    public Tenant getTenantById(@PathVariable("id") UUID id){
        return tenantService.getTenantById(id);
    }
}
