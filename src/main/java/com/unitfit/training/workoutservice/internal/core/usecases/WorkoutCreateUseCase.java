package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.core.domains.ExerciseVO;
import com.unitfit.training.workoutservice.internal.core.domains.SetsVO;
import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutRestPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WorkoutCreateUseCase implements WorkoutInputPort {

    private final WorkoutJPADatabaseGateway workoutDatabase;
    private final WorkoutRestPresenter presenter;
    @Override
    @Transactional
    public void execute(WorkoutCreateRequest request) {
        try {
            Workout workout = new Workout();

//              TODO: terá que mappear os records requests -> records VO's
//              TODO: para manter a responsabilidade única, transferir o código de mapeando de dao para um factory
//

//            workout.addExercise(
//              TODO: adicionar ExerciciosVOS -- terá que vir com os records prontos
//            );

//          can mapper the workout entity for a data model response
//          presenter can present this data model as you want (json, xml, grpc...)
            presenter.presentWorkout(this.workoutDatabase.saveWorkout(workout));
        } catch (Exception e){
            presenter.presentError(e);
        }
    }


}
