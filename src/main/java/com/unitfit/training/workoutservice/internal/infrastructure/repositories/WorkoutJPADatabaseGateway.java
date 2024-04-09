package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdResponse;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class WorkoutJPADatabaseGateway implements WorkoutDatabaseGateway {

    private final WorkoutJPARepository workoutJPARepository;

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutJPARepository.save(workout);
    }

//    @Override
//    public WorkoutFindByIdResponse findById(UUID id) {
//        return workoutJPARepository.findByIdToDTO(id);
//    }

//    @Override
//    public Optional<List<WorkoutFindByClientIdResponse>> findByClientId(UUID clientId) {
//        return workoutJPARepository.findByClientIdToDTO(clientId);
//    }
}