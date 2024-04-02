package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.time.Duration;
public record SetCreateRequest(
     Integer setOrder,
     Integer repetition,
     Duration repetitionByTime,
     String cadence,
     Duration restBetweenExercises,
     Duration restBetweenSets,
     Integer weight,
     Integer rangeOfMotion
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}
