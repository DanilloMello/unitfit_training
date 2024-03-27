package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;

public interface WorkoutInputPort {
    void execute(WorkoutCreateRequest request);
}
