package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

public interface WorkoutOutputPortPresenter {
    void presentCreateWorkout(Record response);
    void presentError(Exception exception);
}
