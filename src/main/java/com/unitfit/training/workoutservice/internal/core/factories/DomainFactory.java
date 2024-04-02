package com.unitfit.training.workoutservice.internal.core.factories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ValidationRequestDTO;

public interface DomainFactory<T extends ValidationRequestDTO> {
    Record create(T request);
}
