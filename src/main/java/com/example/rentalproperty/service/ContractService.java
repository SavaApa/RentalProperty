package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> a2a420f (Initial commit)
import java.util.UUID;

public interface ContractService {
    Contract getContractById(UUID id);

    void deleteContractById(UUID id);

    ContractAfterCreatingDto createContract(ContractCreateDto contractCreateDto);
<<<<<<< HEAD
=======

    Contract updateContractStartDate(UUID id, LocalDate updateStartDate);
>>>>>>> a2a420f (Initial commit)
}
