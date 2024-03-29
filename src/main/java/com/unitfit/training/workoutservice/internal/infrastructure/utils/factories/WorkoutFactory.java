package com.unitfit.training.workoutservice.internal.infrastructure.utils.factories;

import com.unitfit.training.workoutservice.internal.core.domains.ExerciseVO;
import com.unitfit.training.workoutservice.internal.core.domains.SetsVO;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetsCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import org.hibernate.engine.spi.CollectionEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WorkoutFactory implements EntityFactory<Workout>{

    @Override
    public Workout recordToEntity(Record request) {
        if (request instanceof WorkoutCreateRequest) return requestCreateToWorkout((WorkoutCreateRequest) request);
        return null;
    }




    private Workout requestCreateToWorkout(WorkoutCreateRequest request) {
        List<SetsVO> setsVOS = new ArrayList<>();
        Workout workout = new Workout();
        for ( ExerciseCreateRequest exerciseRequest : request.exercisesCreateRequest()){

            setsVOS.add(
                exerciseRequest.setsCreaDateRequests()
                        .stream()
                        .map(this::setsCreateRequestToSetsVO));

            workout.addExercise();
        }




    }
    private SetsVO setsCreateRequestToSetsVO(SetsCreateRequest request){
        return new SetsVO(
                request.setOrder(),
                request.repetition(),
                request.repetitionTime(),
                request.cadence(),
                request.restBetweenExercises(),
                request.restBetweenSets(),
                request.weight(),
                request.rangeOfMotion()
        );
    }

}
