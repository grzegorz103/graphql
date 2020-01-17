package com.system.car.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.models.Vehicle;
import com.system.car.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    public VehicleQuery(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public List<Vehicle> getVehicles(){
        return vehicleService.getAll();
    }
}
