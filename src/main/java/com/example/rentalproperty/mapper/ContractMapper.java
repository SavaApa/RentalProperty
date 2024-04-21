package com.example.rentalproperty.mapper;

import com.example.rentalproperty.dto.ContractAfterCreatingDto;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContractMapper  {

    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "application.applicationStatus", source = "applicationStatus")
    @Mapping(target = "property.typeProperty", source = "typeProperty")
    @Mapping(target = "tenant.preferenceProperty", source = "preferenceProperty")
    @Mapping(target = "landlord.id", source = "l_id")
    Contract toEntity(ContractCreateDto contractCreateDto);

    @Mapping(target = "c_id", source = "id")
    ContractAfterCreatingDto toDto(Contract contractAfterCreation);
}
