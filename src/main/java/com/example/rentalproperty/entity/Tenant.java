package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.TypeProperty;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tenants")
@NoArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "t_id")
    private UUID id;

    @Column(name = "preference_district")
    private String preferenceDistrict;

    @Column(name = "preference_num_room")
    private int preferenceNumRoom;

    @Column(name = "preference_max_rent")
    private BigDecimal preferenceMaxRent;

    @Column(name = "pet_friendly")
    private boolean petFriendly;

    @Column(name = "parking_required")
    private boolean parkingRequired;

    @Enumerated(EnumType.STRING)
    @Column(name = "preference_property")
    private TypeProperty preferenceProperty;

    @OneToOne(mappedBy = "tenant", fetch = FetchType.LAZY)
    private Application application;

    @OneToMany(mappedBy = "tenant", fetch = FetchType.LAZY)
    private Set<Property> properties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(id, tenant.id) && Objects.equals(preferenceDistrict, tenant.preferenceDistrict) && Objects.equals(preferenceMaxRent, tenant.preferenceMaxRent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preferenceDistrict, preferenceMaxRent);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", preferenceDistrict='" + preferenceDistrict + '\'' +
                ", preferenceNumRoom=" + preferenceNumRoom +
                '}';
    }
}
