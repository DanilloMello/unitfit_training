package com.unitfit.training.workoutservice;


import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutCreateUsercase;
import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutFindByIdUsercase;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutCreateRequest;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdRequest;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workouts")
@PermitAll
public class WorkoutRestController {

    private final ApplicationContext context;

    @PostMapping
    public void create(@RequestBody WorkoutCreateRequest workoutDTO){
        IWorkoutCreateUsercase createUseCase = context.getBean(IWorkoutCreateUsercase.class);
        createUseCase.execute(workoutDTO);
    }

    @GetMapping("/{id}")
    public void findById(@PathVariable UUID id, @RequestParam(value = "name", required = false) String nameFilter){
        IWorkoutFindByIdUsercase createUseCase = context.getBean(IWorkoutFindByIdUsercase.class);
        createUseCase.execute(new WorkoutFindByIdRequest(id, nameFilter));
    }

//    @GetMapping("/client/{clientId}")
//    public void findAllByClientId(@PathVariable UUID clientId){
//        IWorkoutFindByClientIdUsercase createUseCase = context.getBean(IWorkoutFindByClientIdUsercase.class);
//        createUseCase.execute(request);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteById(@PathVariable UUID id){
//        IWorkoutFindByClientIdUsercase createUseCase = context.getBean(IWorkoutFindByClientIdUsercase.class);
//        createUseCase.execute(request);
//    }
//
//    @PutMapping
//    public void update(@RequestBody WorkoutUpdateRequest request){
//        IWorkoutFindByClientIdUsercase createUseCase = context.getBean(IWorkoutFindByClientIdUsercase.class);
//        createUseCase.execute(request);
//    }

}