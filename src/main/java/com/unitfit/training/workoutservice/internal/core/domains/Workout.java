package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
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
    @Setter
    private List<Exercise> exercises;
}
