package com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints;

import com.unitfit.training.workoutservice.internal.core.domains.SetsVO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class SetsConstraintsValidator implements ConstraintValidator<SetsValidation, SetsVO> {
    @Override
    public boolean isValid(SetsVO setsVO, ConstraintValidatorContext constraintValidatorContext) {

        if (isNull(setsVO)) {
            return true;
        }

        if (isNull(setsVO.repetition()) &&
                isNull(setsVO.repetitionByTime())) {
            return false;
        }

        return isNull(setsVO.setOrder());
    }

}
