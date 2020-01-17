package com.system.car.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
    public class CarQuery implements GraphQLQueryResolver{

    private final CarService carService;

    public CarQuery(CarService carService) {
        this.carService = carService;
    }

    public List<Car> getCars(){
        return carService.getCars();
    }

}