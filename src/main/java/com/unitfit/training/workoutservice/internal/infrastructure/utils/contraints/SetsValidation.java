package com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = SetsConstraintsValidator.class)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SetsValidation {
    String message() default "Configuration of Set is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
