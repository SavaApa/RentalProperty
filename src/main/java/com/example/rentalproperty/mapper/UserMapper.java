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

    @Mapping(target = "userInfo.userName", expression = "java(createUserName(userCreateDto))")
    @Mapping(target = "userInfo.password", source = "userCreateDto.password")
    @Mapping(target = "userInfo.email", source = "userCreateDto.email")
    User toEntity(UserCreateDto userCreateDto);

    default String createUserName(UserCreateDto userCreateDto) {
        return userCreateDto.getFirstName().toLowerCase() + "_" + userCreateDto.getLastName().toLowerCase();
    }

    @Mapping(target = "password", source = "userInfo.password")
    @Mapping(target = "userName", source = "userInfo.userName")
    UserAfterCreatingDto toDto(User user);
}


