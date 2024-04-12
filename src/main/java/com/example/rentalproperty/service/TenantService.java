package com.example.rentalproperty.service;

import com.example.rentalproperty.entity.Tenant;

import java.util.Optional;
import java.util.UUID;

public interface TenantService {
    Optional<Tenant> getTenantById(UUID id);
}
