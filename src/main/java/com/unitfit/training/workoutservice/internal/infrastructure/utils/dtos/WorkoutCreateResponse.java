package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;

import java.util.List;

public record WorkoutCreateResponse(
        String name,
        List<Exercise> exercises
) { }
