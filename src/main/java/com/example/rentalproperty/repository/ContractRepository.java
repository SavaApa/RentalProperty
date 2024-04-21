package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ContractRepository extends JpaRepository<Contract, UUID> {
    Contract findContractById(UUID id);

    Contract findContractByStartDate(LocalDate startDate);
}
