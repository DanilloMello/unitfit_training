package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdResponse;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface WorkoutOutputPortPresenter {
    void presentCreateUsecase(HttpStatus status);
    void presentFindByClientIdUsecase(List<WorkoutFindByClientIdResponse> response);
    void presentFindByIdUsecase(WorkoutFindByIdResponse response);
    void presentError(Exception exception);
}
