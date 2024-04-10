package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;

import java.util.UUID;

public interface WorkoutCustomRepository {
    public WorkoutFindByIdResponse findWorkoutById(UUID workoutId);
}
