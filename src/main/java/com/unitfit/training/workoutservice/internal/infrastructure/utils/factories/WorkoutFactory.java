package com.unitfit.training.workoutservice.internal.infrastructure.utils.factories;

import com.unitfit.training.workoutservice.internal.core.domains.Exercise;
import com.unitfit.training.workoutservice.internal.core.domains.SetsVO;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.ExerciseJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetsCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.nonNull;
@Component
@RequiredArgsConstructor
public class WorkoutFactory implements EntityFactory<Workout>{

    private final WorkoutJPADatabaseGateway workoutDatabase;
    private final ExerciseJPADatabaseGateway exerciseDatabase;
    @Override
    public Workout create(Record request) {
        if (nonNull(request)) {
            if (request instanceof WorkoutCreateRequest workoutCreateRequest) return requestCreateToWorkout(workoutCreateRequest);
            throw new IllegalArgumentException("Type of request was not found.");
        } else {
            throw new NullPointerException();
        }
    }
    private Workout requestCreateToWorkout(WorkoutCreateRequest request) {
        Workout workout = this.workoutDatabase.saveWorkout(new Workout(request.name()));
        List<Exercise> exercises = exerciseCreateRequestListToExerciseVOList(request.exercisesCreateRequest(), workout);
        workout.setExercises(this.exerciseDatabase.saveAllExercises(exercises));
        return workout;
    }
    private List<Exercise> exerciseCreateRequestListToExerciseVOList(List<ExerciseCreateRequest> request, Workout workout) {
        return request
                .stream()
                .map(ecr ->
                        new Exercise(
                                ecr.name(),
                                setsCreateRequestListToSetsVOList(ecr.setsCreateRequests()),
                                workout
                        ))
                .toList();
    }

    private List<SetsVO> setsCreateRequestListToSetsVOList(List<SetsCreateRequest> request) {
        AtomicInteger sets = new AtomicInteger(1);
        return request
                .stream()
                .map(scr ->
                     new SetsVO(
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
