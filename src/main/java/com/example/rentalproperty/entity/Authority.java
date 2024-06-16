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
@Table(name = "authorities")
@NoArgsConstructor
public class Authority {

    @Id
    @Column(name = "aut_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "authority_name")
    private String authorityName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority authority)) return false;
        return Objects.equals(id, authority.id) && Objects.equals(authorityName, authority.authorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorityName);
    }
}
