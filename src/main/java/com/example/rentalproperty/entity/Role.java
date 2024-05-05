package com.example.rentalproperty.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID role;

    @Column(name = "role_name")
    private String roleName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "role_authority")
    private Set<Authority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role) && Objects.equals(roleName, role1.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, roleName);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role=" + role +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

