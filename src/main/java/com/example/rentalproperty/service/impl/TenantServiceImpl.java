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

import java.util.Objects;
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
        }else{
            tenantRepository.deleteById(id);
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
    public Tenant updateTenant(UUID id, Tenant tenant) {
        Tenant getTenant = getTenantById(id);
        if (getTenant != null) {
            if (!Objects.equals(getTenant.getPreferenceDistrict(), tenant.getPreferenceDistrict())) {
                getTenant.setPreferenceDistrict(tenant.getPreferenceDistrict());
                tenantRepository.save(getTenant);
            }
            if (getTenant.getPreferenceNumRoom() != tenant.getPreferenceNumRoom()) {
                getTenant.setPreferenceNumRoom(tenant.getPreferenceNumRoom());
                tenantRepository.save(getTenant);
            }
            if (!Objects.equals(getTenant.getPreferenceMaxRent(), tenant.getPreferenceMaxRent())) {
                getTenant.setPreferenceMaxRent(tenant.getPreferenceMaxRent());
                tenantRepository.save(tenant);
            }
            if (getTenant.isPetFriendly() != tenant.isPetFriendly()) {
                getTenant.setPetFriendly(tenant.isPetFriendly());
                tenantRepository.save(tenant);
            }
            if (getTenant.isParkingRequired() != tenant.isParkingRequired()) {
                getTenant.setParkingRequired(tenant.isParkingRequired());
                tenantRepository.save(tenant);
            }
            if (getTenant.getPreferenceProperty() != tenant.getPreferenceProperty()) {
                getTenant.setPreferenceProperty(tenant.getPreferenceProperty());
                tenantRepository.save(tenant);
            }
        } else {
            throw new IdNotFoundExeption(ErrorMessage.ID_NOT_FOUND);
        }
        return getTenant;
    }
}
