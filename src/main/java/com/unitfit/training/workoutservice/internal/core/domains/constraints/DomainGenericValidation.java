package com.unitfit.training.workoutservice.internal.core.domains.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DomainGenericValidation implements ConstraintValidator<DomainValidated, DomainValidation> {

    @Override
    public boolean isValid(DomainValidation domain, ConstraintValidatorContext constraintValidatorContext) {
        return domain.isValid();
    }


}
