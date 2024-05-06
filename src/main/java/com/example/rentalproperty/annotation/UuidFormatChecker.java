package com.example.rentalproperty.annotation;

import com.example.rentalproperty.constraint.UuidFormatCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidFormatCheckerConstraint.class)
public @interface UuidFormatChecker {
    String message() default "IT IS NOT UUID FORMAT";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
