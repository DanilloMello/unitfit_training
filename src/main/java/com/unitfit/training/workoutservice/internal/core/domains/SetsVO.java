package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints.SetsValidation;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.Duration;

@Embeddable
@SetsValidation
public record SetsVO(
        @Column(nullable = false)
        Integer setOrder,
        Integer repetition,
        Duration repetitionByTime,
        @Column(nullable = false)
        String cadence,
        @Column(nullable = false)
        Duration restBetweenExercises,
        @Column(nullable = false)
        Duration restBetweenSets,
        Integer weight,
        @Column(nullable = false)
        Integer rangeOfMotion
) { }

