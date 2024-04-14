package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.repository.TenantRepository;
import com.example.rentalproperty.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public Tenant getTenantById(UUID id) {
        return tenantRepository.getTenantById(id);
    }
}
