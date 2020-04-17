package com.system.car.services;

import com.system.car.api.rest.exception.ExceptionFactory;
import com.system.car.api.rest.exception.ExceptionType;
import com.system.car.dao.VehicleRepository;
import com.system.car.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return vehicleRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Vehicle.class.getSimpleName(), id));
    }

    @Override
    public Page<Vehicle> getAllPaged(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public Page<Vehicle> getVehiclesByBrandId(Long id, Pageable pageable) {
        return vehicleRepository.findAllByBrandId(id, pageable);
    }
}
