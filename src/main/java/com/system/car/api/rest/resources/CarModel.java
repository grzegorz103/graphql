package com.system.car.api.rest.resources;

import com.system.car.models.Brand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CarModel extends VehicleModel {

    public CarModel(Brand brand, String model, Integer year, List<String> images, String info) {
        super(brand, model, year, images, info);
    }
}
