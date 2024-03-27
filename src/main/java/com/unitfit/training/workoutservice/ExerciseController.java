/*
package com.unitfit.training.workouts.infrastructure.controllers;

import com.unitfit.training.workouts.infrastructure.presenters.impl.WorkoutRestPresenter;
import com.unitfit.training.workouts.internal.usecases.WorkoutInputPort;
import com.unitfit.training.workouts.internal.utils.dtos.WorkoutCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
    private final WorkoutInputPort workoutCreateUseCaseAggregate;
    @Autowired
    public ExerciseController(WorkoutInputPort workoutCreateUseCaseAggregate){
        this.workoutCreateUseCaseAggregate = workoutCreateUseCaseAggregate;
    }

    @PostMapping("/workouts")
    public HttpStatus save(@RequestBody WorkoutCreateRequest request){
        return WorkoutRestPresenter.httpResponse(this.workoutCreateUseCaseAggregate.create(request));
    }
}
*/
