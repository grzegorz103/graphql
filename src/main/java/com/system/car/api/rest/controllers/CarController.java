package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.CarModelAssembler;
import com.system.car.api.rest.resources.CarModel;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/cars", produces = {"application/hal+json"})
public class CarController {

    private final CarService carService;

    private final CarModelAssembler carModelAssembler;

    public CarController(CarService carService,
                         CarModelAssembler carModelAssembler) {
        this.carService = carService;
        this.carModelAssembler = carModelAssembler;
    }

    @GetMapping("/{id}")
    public CarModel getById(@PathVariable("id") Long id) {
        return carModelAssembler.toModel(carService.getCarById(id));
    }

    @GetMapping
    public CollectionModel<CarModel> getAll() {
        return carModelAssembler.toCollectionModel(carService.getCars());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel create(@RequestBody Car car) {
        return carModelAssembler.toModel(carService.create(car.getModel(), car.getYear(), car.getImages(), car.getInfo(), car.getBrand().getId()));
    }

    @PutMapping("/id")
    public CarModel update(@PathVariable("id") Long id,
                           @RequestBody Car car) {
        return carModelAssembler.toModel(carService.update(id, car.getModel(), car.getYear(), car.getBrand().getId()));
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Long id) {
        carService.delete(id);
    }

}
