package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.MotorcycleModelAssembler;
import com.system.car.api.rest.resources.MotorcycleModel;
import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @Autowired
    private MotorcycleModelAssembler motorcycleModelAssembler;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping("/{id}")
    public MotorcycleModel getById(@PathVariable("id") Long id) {
        return motorcycleModelAssembler.toModel(motorcycleService.getById(id));
    }

    @GetMapping
    public CollectionModel<MotorcycleModel> getAll() {
        return motorcycleModelAssembler.toCollectionModel(motorcycleService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotorcycleModel create(@RequestBody Motorcycle motorcycle) {
        return motorcycleModelAssembler.toModel(
                motorcycleService.create(motorcycle.getModel(), motorcycle.getYear(), motorcycle.getImages(), motorcycle.getInfo(), motorcycle.getBrand().getId())
        );
    }

    @PutMapping("/id")
    public MotorcycleModel update(@PathVariable("id") Long id,
                                  @RequestBody Motorcycle motorcycle) {
        return motorcycleModelAssembler.toModel(
                motorcycleService.update(id, motorcycle.getModel(), motorcycle.getYear(), motorcycle.getBrand().getId())
        );
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Long id) {
        motorcycleService.delete(id);
    }

}
