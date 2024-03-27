package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import lombok.Data;

import java.time.Duration;
@Data
public class SetConfigurationRequest {
    private Integer sets; // sets orders by quantity of sets
    private Integer repetition;
    private Duration repetitionTime;
    private String cadence;
    private Duration restBetweenExercises;
    private Duration restBetweenSets;
    private Integer weight;
    private Integer rangeOfMotion;
}
