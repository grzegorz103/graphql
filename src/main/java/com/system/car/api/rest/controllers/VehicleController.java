package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.VehicleModelAssembler;
import com.system.car.api.rest.resources.CarModel;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.models.Vehicle;
import com.system.car.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    private final VehicleModelAssembler vehicleModelAssembler;

    private final PagedResourcesAssembler<Vehicle> pagedResourcesAssembler;

    public VehicleController(VehicleService vehicleService,
                             VehicleModelAssembler vehicleModelAssembler,
                             PagedResourcesAssembler<Vehicle> pagedResourcesAssembler) {
        this.vehicleService = vehicleService;
        this.vehicleModelAssembler = vehicleModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public CollectionModel<VehicleModel> getAll(Pageable pageable) {
        return pagedResourcesAssembler.toModel(vehicleService.getAllPaged(pageable), vehicleModelAssembler);
    }

    @GetMapping("/{id}")
    public VehicleModel getById(@PathVariable("id") Long id) {
        return vehicleModelAssembler.toModel(vehicleService.getById(id));
    }

}
