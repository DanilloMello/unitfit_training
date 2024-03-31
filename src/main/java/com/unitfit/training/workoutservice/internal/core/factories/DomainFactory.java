package com.unitfit.training.workoutservice.internal.core.factories;

public interface DomainFactory<T extends Record> {
    Record create(T request);
}
