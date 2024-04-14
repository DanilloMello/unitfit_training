package com.unitfit.training.customerservice.internal.infrastructure.utils.dtos;

import java.util.UUID;

public record CustomerCreateResponse(UUID id, String name) { }