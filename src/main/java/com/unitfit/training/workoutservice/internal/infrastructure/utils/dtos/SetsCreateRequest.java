package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.time.Duration;
public record SetsCreateRequest (
     Integer setOrder,
     Integer repetition,
     Duration repetitionTime,
     String cadence,
     Duration restBetweenExercises,
     Duration restBetweenSets,
     Integer weight,
     Integer rangeOfMotion
) { }
