package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdRequest;

public interface IWorkoutFindByClientIdUsercase {
    void execute(WorkoutFindByClientIdRequest request);
}
