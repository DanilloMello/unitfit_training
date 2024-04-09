package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.gateways.WorkoutDatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutOutputPortPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WorkoutFindByClientIdUsecaseImpl implements IWorkoutFindByClientIdUsercase {

    private final WorkoutOutputPortPresenter presenter;
    private final WorkoutDatabaseGateway repository;

    @Override
    @Transactional
    public void execute(WorkoutFindByClientIdRequest request) {
        try {
//            List<WorkoutFindByClientIdResponse> response =
//                    repository.findByClientId(request.clientId()).orElseThrow();
//            presenter.presentFindByClientIdUsecase(response);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
