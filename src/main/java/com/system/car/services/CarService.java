package com.system.car.services;

import com.system.car.models.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    Car create(String model, int year);

    Car update(Long id, String model, int year, Long brandId);

    Long delete(Long id);
}
