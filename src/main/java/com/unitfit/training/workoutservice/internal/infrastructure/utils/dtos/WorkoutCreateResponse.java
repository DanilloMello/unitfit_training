package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record WorkoutCreateResponse(
        String name,
        List<ExerciseDTO> exercisesDTO
) { }
