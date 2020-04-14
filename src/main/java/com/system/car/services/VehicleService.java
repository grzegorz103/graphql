package com.system.car.services;

import com.system.car.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAll();

    Vehicle getById(Long id);

    Page<Vehicle> getAllPaged(Pageable pageable);

    Page<Vehicle> getVehiclesByBrandId(Long id, Pageable pageable);
}
