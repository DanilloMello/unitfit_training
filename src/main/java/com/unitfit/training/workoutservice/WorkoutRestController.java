package com.unitfit.training.workoutservice;


import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutCreateUsercase;
import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutFindByIdUsercase;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class WorkoutRestController {

    private final ApplicationContext context;

    @PostMapping("/workouts")
    public void create(@RequestBody WorkoutCreateRequest workoutDTO){
        IWorkoutCreateUsercase createUseCase = context.getBean(IWorkoutCreateUsercase.class);
        createUseCase.execute(workoutDTO);
    }

    @GetMapping("/find")
    public void findById(@RequestParam UUID workoutId, @RequestParam(value = "name", required = false) String nameFilter){
        IWorkoutFindByIdUsercase createUseCase = context.getBean(IWorkoutFindByIdUsercase.class);
        createUseCase.execute(new WorkoutFindByIdRequest(workoutId, nameFilter));
    }
//
//    @GetMapping
//    public void findByClientId(@RequestBody WorkoutFindByClientIdRequest request){
//        IWorkoutFindByClientIdUsercase createUseCase = context.getBean(IWorkoutFindByClientIdUsercase.class);
//        createUseCase.execute(request);
//    }

}