package com.n1jel.market.dto;

import java.math.BigDecimal;

public record CarDto(
        Long id,
        String brand,
        String model,
        String generation,
        BigDecimal price
) {
}
