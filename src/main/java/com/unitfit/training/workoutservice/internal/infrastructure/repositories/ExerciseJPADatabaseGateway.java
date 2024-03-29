package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.core.domains.ExerciseVO;
import com.unitfit.training.workoutservice.internal.infrastructure.gateways.ExerciseDatabaseGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExerciseJPADatabaseGateway implements ExerciseDatabaseGateway {

    private final ExerciseJPARepository exerciseJPARepository;
    @Override
    public ExerciseVO saveExercise(ExerciseVO exerciseVO) {
        return exerciseVO;
    }

    @Override
    public List<ExerciseVO> saveAllExercises(List<ExerciseVO> exerciseVOS) {
        return exerciseVOS;
    }
}
