package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

public record WorkoutFindByIdRequest(
    UUID id,
    String name
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}