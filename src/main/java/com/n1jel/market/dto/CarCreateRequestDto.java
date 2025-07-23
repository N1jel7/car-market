package com.n1jel.market.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CarCreateRequestDto(
        @NotEmpty(message = "Brand is empty")
        @Size(min = 3, max = 12, message = "Brand must be in range of 3-12 symbols")
        String brand,
        @NotEmpty(message = "Model is empty")
        @Size(min = 3, max = 12, message = "Model must be in range of 3-12 symbols")
        String model,
        @NotEmpty(message = "Generation is empty")
        @Size(min = 1, max = 20, message = "Generation must be in rage of 1-20 symbols")
        String generation,
        @NotEmpty(message = "Price is empty")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be in range of 0.01-999999$")
        @DecimalMax(value = "1000000", inclusive = false, message = "Price must be in range of 0.01-999999$")
        @Digits(integer=6, fraction=2, message = "Price must be in range of 0.01-999999$")
        BigDecimal price,
        Long ownerId
) {
}
