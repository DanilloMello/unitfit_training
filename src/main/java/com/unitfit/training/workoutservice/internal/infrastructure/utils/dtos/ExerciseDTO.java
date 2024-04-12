package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record ExerciseDTO(
    String name,
    List<SetDTO> sets
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}
