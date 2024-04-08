package com.example.rentalproperty.service;

import com.example.rentalproperty.entity.Tenant;

import java.util.UUID;

public interface TenantService {
    Tenant getTenantById(UUID id);
}
