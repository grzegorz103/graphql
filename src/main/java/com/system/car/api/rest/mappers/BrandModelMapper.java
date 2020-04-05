package com.system.car.api.rest.mappers;

import com.system.car.api.rest.resources.BrandModel;
import com.system.car.models.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandModelMapper {

    BrandModel toDto(Brand brand);

}
