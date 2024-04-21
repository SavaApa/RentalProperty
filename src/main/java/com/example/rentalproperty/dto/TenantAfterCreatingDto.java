package com.example.rentalproperty.dto;

import lombok.Data;

@Data
public class TenantAfterCreatingDto {
    private String t_id;
    private String status = "TENANT CREATED";
}
