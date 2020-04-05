package com.system.car.api.rest.mappers;

import com.system.car.api.rest.resources.CarModel;
import com.system.car.models.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarModelMapper {

    CarModel toDto(Car car);

}
