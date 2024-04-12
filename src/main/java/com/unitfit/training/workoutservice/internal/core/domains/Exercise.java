package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidated;
import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidation;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Entity
@DomainValidated
public class Exercise extends DomainValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NonNull
    @Column(nullable = false, unique = true)
    String name;

    @NonNull
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "set",
            joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    )
    List<Set> sets;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id")
    Workout workout;

    @Override
    public Boolean isValid() {
        return true;
    }
}
