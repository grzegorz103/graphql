package com.system.car.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.dto.VehicleOut;
import com.system.car.mappers.VehicleMapper;
import com.system.car.models.Vehicle;
import com.system.car.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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
