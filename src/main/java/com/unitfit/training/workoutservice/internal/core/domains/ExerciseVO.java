package com.unitfit.training.workoutservice.internal.core.domains;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetsCreateRequest;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class ExerciseVO (
    @Column(nullable = false)
    String name,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "sets",
            joinColumns=@JoinColumn(name = "exercise_id", referencedColumnName = "id")
    )
    List<SetsVO> sets
) {
    public ExerciseVO(ExerciseCreateRequest request) {
        this(
                request.name(),
                 )
    }
}
