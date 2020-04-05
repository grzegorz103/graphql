package com.system.car.api.rest.resources;

import com.system.car.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModel extends RepresentationModel<VehicleModel> {

    private BrandModel brand;

    private String model;

    private Integer year;

    private List<String> images;

    private String info;

}
