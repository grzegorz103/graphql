package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.VehicleModelAssembler;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    private final VehicleModelAssembler vehicleModelAssembler;

    public VehicleController(VehicleService vehicleService, VehicleModelAssembler vehicleModelAssembler) {
        this.vehicleService = vehicleService;
        this.vehicleModelAssembler = vehicleModelAssembler;
    }

    @GetMapping
    public CollectionModel<VehicleModel> getAll() {
        return vehicleModelAssembler.toCollectionModel(vehicleService.getAll());
    }

    @GetMapping("/{id}")
    public VehicleModel getById(@PathVariable("id") Long id){
        return vehicleModelAssembler.toModel(vehicleService.getById(id));
    }

}
