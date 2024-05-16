package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    UserAfterCreatingDto createUser(UserCreateDto userCreateDto);

    void deleteUserById(UUID id);

    User updateUser(UUID id, User user);
}
