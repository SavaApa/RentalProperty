package com.example.rentalproperty.constraint;

import com.example.rentalproperty.annotation.UuidFormatChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;
import java.util.UUID;

public class UuidFormatCheckerConstraint implements ConstraintValidator<UuidFormatChecker, UUID> {

    private final String pattern ="^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$";
    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        String id = uuid.toString();
        return Optional.ofNullable(id)
                .filter(i -> !i.isBlank())
                .map(el -> el.matches(pattern))
                .orElse(false);
    }
}
