package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;

import java.util.UUID;

public interface TenantService {
    Tenant getTenantById(UUID id);

    void deleteTenantById(UUID id);

    TenantAfterCreatingDto createTenant(TenantCreateDto tenantCreateDto);

    Tenant updateTenant(UUID id, Tenant tenant);
}
