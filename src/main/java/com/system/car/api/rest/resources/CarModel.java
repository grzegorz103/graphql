package com.system.car.api.rest.resources;

import com.system.car.models.Brand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Relation(collectionRelation = "cars")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CarModel extends VehicleModel {

    public CarModel(BrandModel brand, String model, Integer year, List<String> images, String info) {
        super(brand, model, year, images, info);
    }

}
