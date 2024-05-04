package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.TypeProperty;
import com.example.rentalproperty.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "properties")
@NoArgsConstructor

public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "prop_id")
    private UUID id;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type_property")
    @Enumerated(EnumType.STRING)
    private TypeProperty typeProperty;

    @Column(name = "num_rooms")
    private int numRooms;

    @Column(name = "district")
    private String district;

    @Column(name = "parking_space")
    private boolean parkingSpace;

    @Column(name = "pets")
    private boolean pets;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id) && Objects.equals(address, property.address) && Objects.equals(price, property.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, price);
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
