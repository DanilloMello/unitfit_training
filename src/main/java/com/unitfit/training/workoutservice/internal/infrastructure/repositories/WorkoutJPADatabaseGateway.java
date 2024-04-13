package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class WorkoutJPADatabaseGateway implements WorkoutDatabaseGateway {

    private final WorkoutJPARepository workoutJPARepository;

    @Override
    public WorkoutFindByIdResponse findWorkoutById(UUID workoutId) {
        return workoutJPARepository.findWorkoutById(workoutId);
    }
    @Override
    public void saveAllWorkouts(List<Workout> workouts) {
        workoutJPARepository.saveAll(workouts);
    }

}