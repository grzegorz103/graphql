package com.system.car.api.rest.mappers;

import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.models.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BrandModelMapper.class)
public interface VehicleModelMapper {

    VehicleModel toDto(Vehicle vehicle);

}
