package com.example.rentalproperty.validation.annotation;

import com.example.rentalproperty.validation.constraint.UuidFormatCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Constraint(validatedBy = UuidFormatCheckerConstraint.class)
public @interface UuidFormatChecker {
    String message() default "IT is not UUID format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
