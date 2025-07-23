package com.n1jel.market.controller;

import com.n1jel.market.dto.CarCreateRequestDto;
import com.n1jel.market.dto.CarDeleteRequestDto;
import com.n1jel.market.dto.CarDto;
import com.n1jel.market.dto.CarUpdateRequestDto;
import com.n1jel.market.dto.request.car.CarFilterDto;
import com.n1jel.market.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/cars")
public class MainRestController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getBrand(CarFilterDto carFilterDto) {
        return carService.getCars(carFilterDto);
    }

    @PostMapping("/create")
    public CarDto createCar(@RequestParam CarCreateRequestDto carCreateRequestDto) {
        return carService.createCar(carCreateRequestDto);
    }

    @PatchMapping("/update/{carId}")
    public CarDto updateCar(CarUpdateRequestDto carUpdateRequestDto) {
        return carService.updateCar(carUpdateRequestDto);
    }

    @DeleteMapping("/delete/{carId}")
    public CarDto deleteCar(CarDeleteRequestDto carDeleteRequestDto) {
        return carService.deleteCar(carDeleteRequestDto);
    }

}
