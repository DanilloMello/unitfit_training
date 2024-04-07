package com.unitfit.training.workoutservice.internal.core.usecases;

import com.unitfit.training.workoutservice.internal.core.factories.DomainFactory;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutOutputPortPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WorkoutFindAllUsecase implements WorkoutInputPortUsecase<WorkoutDTO>{

    private final WorkoutOutputPortPresenter presenter;
    private final DomainFactory<WorkoutDTO> factory;

    @Override
    @Transactional
    public void execute(WorkoutDTO request) {
        try {
            List<Record> workout = factory.findAll();
            presenter.presentWorkouts(workout);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
