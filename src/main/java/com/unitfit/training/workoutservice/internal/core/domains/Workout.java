package com.unitfit.training.workoutservice.internal.core.domains;

import jakarta.persistence.*;
import lombok.*;

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

    // Professor
    // Aluno
}
