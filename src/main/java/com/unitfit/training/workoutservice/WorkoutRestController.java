package com.unitfit.training.workoutservice;


import com.unitfit.training.workoutservice.internal.core.usecases.*;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class WorkoutRestController {

    private final ApplicationContext context;

    @PostMapping("/workouts")
    public void create(@RequestBody WorkoutCreateRequest workoutCreateRequest){
        IWorkoutCreateUsercase createUseCase = context.getBean(IWorkoutCreateUsercase.class);
        createUseCase.execute(workoutCreateRequest);
    }

    @PostMapping("/find")
    public void findById(@RequestBody WorkoutFindByIdRequest request){
        IWorkoutFindByIdUsercase createUseCase = context.getBean(IWorkoutFindByIdUsercase.class);
        createUseCase.execute(request);
    }
//
//    @GetMapping
//    public void findByClientId(@RequestBody WorkoutFindByClientIdRequest request){
//        IWorkoutFindByClientIdUsercase createUseCase = context.getBean(IWorkoutFindByClientIdUsercase.class);
//        createUseCase.execute(request);
//    }

}