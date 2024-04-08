package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    Tenant getTenantById(UUID id);
}
