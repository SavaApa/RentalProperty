package com.example.rentalproperty.entity;

import com.example.rentalproperty.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }

}
