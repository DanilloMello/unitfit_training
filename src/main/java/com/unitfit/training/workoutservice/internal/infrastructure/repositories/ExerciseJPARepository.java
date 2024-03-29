package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.ExerciseVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseJPARepository extends JpaRepository<ExerciseVO, UUID> {

}
