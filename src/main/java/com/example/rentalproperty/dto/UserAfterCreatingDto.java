package com.example.rentalproperty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAfterCreatingDto {
    String userId;
    String status = "User was created";
}
