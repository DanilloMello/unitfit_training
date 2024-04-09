package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdResponse;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutDatabaseGateway {

    Workout saveWorkout(Workout workout);

//    WorkoutFindByIdResponse findById(UUID id);

//    Optional<List<WorkoutFindByClientIdResponse>> findByClientId(UUID clientId);


}
