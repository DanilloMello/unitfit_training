package com.unitfit.training.workoutservice;

import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutCreateUsecase;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutFindAllUsecase;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutFindAllByNameUsecase;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutInputPortUsecase;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workouts")
public class WorkoutRestController {

    private final ApplicationContext context;

    @PostMapping
    public void create(@RequestBody WorkoutDTO workoutDTO){
        WorkoutInputPortUsecase<WorkoutDTO> createUseCase = context.getBean("workoutCreateUsecase", WorkoutCreateUsecase.class);
        createUseCase.execute(workoutDTO);
    }

    @GetMapping
    public void findByName(@RequestParam String name){
        WorkoutInputPortUsecase<WorkoutDTO> createUseCase = context.getBean("workoutFindByNameUsecase", WorkoutFindAllByNameUsecase.class);
        createUseCase.execute(new WorkoutDTO(name, null));
    }

    @GetMapping
    public void findAll(){
        WorkoutInputPortUsecase<WorkoutDTO> createUseCase = context.getBean("workoutFindAllUsecase", WorkoutFindAllUsecase.class);
        createUseCase.execute(null);
    }
}
