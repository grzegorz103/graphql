package com.system.car.api.rest.utils;

import com.system.car.api.rest.assemblers.BrandModelAssembler;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.models.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class LinkUtils {

    private final BrandModelAssembler brandModelAssembler;

    public LinkUtils(BrandModelAssembler brandModelAssembler) {
        this.brandModelAssembler = brandModelAssembler;
    }

    public void addBrandLink(Vehicle vehicle, VehicleModel vehicleModel) {
        if (vehicle.getBrand() != null) {
            vehicleModel.setBrand(brandModelAssembler.toModel(vehicle.getBrand()));
        }
    }

}
