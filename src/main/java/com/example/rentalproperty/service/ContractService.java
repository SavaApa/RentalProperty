package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;

import java.util.UUID;

public interface ContractService {
    Contract getContractById(UUID id);

    void deleteContractById(UUID id);

    ContractAfterCreatingDto createContract(ContractCreateDto contractCreateDto);

    Contract updateContract(UUID id, Contract contract);
}
