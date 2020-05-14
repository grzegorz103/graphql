package com.system.car.services;

import com.system.car.api.rest.exception.ExceptionFactory;
import com.system.car.api.rest.exception.ExceptionType;
import com.system.car.dao.CarRepository;
import com.system.car.models.Car;
import com.system.car.services.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
    @Cacheable(cacheNames = Constants.CAR_CACHE_NAME, key = "#id")
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Car.class.getSimpleName(), id));
    }

    @Override
    @CacheEvict(cacheNames = Constants.CAR_CACHE_NAME, allEntries = true)
    public Car create(String model, int year, List<String> images, String info, Long brandId) {
        Car car = new Car();
        car.setBrand(brandService.getById(brandId));
        car.setModel(model);
        System.out.println("CCreate");
        car.setYear(year);
        car.setImages(images.stream().filter(e -> !StringUtils.isBlank(e)).collect(Collectors.toList()));
        car.setInfo(info);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = Constants.CAR_CACHE_NAME, allEntries = true)
    public Car update(Long id, String model, int year, Long brandId) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Car.class.getSimpleName(), id));
        car.setBrand(brandService.getById(brandId));
        car.setModel(model);
        car.setYear(year);
        return carRepository.save(car);
    }

    @Override
    @CacheEvict(cacheNames = Constants.CAR_CACHE_NAME, allEntries = true)
    public Long delete(Long id) {
        if (!carRepository.existsById(id))
            throw ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Car.class.getSimpleName(), id);

        carRepository.deleteById(id);
        return id;
    }

    @Override
    @Cacheable(cacheNames = Constants.CAR_CACHE_NAME)
    public Page<Car> getCarsPaged(Pageable pageable) {
        System.out.println("AAA");
        return carRepository.findAll(pageable);
    }
}
