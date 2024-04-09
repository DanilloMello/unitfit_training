package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;
import java.util.UUID;

public record WorkoutCreateRequest(
    String name,
    List<ExerciseDTO> exerciseDTO,
    UUID clientId
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}