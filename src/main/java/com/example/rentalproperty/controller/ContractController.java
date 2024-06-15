package com.example.rentalproperty.controller;


import com.example.rentalproperty.annotation.ChangeContract;
import com.example.rentalproperty.annotation.CreateContract;
import com.example.rentalproperty.annotation.DeleteContract;
import com.example.rentalproperty.annotation.GetContract;
import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
import com.example.rentalproperty.service.ContractService;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;

    @GetContract(path = "/get/{id}")
    public Contract getContractById(@PathVariable("id") @UuidFormatChecker UUID id) {
        return contractService.getContractById(id);
    }

    @DeleteContract(path = "/delete/{id}")
    public ResponseEntity<String> deleteContractId(@PathVariable("id") UUID id) {
        contractService.deleteContractById(id);
        return ResponseEntity.ok("Contract with id " + id + " deleted");
    }

    @CreateContract(path = "/create")
    public ContractAfterCreatingDto createDto(@RequestBody ContractCreateDto contractCreateDto) {
        return contractService.createContract(contractCreateDto);
    }

    @ChangeContract(path = "/update/{id}")
    public Contract updateStartDate(@PathVariable("id") UUID id, @RequestBody Contract contract) {
        return contractService.updateContract(id, contract);
    }
}
