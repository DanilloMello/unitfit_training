package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.Set;

public record WorkoutFindByIdResponse(
        String name,
        Set<ExerciseDTO> exercises
) { }