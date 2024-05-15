package com.example.rentalproperty.controller;

import com.example.rentalproperty.annotation.CreateUser;
import com.example.rentalproperty.annotation.GetUser;
import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
import com.example.rentalproperty.service.UserServices;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @GetUser(path = "/getUser/{id}")
    public User getUserById(@PathVariable(name = "id") @UuidFormatChecker UUID id) {
        return userServices.getUserById(id);
    }

    @CreateUser(path = "/create")
    public UserAfterCreatingDto createDto(@RequestBody UserCreateDto userCreateDto){
        return userServices.createUser(userCreateDto);
    }
}
