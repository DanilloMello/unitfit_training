package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ValidationRequestDTO;

public interface WorkoutInputPortUsecase<T extends ValidationRequestDTO> {
    void execute(T request);
}
