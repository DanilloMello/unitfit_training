package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

import java.util.List;

public interface WorkoutOutputPortPresenter {
    void presentWorkout(Record response);
    void presentWorkouts(List<Record> response);
    void presentError(Exception exception);
}
