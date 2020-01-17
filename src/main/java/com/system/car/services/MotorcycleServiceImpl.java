package com.system.car.services;

import com.system.car.dao.MotorcycleRepository;
import com.system.car.models.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }


    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public Motorcycle create(String model, int year) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setModel(model);
        motorcycle.setYear(year);
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public Motorcycle update(Long id, String model, int year) {
        Motorcycle motorcycle = motorcycleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        motorcycle.setYear(year);
        motorcycle.setModel(model);

        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public Long delete(Long id) {
        if (motorcycleRepository.existsById(id)) {
            motorcycleRepository.deleteById(id);
            return id;
        } else {
            throw new RuntimeException("Not found");
        }
    }
}
