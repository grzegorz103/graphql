package com.system.car.api.rest;

import com.system.car.dto.CarOut;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return carService.create(car.getModel(), car.getYear(), car.getImages(), car.getInfo(), car.getBrand().getId());
    }

    @PutMapping("/id")
    public Car update(@PathVariable("id") Long id,
                      @RequestBody Car car) {
        return carService.update(id, car.getModel(), car.getYear(), car.getBrand().getId());
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Long id) {
        carService.delete(id);
    }

}
