package com.system.car.mappers;

import com.system.car.dto.VehicleOut;
import com.system.car.models.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = BrandMapper.class)
public interface VehicleMapper {

    @Mapping(target = "subType", expression = "java(vehicle.getClass().getSimpleName())")
    VehicleOut toDTO(Vehicle vehicle);

}
