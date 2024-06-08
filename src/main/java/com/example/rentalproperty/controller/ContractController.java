package com.example.rentalproperty.controller;


import com.example.rentalproperty.annotation.*;
import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
import com.example.rentalproperty.service.ContractService;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;

    @GetContract(path = "/get/{id}")
    public Contract getContractById(@PathVariable("id") @UuidFormatChecker UUID id, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println("COOKIE " + cookie.getName());
                System.out.println("COOKIE " + cookie.getValue());
            }
        }
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
