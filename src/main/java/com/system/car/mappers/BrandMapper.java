package com.system.car.mappers;

import com.system.car.dto.BrandOut;
import com.system.car.models.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandOut toDTO(Brand brand);

}
