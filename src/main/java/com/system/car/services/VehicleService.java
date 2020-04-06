package com.system.car.services;

import com.system.car.models.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAll();

    Vehicle getById(Long id);
}
