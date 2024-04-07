package com.unitfit.training.workoutservice.internal.core.factories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ValidationRequestDTO;

import java.util.List;

public interface DomainFactory<T extends ValidationRequestDTO> {
    Record create(T request);

    List<Record> findAllByName(String request);

    List<Record> findAll();
}
