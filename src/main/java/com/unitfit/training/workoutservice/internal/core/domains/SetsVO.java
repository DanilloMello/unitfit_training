package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints.SetsValidation;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetsCreateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.Duration;
import java.util.List;

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
        Integer rangeOfMotion) {
        public SetsVO(List<SetsCreateRequest> request) {
                this(
                        request.size(),
                        request.
                )
        }
}

