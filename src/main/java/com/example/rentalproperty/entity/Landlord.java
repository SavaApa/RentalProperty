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
@Table(name = "landlords")
@NoArgsConstructor
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "num_property")
    private int numProperty;

    @Column(name = "rented_out")
    private int rentedOut;

    @Column(name = "num_free")
    private int numFree;

    @OneToMany(mappedBy = "landlord")
    private Set<Application> applications;

    @OneToMany(mappedBy = "landlord")
    private Set<Property> properties;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return numProperty == landlord.numProperty && Objects.equals(id, landlord.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numProperty);
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "id=" + id +
                ", numProperty=" + numProperty +
                '}';
    }
}
