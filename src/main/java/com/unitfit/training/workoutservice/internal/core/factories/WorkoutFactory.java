package com.unitfit.training.workoutservice.internal.core.factories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.core.domains.Set;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Validated
public class WorkoutFactory {
    private final WorkoutDatabaseGateway workoutDatabase;
    private final ExerciseDatabaseGateway exerciseDatabase;
    
    public HttpStatus create(WorkoutCreateRequest request) {
        Workout workout = this.workoutDatabase.saveWorkout(new Workout(request.name()));
        List<Exercise> exercises = exercisesRequestToExercises(request.exerciseDTO(), workout);
        this.exerciseDatabase.saveAllExercises(exercises);
        return HttpStatus.CREATED;
    }

    private List<Exercise> exercisesRequestToExercises(List<ExerciseDTO> request, Workout workout) {
        return request
                .stream()
                .map(ecr ->
                        new Exercise(
                                ecr.name(),
                                setsRequestToSets(ecr.setsDTO()),
                                workout
                        ))
                .toList();
    }

    private List<Set> setsRequestToSets(List<SetDTO> request) {
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
