package com.n1jel.market.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CarUpdateRequestDto(
        @Size(min = 3, max = 12, message = "Brand must be in range of 3-12 symbols")
        String brand,
        @Size(min = 3, max = 12, message = "Model must be in range of 3-12 symbols")
        String model,
        @Size(min = 1, max = 20, message = "Generation must be in rage of 1-20 symbols")
        String generation,
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be in range of 0.01-999999$")
        @DecimalMax(value = "1000000", inclusive = false, message = "Price must be in range of 0.01-999999$")
        @Digits(integer=6, fraction=2, message = "Price must be in range of 0.01-999999$")
        BigDecimal price,
        Long carId
) {
}
