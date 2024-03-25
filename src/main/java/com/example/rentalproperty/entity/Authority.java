package com.example.rentalproperty.entity;

import java.util.Set;
import java.util.UUID;

public class Authority {
    private UUID id;
    private String authorityName;
    private Set<Role> roles;
}
