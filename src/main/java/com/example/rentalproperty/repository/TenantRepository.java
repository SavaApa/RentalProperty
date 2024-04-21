package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    Tenant findTenantById(UUID id);

    Tenant findTenantByPreferenceDistrict(String preferenceDistrict);
}
