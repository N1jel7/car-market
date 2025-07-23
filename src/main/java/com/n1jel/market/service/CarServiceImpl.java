package com.n1jel.market.service;

import com.n1jel.market.dao.CarSearchDao;
import com.n1jel.market.dto.CarCreateRequestDto;
import com.n1jel.market.dto.CarDeleteRequestDto;
import com.n1jel.market.dto.CarDto;
import com.n1jel.market.dto.CarUpdateRequestDto;
import com.n1jel.market.dto.request.car.CarFilterDto;
import com.n1jel.market.entity.Car;
import com.n1jel.market.mapper.CarMapper;
import com.n1jel.market.repository.CarRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarSearchDao carSearchDao;
    private final CarRepository carRepository;
    private final Validator validator;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> getCars(CarFilterDto filter) {
        return carMapper.mapToResponse(carSearchDao.findAllByFilter(filter));
    }

    @Override
    public CarDto createCar(CarCreateRequestDto carCreateRequestDto) {
        validate(carCreateRequestDto);
        Car car = carMapper.mapToEntity(carCreateRequestDto);
        return carMapper.mapToResponse(carRepository.save(car));
    }

    @Override
    public CarDto deleteCar(CarDeleteRequestDto carDeleteRequestDto) {
        validate(carDeleteRequestDto);
        Car car = carRepository.findCarById(carDeleteRequestDto.carId());
        carRepository.delete(car);
        return carMapper.mapToResponse(car);
    }

    @Override
    public CarDto updateCar(CarUpdateRequestDto carUpdateRequestDto) {
        validate(carUpdateRequestDto);
        Car carFromDb = carRepository.findCarById(carUpdateRequestDto.carId());
        Car carUpdated = carMapper.updateEntity(carFromDb, carUpdateRequestDto);

        if (carFromDb != carUpdated) {
            return carMapper.mapToResponse(carRepository.save(carUpdated));
        }
          return carMapper.mapToResponse(carFromDb);
    }

    private void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }


}
