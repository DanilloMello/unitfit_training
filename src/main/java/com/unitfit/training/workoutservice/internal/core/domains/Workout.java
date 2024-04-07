package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidated;
import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidation;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Getter
@Entity
@DomainValidated
public class Workout extends DomainValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @Transient
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }
    @Override
    public Boolean isValid() {
        return true;
    }
}
