package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

import static java.util.Objects.isNull;

public record WorkoutFindByIdRequest(
    UUID id,
    String name
)
{
    public WorkoutFindByIdRequest {
        if (isNull(id)) {
            throw new IllegalArgumentException("ID can't be null");
        }
    }
}