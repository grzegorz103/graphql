package com.system.car.api.graphql.mappers;

import com.system.car.api.graphql.dto.VehicleOut;
import com.system.car.models.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BrandMapper.class)
public interface VehicleMapper {

    @Mapping(target = "subType", expression = "java(vehicle.getClass().getSimpleName())")
    VehicleOut toDTO(Vehicle vehicle);

}
