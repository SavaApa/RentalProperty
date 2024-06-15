package com.example.rentalproperty.entity;


import com.example.rentalproperty.entity.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<UserInfo> userInfos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_id"))
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

