package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record WorkoutDTO(
    String name,
    List<ExerciseDTO> exerciseDTO
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}