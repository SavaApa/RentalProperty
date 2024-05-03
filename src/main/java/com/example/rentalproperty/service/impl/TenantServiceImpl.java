package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.exception.IdNotFoundExeption;
import com.example.rentalproperty.exception.TenantDoesntExistException;
import com.example.rentalproperty.exception.errorMessage.ErrorMessage;
import com.example.rentalproperty.mapper.TenantMapper;
import com.example.rentalproperty.repository.TenantRepository;
import com.example.rentalproperty.service.TenantService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Override
    public Tenant getTenantById(UUID id) {
        Tenant tenant = tenantRepository.findTenantById(id);
        if (tenant == null) {
            throw new TenantDoesntExistException(ErrorMessage.NOT_EXIST);
        }
        return tenant;
    }

    @Override
    @Transactional
    public void deleteTenantById(UUID id) {
        if (!tenantRepository.existsById(id)) {
            throw new TenantDoesntExistException(ErrorMessage.NOT_EXIST);
        }
    }

    @Override
    @Transactional
    public TenantAfterCreatingDto createTenant(TenantCreateDto tenantCreateDto) {
        Tenant tenant = tenantRepository.findTenantByPreferenceDistrict(tenantCreateDto.getPreferenceDistrict());
        if (tenant != null) {
            throw new RuntimeException("Tenant with preference district already exists");
        }


        Tenant entity = tenantMapper.toEntity(tenantCreateDto);
        Tenant tenantAfterCreation = tenantRepository.save(entity);
        return tenantMapper.toDto(tenantAfterCreation);
    }

    @Override
    @Transactional
    public Tenant updateTenantPreferenceDistrict(UUID id, String updatePreferenceDistrict) {
        Tenant tenant = tenantRepository.findTenantById(id);
        if (tenant != null) {
            tenant.setPreferenceDistrict(updatePreferenceDistrict);
            tenantRepository.save(tenant);
            return tenant;
        } else {
            throw new IdNotFoundExeption(ErrorMessage.ID_NOT_FOUND);
        }
    }
}
