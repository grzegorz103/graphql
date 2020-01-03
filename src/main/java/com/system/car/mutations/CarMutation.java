package com.system.car.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMutation implements GraphQLMutationResolver {

    private final CarService carService;

    @Autowired
    public CarMutation(CarService carService) {
        this.carService = carService;
    }

    public Car createCar(String model, int year) {
        return carService.create(model, year);
    }

    public Car updateCar(Long id, String model, int year) {
        return carService.update(id, model, year);
    }

    public Long deleteCar(Long id) {
        return carService.delete(id);
    }
}
