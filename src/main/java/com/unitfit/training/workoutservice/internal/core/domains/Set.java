package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.Duration;

import static java.util.Objects.isNull;

@Embeddable
public record Set(
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
) {
        public Set {
                if (isNull(repetition) && isNull(repetitionByTime)) {
                        throw new IllegalArgumentException("teste");
                }
        }
}
