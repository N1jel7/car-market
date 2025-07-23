package com.n1jel.market.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CarDeleteRequestDto(
        @NotNull(message = "Car ID is null")
        @NotEmpty(message = "Car ID is empty")
        Long carId
) {
}
