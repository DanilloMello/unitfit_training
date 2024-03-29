package com.unitfit.training.workoutservice.internal.infrastructure.gateways;

import com.unitfit.training.workoutservice.internal.core.domains.ExerciseVO;

import java.util.List;

public interface ExerciseDatabaseGateway {
    ExerciseVO saveExercise(ExerciseVO exerciseVO);
    List<ExerciseVO> saveAllExercises(List<ExerciseVO> exerciseVOS);

}
