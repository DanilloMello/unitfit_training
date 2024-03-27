package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExerciseJPADatabaseGateway implements ExerciseDatabaseGateway {

    private final ExerciseJPARepository exerciseJPARepository;
    @Override
    public Exercise saveExercise(Exercise exercise) {
        return exercise;
    }

    @Override
    public List<Exercise> saveAllExercises(List<Exercise> exercises) {
        return exercises;
    }
}
