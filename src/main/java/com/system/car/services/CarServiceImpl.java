package com.system.car.services;

import com.system.car.dao.CarRepository;
import com.system.car.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final BrandService brandService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, BrandService brandService) {
        this.carRepository = carRepository;
        this.brandService = brandService;
    }

    @Override
    @Transactional
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car create(String model, int year) {
        Car car = new Car();
        car.setModel(model);
        car.setYear(year);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car update(Long id, String model, int year, Long brandId) {
        Car car = carRepository.findById(id).get();
        car.setBrand(brandService.getById(brandId));
        car.setModel(model);
        car.setYear(year);
        return carRepository.save(car);
    }

    @Override
    public Long delete(Long id) {
        carRepository.deleteById(id);
        return id;
    }
}
