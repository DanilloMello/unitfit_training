package com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints;

import com.unitfit.training.workoutservice.internal.core.domains.SetConfiguration;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class SetConstraintsValidator implements ConstraintValidator<SetValidation, SetConfiguration> {
    @Override
    public boolean isValid(SetConfiguration setConfiguration, ConstraintValidatorContext constraintValidatorContext) {

        if (isNull(setConfiguration)) {
            return true;
        }

        if (isNull(setConfiguration.getRepetition()) &&
                isNull(setConfiguration.getRepetitionTime())) {
            return false;
        }

        return isNull(setConfiguration.getSetOrder());
    }

}
