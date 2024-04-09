package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdRequest;

public interface IWorkoutFindByIdUsercase {
    void execute(WorkoutFindByIdRequest request);
}
