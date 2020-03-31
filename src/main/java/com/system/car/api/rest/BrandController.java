package com.system.car.api.rest;
import com.system.car.models.Brand;
import com.system.car.models.Motorcycle;
import com.system.car.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable("id") Long id) {
        return brandService.getById(id);
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

}
