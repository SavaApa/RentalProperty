package com.example.rentalproperty.controller;

import com.example.rentalproperty.annotation.ChangeUser;
import com.example.rentalproperty.annotation.CreateUser;
import com.example.rentalproperty.annotation.DeleteUser;
import com.example.rentalproperty.annotation.GetUser;
import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
import com.example.rentalproperty.service.UserService;
import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN', 'LANDLORD', 'TENANT')")
    @GetUser(path = "/get/{id}")
    public User getUserById(@PathVariable(name = "id") @UuidFormatChecker UUID id) {
        return userService.getUserById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'LANDLORD', 'TENANT')")
    @DeleteUser(path = "/delete/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable("id") UUID id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User with id " + id + " deleted");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'LANDLORD', 'TENANT')")
    @CreateUser(path = "/create")
    public UserAfterCreatingDto createDto(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'LANDLORD', 'TENANT')")
    @ChangeUser(path = "update/{id}")
    public User updateTenant(@PathVariable("id") UUID id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
