package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workoutEntity;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "set_configuration",
            joinColumns=@JoinColumn(name = "exercise_id", referencedColumnName = "id")
    )
    private List<SetConfiguration> setConfigurations = new ArrayList<>();

    // Professor
}
