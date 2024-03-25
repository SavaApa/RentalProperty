package com.example.rentalproperty.entity;

import java.util.Set;
import java.util.UUID;

public class Role {
    private UUID role;
    private String roleName;
    private Set<Authority> authorities;
}
