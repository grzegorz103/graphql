package com.system.car.api.rest;

import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping("/{id}")
    public Motorcycle getById(@PathVariable("id") Long id) {
        return motorcycleService.getById(id);
    }

    @GetMapping
    public List<Motorcycle> getAll() {
        return motorcycleService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motorcycle create(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.create(motorcycle.getModel(), motorcycle.getYear(), motorcycle.getImages(), motorcycle.getInfo(), motorcycle.getBrand().getId());
    }

    @PutMapping("/id")
    public Motorcycle update(@PathVariable("id") Long id,
                             @RequestBody Motorcycle motorcycle) {
        return motorcycleService.update(id, motorcycle.getModel(), motorcycle.getYear(), motorcycle.getBrand().getId());
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Long id) {
        motorcycleService.delete(id);
    }

}
