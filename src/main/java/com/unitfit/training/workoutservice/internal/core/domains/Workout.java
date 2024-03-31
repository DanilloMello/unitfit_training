package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Entity
public class Workout {
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

}
