package com.example.rentalproperty.dto;

import lombok.Data;

@Data
public class ContractAfterCreatingDto {
    private String c_id;
    private String status = "CONTRACT CREATED";
}
