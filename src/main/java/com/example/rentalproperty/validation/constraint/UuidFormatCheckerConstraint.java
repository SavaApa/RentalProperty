package com.example.rentalproperty.validation.constraint;

import com.example.rentalproperty.validation.annotation.UuidFormatChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;
import java.util.UUID;

public class UuidFormatCheckerConstraint implements ConstraintValidator<UuidFormatChecker, UUID> {

    private static final String UUID_INPUT ="^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Override
    public void initialize(UuidFormatChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        String id = uuid.toString();
        return Optional.ofNullable(id)
                .filter(el -> !el.isBlank())
                .map(el -> el.matches(UUID_INPUT))
                .orElse(false);
    }
}
