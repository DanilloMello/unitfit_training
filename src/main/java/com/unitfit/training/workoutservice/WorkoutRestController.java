package com.unitfit.training.workoutservice;

import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutCreateUseCase;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkoutRestController {

    private final ApplicationContext context;
    @PostMapping("/workouts")
    public void create(@RequestBody WorkoutCreateRequest request){
        WorkoutCreateUseCase createUseCase = context.getBean("workoutCreateUsecase", WorkoutCreateUseCase.class);
        createUseCase.execute(request);
    }
}
