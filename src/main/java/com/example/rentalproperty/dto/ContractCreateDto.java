package com.example.rentalproperty.dto;

import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ContractCreateDto {
    LocalDate startDate;
    LocalDate endDate;
    String applicationStatus;
    String typeProperty;
    String preferenceProperty;
    UUID l_id;


}
