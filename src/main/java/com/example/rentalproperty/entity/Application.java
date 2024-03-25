package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.ApplicationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Application {

    @Id
    private UUID id;
    private Property property;
    private Tenant tenant;
    private LocalDate beganDate;
    private ApplicationStatus applicationStatus;
}
