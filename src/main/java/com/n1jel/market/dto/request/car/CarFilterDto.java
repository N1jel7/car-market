package com.n1jel.market.dto.request.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarFilterDto {
    private String brand;
    private String model;
    private String generation;

/*    private Integer yearFrom;
    private Integer yearTo;*/

    private Long priceFrom;
    private Long priceTo;
}
