package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorkoutJPADatabaseGateway implements WorkoutDatabaseGateway {

    private final WorkoutJPARepository workoutJPARepository;
    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutJPARepository.save(workout);
    }
}