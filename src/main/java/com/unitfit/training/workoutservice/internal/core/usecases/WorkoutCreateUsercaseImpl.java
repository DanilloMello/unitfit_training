package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.core.factories.WorkoutFactory;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutOutputPortPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class WorkoutCreateUsercaseImpl implements IWorkoutCreateUsercase {

    private final WorkoutOutputPortPresenter presenter;
    private final WorkoutFactory createFactory;

    @Override
    @Transactional
    public void execute(WorkoutCreateRequest request) {
        try {
            HttpStatus status = createFactory.create(request);
            presenter.presentCreateUsecase(status);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
