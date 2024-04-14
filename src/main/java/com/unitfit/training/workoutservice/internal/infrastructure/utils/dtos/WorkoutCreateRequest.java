package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

public record WorkoutCreateRequest (List<WorkoutDTO> workouts)
{
    public WorkoutCreateRequest {
        if (isEmpty(workouts)) {
            throw new IllegalArgumentException("Workouts can't be null or empty");
        }
    }
}