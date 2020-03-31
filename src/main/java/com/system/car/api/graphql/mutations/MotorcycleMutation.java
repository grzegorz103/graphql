package com.system.car.api.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotorcycleMutation implements GraphQLMutationResolver {

    private final MotorcycleService motorcycleService;

    public MotorcycleMutation(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    public Motorcycle createMotorcycle(String model, int year, List<String> images, String info, Long brandId) {
        return motorcycleService.create(model, year, images, info, brandId);
    }

    public Motorcycle updateMotorcycle(Long id, String model, int year, Long brandId) {
        return motorcycleService.update(id, model, year, brandId);
    }

    public Long deleteMotorcycle(Long id) {
        return motorcycleService.delete(id);
    }
}
