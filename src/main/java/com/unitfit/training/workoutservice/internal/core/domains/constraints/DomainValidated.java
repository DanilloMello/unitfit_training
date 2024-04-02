package com.unitfit.training.workoutservice.internal.core.domains.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DomainGenericValidation.class)
@Documented
public @interface DomainValidated {
    String message() default "Domain is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
