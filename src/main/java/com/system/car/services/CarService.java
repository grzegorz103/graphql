package com.system.car.services;

import com.system.car.models.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    Car getCarById(Long id);

    Car create(String model, int year, List<String> images, String info, Long brandId);

    Car update(Long id, String model, int year, Long brandId);

    Long delete(Long id);
}
