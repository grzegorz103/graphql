package com.system.car.api.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.api.graphql.dto.VehicleOut;
import com.system.car.api.graphql.mappers.VehicleMapper;
import com.system.car.services.VehicleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    private final VehicleMapper vehicleMapper;

    public VehicleQuery(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    public List<VehicleOut> getVehicles() {
        return vehicleService.getAll().stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
