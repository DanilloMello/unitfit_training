package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.contraints.SetValidation;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.time.Duration;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@SetValidation
@Immutable
@Embeddable
public class SetConfiguration {
    @Column(nullable = false) @NonNull
    private Integer setOrder;
    private Integer repetition;
    private Duration repetitionTime;
    @Column(nullable = false) @NonNull
    private String cadence;
    @Column(nullable = false) @NonNull
    private Duration restBetweenExercises;
    @Column(nullable = false) @NonNull
    private Duration restBetweenSets;
    private Integer weight;
    @Column(nullable = false) @NonNull
    private Integer rangeOfMotion;
}
