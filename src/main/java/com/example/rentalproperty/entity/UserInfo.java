package com.example.rentalproperty.entity;

import java.util.Set;
import java.util.UUID;

public class UserInfo {
    private UUID id;
    private String email;
    private Set<Role> roles;
    private String password;
    private User user;
}
