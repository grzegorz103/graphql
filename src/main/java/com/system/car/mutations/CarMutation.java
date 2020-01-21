package com.system.car.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarMutation implements GraphQLMutationResolver {

    private final CarService carService;

    @Autowired
    public CarMutation(CarService carService) {
        this.carService = carService;
    }

    public Car createCar(String model, int year, List<String> images, String info) {
        return carService.create(model, year, images, info);
    }

    public Car updateCar(Long id, String model, int year, Long brandId) {
        return carService.update(id, model, year, brandId);
    }

    public Long deleteCar(Long id) {
        return carService.delete(id);
    }
}
