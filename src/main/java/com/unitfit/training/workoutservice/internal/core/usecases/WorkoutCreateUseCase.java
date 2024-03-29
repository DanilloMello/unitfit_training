package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutRestPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.factories.WorkoutFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkoutCreateUseCase implements WorkoutInputPort {

    private final WorkoutRestPresenter presenter;
    private final WorkoutFactory workoutFactory;
    @Override
    @Transactional
    public void execute(WorkoutCreateRequest request) {
        try {
            presenter.presentWorkout(
                workoutFactory.create(request));
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
