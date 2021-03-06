package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.CarModelAssembler;
import com.system.car.api.rest.dto.in.CarIn;
import com.system.car.api.rest.resources.CarModel;
import com.system.car.models.Car;
import com.system.car.services.abstr.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.system.car.api.rest.utils.Constants.API_VERSION;

@RestController
@RequestMapping(value = API_VERSION + "cars", produces = {"application/hal+json"})
public class CarController {

    private final CarService carService;

    private final CarModelAssembler carModelAssembler;

    private final PagedResourcesAssembler<Car> pagedResourcesAssembler;

    public CarController(CarService carService,
                         CarModelAssembler carModelAssembler,
                         PagedResourcesAssembler<Car> pagedResourcesAssembler) {
        this.carService = carService;
        this.carModelAssembler = carModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping("/{id}")
    public CarModel getById(@PathVariable("id") Long id) {
        return carModelAssembler.toModel(carService.getCarById(id));
    }

    @GetMapping
    public CollectionModel<CarModel> getAll(Pageable pageable) {
        return pagedResourcesAssembler.toModel(carService.getCarsPaged(pageable), carModelAssembler);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel create(@RequestBody @Valid CarIn carIn) {
        Car car1 = carService.create(carIn.getModel(), carIn.getYear(), carIn.getImages(), carIn.getInfo(), carIn.getBrandId());
        return carModelAssembler.toModel(car1);
    }

    @PutMapping("/{id}")
    public CarModel update(@PathVariable("id") Long id,
                           @RequestBody @Valid CarIn car) {
        return carModelAssembler.toModel(carService.update(id, car.getModel(), car.getYear(), car.getBrandId()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        carService.delete(id);
    }

}
