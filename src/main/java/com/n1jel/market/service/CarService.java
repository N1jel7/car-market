package com.n1jel.market.service;

import com.n1jel.market.dto.CarCreateRequestDto;
import com.n1jel.market.dto.CarDeleteRequestDto;
import com.n1jel.market.dto.CarDto;
import com.n1jel.market.dto.CarUpdateRequestDto;
import com.n1jel.market.dto.request.car.CarFilterDto;

import java.util.List;

public interface CarService {

    List<CarDto> getCars(CarFilterDto filter);

    CarDto createCar(CarCreateRequestDto carCreateRequestDto);

    CarDto deleteCar(CarDeleteRequestDto carDeleteRequestDto);

    CarDto updateCar(CarUpdateRequestDto carUpdateRequestDto);
}
