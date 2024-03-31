package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutOutputPortPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.core.factories.DomainFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkoutCreateUseCase implements WorkoutInputPortUsecase{

    private final WorkoutOutputPortPresenter presenter;
    private final DomainFactory<WorkoutCreateRequest> factory;

    @Override
    @Transactional
    public void execute(WorkoutCreateRequest request) {
        try {
            Record workout = factory.create(request);
            presenter.presentCreateWorkout(workout);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
