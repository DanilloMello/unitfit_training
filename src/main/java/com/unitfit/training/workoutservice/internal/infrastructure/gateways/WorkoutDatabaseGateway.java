package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;

public interface WorkoutDatabaseGateway {
    Workout saveWorkout(Workout workout);
}
