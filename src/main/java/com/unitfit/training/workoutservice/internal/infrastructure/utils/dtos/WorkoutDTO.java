package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;
import java.util.UUID;

public record WorkoutDTO(
        UUID id,
        String name,
        List<ExerciseDTO> exercises,
        UUID clientId
) { }