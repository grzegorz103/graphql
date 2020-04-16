package com.system.car.services;

import com.system.car.api.rest.exception.ExceptionFactory;
import com.system.car.api.rest.exception.ExceptionType;
import com.system.car.dao.CarRepository;
import com.system.car.models.Car;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return carRepository.findAllSorted();
    }

    @Override
    @Cacheable(cacheNames = "cars", key = "#id")
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND));
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public Car create(String model, int year, List<String> images, String info, Long brandId) {
        Car car = new Car();
        car.setBrand(brandService.getById(brandId));
        car.setModel(model);
        car.setYear(year);
        car.setImages(images.stream().filter(e -> !StringUtils.isBlank(e)).collect(Collectors.toList()));
        car.setInfo(info);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public Car update(Long id, String model, int year, Long brandId) {
        Car car = carRepository.findById(id).orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND));
        car.setBrand(brandService.getById(brandId));
        car.setModel(model);
        car.setYear(year);
        return carRepository.save(car);
    }

    @Override
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public Long delete(Long id) {
        carRepository.deleteById(id);
        return id;
    }

    @Override
    @Cacheable(cacheNames = "cars")
    public Page<Car> getCarsPaged(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
