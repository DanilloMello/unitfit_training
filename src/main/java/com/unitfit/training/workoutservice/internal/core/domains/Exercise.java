package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NonNull
    @Column(nullable = false, unique = true)
    String name;

    @NonNull
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "sets",
            joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    )
    List<SetsVO> sets;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    Workout workout;
}
