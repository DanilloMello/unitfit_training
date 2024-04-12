package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;

import java.util.UUID;

public class WorkoutCustomRepositoryImpl implements WorkoutCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public WorkoutFindByIdResponse findWorkoutById(UUID workoutId) {
        return this.em.unwrap(Session.class).createQuery(
                        """ 
                                   SELECT
                                       w.id as workout_id,
                                       w.name as workout_name,
                                       e.id as exercise_id,
                                       e.name as exercise_name,
                                       s.setOrder as set_order,
                                       s.repetition as repetition,
                                       s.repetitionByTime as repetition_by_time,
                                       s.cadence as cadence,
                                       s.restBetweenExercises as rest_between_exercises,
                                       s.restBetweenSets as rest_between_sets,
                                       s.weight as weight,
                                       s.rangeOfMotion as range_of_motion
                                   FROM Workout w
                                   JOIN w.exercises e
                                   JOIN e.sets s
                                   WHERE w.id = :id
                                """, WorkoutFindByIdResponse.class)
                .setParameter("id", workoutId)
                .setTupleTransformer(new WorkoutResponseResultTransformer())
                .getSingleResult();
    }
}
