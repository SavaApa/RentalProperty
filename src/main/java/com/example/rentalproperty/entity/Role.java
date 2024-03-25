package com.example.rentalproperty.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


public class Role {

    @Id
    private UUID role;
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_authority")

    private Set<Authority> authorities;
}

