package com.unitfit.training.workoutservice.internal.core.factories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.core.domains.Set;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutDTO;
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
public class WorkoutFactory implements DomainFactory<WorkoutDTO> {
    private final WorkoutDatabaseGateway database;
    private final ExerciseDatabaseGateway exerciseDatabase;
    @Override
    public Record create(WorkoutDTO request) {
        if (nonNull(request)) {
            return workoutRequestToWorkout(request);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<Record> findAllByName(String request) {
        return List.of();
    }

    @Override
    public List<Record> findAll() {
        return List.of();
    }

    private Record workoutRequestToWorkout(WorkoutDTO request) {
        Workout workout = this.database.saveWorkout(new Workout(request.name()));
        List<Exercise> exercises = exercisesRequestToExercises(request.exerciseDTO(), workout);
        this.exerciseDatabase.saveAllExercises(exercises);
        return new WorkoutCreateResponse(request.name(), request.exerciseDTO());
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
