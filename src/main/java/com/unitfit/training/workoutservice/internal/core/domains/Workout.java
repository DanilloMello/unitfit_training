package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidated;
import com.unitfit.training.workoutservice.internal.core.domains.constraints.DomainValidation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@NoArgsConstructor
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

    @Column
    private UUID clientId;

    @Transient
    @OneToMany(cascade = CascadeType.ALL)
    private final List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }
    public void addAllExercises(List<Exercise> exercises){
        this.exercises.addAll(exercises);
    }
    @Override
    public Boolean isValid() {
        return true;
    }
}
