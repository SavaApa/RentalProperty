package com.example.rentalproperty.entity;

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
@Table(name = "user_info")
@NoArgsConstructor
public class UserInfo {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "userInfo")
    private User user;

    @ManyToMany
    @JoinTable(name = "user_role")
    private Set<Role> roles;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(email, userInfo.email) && Objects.equals(password, userInfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
