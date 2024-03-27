package com.unitfit.training.workoutservice.internal.infrastructure.utils.mappers;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class WorkoutMapper implements IWorkoutMapper {
    @Override
    public Workout toWorkout(WorkoutCreateRequest request) {
        Workout workout = new Workout();
        workout.setName(request.getName());
        return workout;
    }
}
