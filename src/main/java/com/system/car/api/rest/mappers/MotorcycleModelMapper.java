package com.system.car.api.rest.mappers;

import com.system.car.api.rest.resources.MotorcycleModel;
import com.system.car.models.Motorcycle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BrandModelMapper.class)
public interface MotorcycleModelMapper {

    MotorcycleModel toDto(Motorcycle motorcycle);

}
