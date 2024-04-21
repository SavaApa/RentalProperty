package com.example.rentalproperty.controller;

import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
import com.example.rentalproperty.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/get/{id}")
    public Contract getContractById(@PathVariable("id") UUID id){
        return contractService.getContractById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContractId(@PathVariable("id") UUID id){
        contractService.deleteContractById(id);
        return ResponseEntity.ok("Contract with id " + id + " deleted");
    }

    @PostMapping("/create")
    public ContractAfterCreatingDto createDto(@RequestBody ContractCreateDto contractCreateDto){
        return contractService.createContract(contractCreateDto);
    }
}
