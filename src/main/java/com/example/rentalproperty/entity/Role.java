package com.example.rentalproperty.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID role;
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_authority")

    private Set<Authority> authorities;
}

