package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record WorkoutFindByIdResponse(
        String name,
        List<ExerciseDTO> exercises
) { }