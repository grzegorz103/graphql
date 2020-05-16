package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.BrandModelAssembler;
import com.system.car.api.rest.assemblers.VehicleModelAssembler;
import com.system.car.api.rest.dto.in.BrandIn;
import com.system.car.api.rest.resources.BrandModel;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.models.Brand;
import com.system.car.models.Vehicle;
import com.system.car.services.abstr.BrandService;
import com.system.car.services.abstr.VehicleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.system.car.api.rest.utils.Constants.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "brands")
public class BrandController {

    private final BrandService brandService;

    private final BrandModelAssembler brandModelAssembler;

    private final PagedResourcesAssembler<Brand> pagedResourcesAssembler;

    private final VehicleModelAssembler vehicleModelAssembler;

    private final PagedResourcesAssembler<Vehicle> vehiclePagedResourcesAssembler;

    private final VehicleService vehicleService;

    public BrandController(BrandService brandService,
                           BrandModelAssembler brandModelAssembler,
                           PagedResourcesAssembler<Brand> pagedResourcesAssembler,
                           VehicleModelAssembler vehicleModelAssembler,
                           PagedResourcesAssembler<Vehicle> vehiclePagedResourcesAssembler,
                           VehicleService vehicleService) {
        this.brandService = brandService;
        this.brandModelAssembler = brandModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.vehicleModelAssembler = vehicleModelAssembler;
        this.vehiclePagedResourcesAssembler = vehiclePagedResourcesAssembler;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public BrandModel getById(@PathVariable("id") Long id) {
        return brandModelAssembler.toModel(brandService.getById(id));
    }

    @GetMapping
    public CollectionModel<BrandModel> getAll(Pageable pageable) {
        return pagedResourcesAssembler.toModel(brandService.getAllPaged(pageable), brandModelAssembler);
    }

    @PostMapping
    public BrandModel create(@RequestBody @Valid BrandIn brandIn) {
        return brandModelAssembler.toModel(brandService.create(brandIn.getName()));
    }

    @GetMapping("/{id}/vehicles")
    public CollectionModel<VehicleModel> getVehiclesByBrandId(@PathVariable("id") Long id,
                                                              Pageable pageable) {
        return vehiclePagedResourcesAssembler.toModel(vehicleService.getVehiclesByBrandId(id, pageable), vehicleModelAssembler);
    }

}
