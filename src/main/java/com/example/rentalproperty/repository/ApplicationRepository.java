package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByTenantId(UUID tenantId);
}
