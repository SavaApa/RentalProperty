package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, UUID> {
    Landlord findLandlordById(UUID id);
}

