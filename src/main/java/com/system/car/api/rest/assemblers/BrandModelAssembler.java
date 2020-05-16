package com.system.car.api.rest.assemblers;

import com.system.car.api.rest.controllers.BrandController;
import com.system.car.api.rest.mappers.BrandModelMapper;
import com.system.car.api.rest.resources.BrandModel;
import com.system.car.api.rest.utils.Constants;
import com.system.car.models.Brand;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BrandModelAssembler extends RepresentationModelAssemblerSupport<Brand, BrandModel> {

    private final BrandModelMapper brandMapper;

    public BrandModelAssembler(BrandModelMapper brandMapper) {
        super(BrandController.class, BrandModel.class);
        this.brandMapper = brandMapper;
    }

    @NotNull
    @Override
    public BrandModel toModel(@NotNull Brand entity) {
        BrandModel brandModel = brandMapper.toDto(entity);
        brandModel.add(
                linkTo(
                        methodOn(BrandController.class)
                                .getById(entity.getId())
                ).withSelfRel(),
                linkTo(
                        methodOn(BrandController.class)
                                .getVehiclesByBrandId(entity.getId(), PageRequest.of(0, 10))
                ).withRel(Constants.VEHICLES_LINK_NAME)
        );

        return brandModel;
    }

    @NotNull
    @Override
    public CollectionModel<BrandModel> toCollectionModel(@NotNull Iterable<? extends Brand> entities) {
        CollectionModel<BrandModel> brandModels = super.toCollectionModel(entities);
        brandModels.add(
                linkTo(
                        methodOn(BrandController.class)
                                .getAll(Pageable.unpaged())
                ).withSelfRel()
        );

        return brandModels;
    }

}
