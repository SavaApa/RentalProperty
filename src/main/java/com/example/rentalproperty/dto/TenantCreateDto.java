package com.example.rentalproperty.dto;

import com.example.rentalproperty.entity.enums.TypeProperty;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class TenantCreateDto {
    String preferenceDistrict;
    int preferenceNumRoom;
    BigDecimal preferenceMaxRent;
    TypeProperty preferenceProperty;
}
