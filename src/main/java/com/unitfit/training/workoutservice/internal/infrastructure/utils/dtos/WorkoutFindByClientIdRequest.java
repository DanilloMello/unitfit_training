package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

public record WorkoutFindByClientIdRequest(
    UUID clientId,
    String name
) implements ValidationRequestDTO {
    @Override
    public Boolean isValid() {
        return true;
    }
}