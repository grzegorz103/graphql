package com.system.car.services;

import com.system.car.models.Motorcycle;

import java.util.List;

public interface MotorcycleService {

    List<Motorcycle> getAll();

    Motorcycle create(String model, int year);

    Motorcycle update(Long id, String model, int year);

    Long delete(Long id);
}
