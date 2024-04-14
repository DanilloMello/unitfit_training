package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;
import java.util.UUID;

public record ExerciseDTO(
        UUID id,
        String name,
        List<SetDTO> sets
) { }