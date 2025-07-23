package com.n1jel.market.mapper;

import com.n1jel.market.dto.CarCreateRequestDto;
import com.n1jel.market.dto.CarDto;
import com.n1jel.market.dto.CarUpdateRequestDto;
import com.n1jel.market.entity.Car;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    CarDto mapToResponse(Car car);

    List<CarDto> mapToResponse(List<Car> cars);

    Car mapToEntity(CarCreateRequestDto carCreateRequestDto);

    Car updateEntity(@MappingTarget Car car, CarUpdateRequestDto carUpdateRequestDto);
}
