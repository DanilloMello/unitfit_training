package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;

public interface WorkoutPresenter {
    void presentWorkout(Workout workout);

    void presentError(Exception exception);
}
