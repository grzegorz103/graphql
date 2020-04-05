package com.system.car.api.graphql.mappers;

import com.system.car.api.graphql.dto.BrandOut;
import com.system.car.models.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandOut toDTO(Brand brand);

}
