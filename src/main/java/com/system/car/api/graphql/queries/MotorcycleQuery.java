package com.system.car.api.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotorcycleQuery implements GraphQLQueryResolver {

    private final MotorcycleService motorcycleService;

    public MotorcycleQuery(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getAll();
    }

    public Motorcycle getMotorcycleById(Long id) {
        return motorcycleService.getById(id);
    }
}
