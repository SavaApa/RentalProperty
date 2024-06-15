package com.example.rentalproperty.mapper;

import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "firstName", source = "userCreateDto.firstName")
    @Mapping(target = "lastName", source = "userCreateDto.lastName")
    @Mapping(target = "userInfo.userName", source = "userCreateDto.userName")
    @Mapping(target = "userInfo.password", source = "userCreateDto.password")
    @Mapping(target = "userInfo.email", source = "userCreateDto.email")
    @Mapping(target = "id", ignore = true)
    User toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "userId", source = "id")
    UserAfterCreatingDto toDto(User user);
}


