package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;

import java.util.List;
import java.util.UUID;

public interface WorkoutDatabaseGateway {

    void saveAllWorkouts(List<Workout> workouts);

    WorkoutFindByIdResponse findWorkoutById(UUID id);

}
