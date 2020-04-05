package com.system.car.api.rest;

import com.system.car.api.rest.assemblers.BrandModelAssembler;
import com.system.car.api.rest.resources.BrandModel;
import com.system.car.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    private final BrandModelAssembler brandModelAssembler;

    public BrandController(BrandService brandService, BrandModelAssembler brandModelAssembler) {
        this.brandService = brandService;
        this.brandModelAssembler = brandModelAssembler;
    }

    @GetMapping("/{id}")
    public BrandModel getById(@PathVariable("id") Long id) {
        return brandModelAssembler.toModel(brandService.getById(id));
    }

    @GetMapping
    public CollectionModel<BrandModel> getAll() {
        return brandModelAssembler.toCollectionModel(brandService.getAll());
    }

    @PostMapping
    public BrandModel create(@RequestBody String name){
        return brandModelAssembler.toModel(brandService.create(name));
    }

}
