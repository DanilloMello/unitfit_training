package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record WorkoutCreateRequest(
    String name,
    List<ExerciseCreateRequest> exercisesCreateRequest
) { }
