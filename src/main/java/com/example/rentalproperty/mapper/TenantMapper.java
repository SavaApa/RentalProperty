package com.example.rentalproperty.mapper;

import com.example.rentalproperty.dto.TenantAfterCreatingDto;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TenantMapper {


    @Mapping(target = "preferenceDistrict", source = "preferenceDistrict")
    @Mapping(target = "preferenceNumRoom", source = "preferenceNumRoom")
    @Mapping(target = "preferenceMaxRent", source = "preferenceMaxRent")
    @Mapping(target = "preferenceProperty", source = "preferenceProperty")

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "petFriendly", ignore = true)
    @Mapping(target = "parkingRequired", ignore = true)
    Tenant toEntity(TenantCreateDto tenantCreateDto);

    @Mapping(target = "t_id", source = "id")
    TenantAfterCreatingDto toDto(Tenant tenantAfterCreation);
}
