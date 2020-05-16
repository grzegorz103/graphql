package com.system.car.api.rest.utils;

import com.system.car.api.rest.controllers.BrandController;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.models.Vehicle;
import org.springframework.stereotype.Component;

import static com.system.car.api.rest.utils.Constants.BRAND_LINK_NAME;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LinkUtils {

    public void addBrandLink(Vehicle vehicle, VehicleModel vehicleModel) {
        if (vehicle.getBrand() != null) {
            vehicleModel.add(
                    linkTo(
                            methodOn(BrandController.class)
                                    .getById(vehicle.getBrand().getId())
                    ).withRel(BRAND_LINK_NAME)
            );
        }
    }

}
