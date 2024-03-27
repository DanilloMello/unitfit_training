package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutRestPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.mappers.WorkoutMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkoutCreateUseCase implements WorkoutInputPort {

    private final WorkoutJPADatabaseGateway workoutDatabase;
    private final WorkoutRestPresenter presenter;
    private final  WorkoutMapper workoutMapper;
    @Override
    @Transactional
    public void execute(WorkoutCreateRequest request) {
        try {
            Workout workout = workoutMapper.toWorkout(request);
//            List<Exercise> exercises = new ArrayList<>();
//            if (nonNull(request.getExercises())) {
//                exercises = exerciseMapper.toExerciseEntityList(request.getExercises());
//                exercises = exerciseDatabase.saveAllExercises(exercises);
//            }

//            if (isNotEmpty(exercises)) this.workoutDatabase.saveWorkout(workout);

//          can mapper the workout entity for a data model response
//          presenter can present this data model as you want (json, xml, grpc...)
            presenter.presentWorkout(this.workoutDatabase.saveWorkout(workout));
        } catch (Exception e){
            presenter.presentError(e);
        }
    }


}
