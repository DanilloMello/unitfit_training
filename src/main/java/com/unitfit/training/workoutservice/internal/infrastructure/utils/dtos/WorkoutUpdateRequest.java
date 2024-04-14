package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

public record WorkoutUpdateRequest(List<WorkoutDTO> workoutDTOS)
{
    public WorkoutUpdateRequest {
        if (isEmpty(workoutDTOS)) {
            throw new IllegalArgumentException("Workouts can't be null or empty");
        } else if (workoutDTOS.stream().anyMatch(w -> isNull(w.id()))){
            throw new IllegalArgumentException("Workout's id can't be null");
        }
    }
}