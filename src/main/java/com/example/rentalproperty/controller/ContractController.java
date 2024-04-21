package com.example.rentalproperty.controller;

<<<<<<< HEAD
=======
import com.example.rentalproperty.annotation.ChangeContract;
import com.example.rentalproperty.annotation.CreateContract;
import com.example.rentalproperty.annotation.DeleteContract;
import com.example.rentalproperty.annotation.GetContract;
>>>>>>> a2a420f (Initial commit)
import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
import com.example.rentalproperty.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> a2a420f (Initial commit)
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;

<<<<<<< HEAD
    @GetMapping("/get/{id}")
=======
    @GetContract(path = "/get/{id}")
>>>>>>> a2a420f (Initial commit)
    public Contract getContractById(@PathVariable("id") UUID id){
        return contractService.getContractById(id);
    }

<<<<<<< HEAD
    @DeleteMapping("/delete/{id}")
=======
    @DeleteContract(path = "/delete/{id}")
>>>>>>> a2a420f (Initial commit)
    public ResponseEntity<String> deleteContractId(@PathVariable("id") UUID id){
        contractService.deleteContractById(id);
        return ResponseEntity.ok("Contract with id " + id + " deleted");
    }

<<<<<<< HEAD
    @PostMapping("/create")
    public ContractAfterCreatingDto createDto(@RequestBody ContractCreateDto contractCreateDto){
        return contractService.createContract(contractCreateDto);
    }
=======
    @CreateContract(path = "/create")
    public ContractAfterCreatingDto createDto(@RequestBody ContractCreateDto contractCreateDto){
        return contractService.createContract(contractCreateDto);
    }

    @ChangeContract(path = "update/{id}/{updateStartDate}")
    public Contract updateStartDate(@PathVariable("id") UUID id, @PathVariable LocalDate updateStartDate){
        return contractService.updateContractStartDate(id, updateStartDate);
    }
>>>>>>> a2a420f (Initial commit)
}
