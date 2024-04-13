package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

import static java.util.Objects.isNull;

public record WorkoutFindByClientIdRequest(
    UUID clientId,
    String name
) {
    public WorkoutFindByClientIdRequest{
        if (isNull(clientId)) {
            throw new IllegalArgumentException("Client id can't be null");
        }
    }
}