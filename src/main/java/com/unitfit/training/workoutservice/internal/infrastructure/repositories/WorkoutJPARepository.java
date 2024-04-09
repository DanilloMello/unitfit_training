package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface WorkoutJPARepository extends JpaRepository<Workout, UUID> {
//    TODO: Retornar o resultset customizado para os DTO's
//    Optional<List<WorkoutFindByClientIdResponse>> findByClientIdToDTO(UUID clientId);

    @Query("""
            SELECT new com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse(
                w.name,
                new com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseDTO(
                    e.name,
                    new com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetDTO(
                        e.sets.setOrder,
                        e.sets.repetition,
                        e.sets.repetitionByTime,
                        e.sets.cadence, e.sets.restBetweenExercises, e.sets.restBetweenSets, e.sets.weight,
                        e.sets.rangeOfMotion
                    )
                )
            )
            FROM Workout w
            JOIN FETCH w.exercises e
            JOIN FETCH e.sets
            WHERE w.id = :workoutId
     """)
    WorkoutFindByIdResponse findByIdToDTO(@Param("workoutId") UUID id);

}
