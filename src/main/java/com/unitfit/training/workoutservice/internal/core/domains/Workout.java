package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    
    @Column(nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "exercise",
            joinColumns=@JoinColumn(name = "workout_id", referencedColumnName = "id")
    )
    private List<ExerciseVO> exercises = new ArrayList<>();

    public void addExercise(WorkoutCreateRequest request) {

    }
}
