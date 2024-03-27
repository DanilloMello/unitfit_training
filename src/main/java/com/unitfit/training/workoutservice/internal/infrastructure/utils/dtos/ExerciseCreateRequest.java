package com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseCreateRequest {
    String name;
    List<SetConfigurationRequest> setConfigurationRequests;
}
