package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

public record WorkoutFindByClientIdResponse(
        UUID id,
        String name
) { }
