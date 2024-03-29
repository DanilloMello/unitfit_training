package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

public record ExerciseCreateRequest (
    String name,
    List<SetsCreateRequest> setsCreateRequests
) { }
