package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;

import java.util.List;

public interface ExerciseDatabaseGateway {
    void saveAllExercises(List<Exercise> exercises);
}
