package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;
import java.util.UUID;

public record WorkoutDTO(
    String name,
    List<ExerciseDTO> exerciseDTOS,
    UUID clientId
) { }