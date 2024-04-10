package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;

import java.util.UUID;

public interface WorkoutDatabaseGateway {

    Workout saveWorkout(Workout workout);

    WorkoutFindByIdResponse findWorkoutById(UUID id);

}
