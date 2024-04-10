package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
public class ExerciseJPADatabaseGateway implements ExerciseDatabaseGateway {
    private final ExerciseJPARepository exerciseJPARepository;
    @Override
    public void saveAllExercises(List<Exercise> exercises){
        this.exerciseJPARepository.saveAll(exercises);
    }
}
