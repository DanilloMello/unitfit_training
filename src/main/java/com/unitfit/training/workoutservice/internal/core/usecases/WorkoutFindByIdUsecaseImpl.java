package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutOutputPortPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkoutFindByIdUsecaseImpl implements IWorkoutFindByIdUsercase {

    private final WorkoutOutputPortPresenter presenter;
    private final WorkoutDatabaseGateway repository;

    @Override
    @Transactional
    public void execute(WorkoutFindByIdRequest request) {
        try {
//            WorkoutFindByIdResponse workout = repository.findById(request.id());
//            presenter.presentFindByIdUsecase(workout);
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }
}
