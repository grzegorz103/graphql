package com.system.car.services;

import com.system.car.dao.VehicleRepository;
import com.system.car.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAllSorted();
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
