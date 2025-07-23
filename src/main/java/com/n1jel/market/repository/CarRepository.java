package com.n1jel.market.repository;

import com.n1jel.market.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {

    Car findCarById(Long id);

    List<Car> findCarsByBrand(String brand);

}
