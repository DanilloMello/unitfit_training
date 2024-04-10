package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.hibernate.query.TupleTransformer;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class WorkoutCustomRepositoryImpl implements WorkoutCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public WorkoutFindByIdResponse findWorkoutById(UUID workoutId) {
        return (WorkoutFindByIdResponse) this.em.unwrap(Query.class).getSession().createQuery(
                        """ 
                                   SELECT
                                       w.name as workoutName,
                                       e.name as exerciseName,
                                       s.setOrder,
                                       s.repetition,
                                       s.repetitionByTime,
                                       s.cadence,
                                       s.restBetweenExercises,
                                       s.restBetweenSets,
                                       s.weight,
                                       s.rangeOfMotion
                                   FROM Workout w
                                   JOIN Exercise e ON e.workout_id = w.id
                                   JOIN Set s ON s.exercise_id = e.id
                                   WHERE w.id = :id
                                """, WorkoutFindByIdResponse.class)
                .setParameter("id", workoutId)
                .setTupleTransformer((TupleTransformer<?>) (tuples, aliases) ->
                        new WorkoutFindByIdResponse(
                                (String) tuples[0],
                                List.of(
                                        new ExerciseDTO(
                                                (String) tuples[1],
                                                List.of(
                                                        new SetDTO(
                                                                (Integer) tuples[2],
                                                                (Integer) tuples[3],
                                                                (Duration) tuples[4],
                                                                (String) tuples[5],
                                                                (Duration) tuples[6],
                                                                (Duration) tuples[7],
                                                                (Integer) tuples[8],
                                                                (Integer) tuples[9]
                                                        )
                                                )
                                        )
                                )
                        )
                ).getSingleResult();
    }
}
