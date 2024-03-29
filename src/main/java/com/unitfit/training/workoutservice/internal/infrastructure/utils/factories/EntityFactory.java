package com.unitfit.training.workoutservice.internal.infrastructure.utils.factories;

public interface EntityFactory<T> {
    T create(Record request);
}
