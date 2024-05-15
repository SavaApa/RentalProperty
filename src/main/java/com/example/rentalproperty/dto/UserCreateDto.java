package com.example.rentalproperty.dto;

import lombok.Data;

@Data
public class UserCreateDto {
    String firstName;
    String lastName;

    String email;
    String password;
}
