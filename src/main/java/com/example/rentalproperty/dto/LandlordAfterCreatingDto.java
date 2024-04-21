package com.example.rentalproperty.dto;

import lombok.Data;

@Data
public class LandlordAfterCreatingDto {
    private String l_id;
    private String status = "LANDLORD CREATED";
}
