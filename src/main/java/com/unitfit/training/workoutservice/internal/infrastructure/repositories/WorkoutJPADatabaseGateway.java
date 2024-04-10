package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.hibernate.query.TupleTransformer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class WorkoutJPADatabaseGateway implements WorkoutDatabaseGateway {

    private final WorkoutJPARepository workoutJPARepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutJPARepository.save(workout);
    }

    @Override
    public WorkoutFindByIdResponse findWorkoutById(UUID workoutId) {
        return workoutJPARepository.findWorkoutById(workoutId);
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