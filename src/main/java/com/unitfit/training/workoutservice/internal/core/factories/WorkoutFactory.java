package com.unitfit.training.workoutservice.internal.core.factories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.core.domains.Set;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
@Validated
public class WorkoutFactory implements DomainFactory<WorkoutCreateRequest> {
    private final WorkoutDatabaseGateway database;
    private final ExerciseDatabaseGateway exerciseDatabase;
    @Override
    public Record create(WorkoutCreateRequest request) {
        if (nonNull(request)) {
            return workoutRequestToWorkout(request);
        } else {
            throw new NullPointerException();
        }
    }
    private Record workoutRequestToWorkout(WorkoutCreateRequest request) {
        Workout workout = this.database.saveWorkout(new Workout(request.name()));
        List<Exercise> exercises = exercisesRequestToExercises(request.exercisesRequest(), workout);
        exercises = this.exerciseDatabase.saveAllExercises(exercises);
        return new WorkoutCreateResponse(workout.getName(), exercises);
    }
    private List<Exercise> exercisesRequestToExercises(List<ExerciseCreateRequest> request, Workout workout) {
        return request
                .stream()
                .map(ecr ->
                        new Exercise(
                                ecr.name(),
                                setsRequestToSets(ecr.setsRequest()),
                                workout
                        ))
                .toList();
    }

    private List<Set> setsRequestToSets(List<SetCreateRequest> request) {
        AtomicInteger sets = new AtomicInteger(0);
        return request
                .stream()
                .map(scr ->
                     new Set(
                            sets.getAndIncrement(),
                            scr.repetition(),
                            scr.repetitionByTime(),
                            scr.cadence(),
                            scr.restBetweenExercises(),
                            scr.restBetweenSets(),
                            scr.weight(),
                            scr.rangeOfMotion()
                    ))
                .toList();
    }
}
