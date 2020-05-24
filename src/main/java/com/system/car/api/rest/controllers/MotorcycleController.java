package com.system.car.api.rest.controllers;

import com.system.car.api.rest.assemblers.MotorcycleModelAssembler;
import com.system.car.api.rest.dto.in.MotorcycleIn;
import com.system.car.api.rest.resources.MotorcycleModel;
import com.system.car.models.Motorcycle;
import com.system.car.services.abstr.MotorcycleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.system.car.api.rest.utils.Constants.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    private final MotorcycleModelAssembler motorcycleModelAssembler;

    private final PagedResourcesAssembler<Motorcycle> pagedResourcesAssembler;

    public MotorcycleController(MotorcycleService motorcycleService,
                                MotorcycleModelAssembler motorcycleModelAssembler,
                                PagedResourcesAssembler<Motorcycle> pagedResourcesAssembler) {
        this.motorcycleService = motorcycleService;
        this.motorcycleModelAssembler = motorcycleModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping("/{id}")
    public MotorcycleModel getById(@PathVariable("id") Long id) {
        return motorcycleModelAssembler.toModel(motorcycleService.getById(id));
    }

    @GetMapping
    public CollectionModel<MotorcycleModel> getAll(Pageable pageable) {
        return pagedResourcesAssembler.toModel(motorcycleService.getAllPaged(pageable), motorcycleModelAssembler);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotorcycleModel create(@RequestBody @Valid MotorcycleIn motorcycle) {
        return motorcycleModelAssembler.toModel(
                motorcycleService.create(motorcycle.getModel(), motorcycle.getYear(), motorcycle.getImages(), motorcycle.getInfo(), motorcycle.getBrandId())
        );
    }

    @PutMapping("/{id}")
    public MotorcycleModel update(@PathVariable("id") Long id,
                                  @RequestBody @Valid MotorcycleIn motorcycle) {
        return motorcycleModelAssembler.toModel(
                motorcycleService.update(id, motorcycle.getModel(), motorcycle.getYear(), motorcycle.getBrandId())
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        motorcycleService.delete(id);
    }

}
