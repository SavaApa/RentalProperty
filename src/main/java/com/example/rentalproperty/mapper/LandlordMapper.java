package com.example.rentalproperty.mapper;

import com.example.rentalproperty.dto.LandlordAfterCreatingDto;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Landlord;
import com.example.rentalproperty.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface LandlordMapper {

    @Mapping(target = "numProperty", source = "numProperty")
    @Mapping(target = "rentedOut", source = "rentedOut")
    @Mapping(target = "numFree", source = "numFree")
    Landlord toEntity(LandlordCreateDto landlordCreateDto);

    @Mapping(target = "l_id", source = "id")
    LandlordAfterCreatingDto toDto(Landlord landlordAfterCreation);

}
