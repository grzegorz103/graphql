package com.system.car.api.rest.assemblers;

import com.system.car.api.rest.controllers.CarController;
import com.system.car.api.rest.mappers.CarModelMapper;
import com.system.car.api.rest.resources.CarModel;
import com.system.car.api.rest.utils.LinkUtils;
import com.system.car.models.Car;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarModelAssembler extends RepresentationModelAssemblerSupport<Car, CarModel> {

    private final CarModelMapper carModelMapper;

    private final LinkUtils linkUtils;

    public CarModelAssembler(CarModelMapper carModelMapper,
                             LinkUtils linkUtils) {
        super(CarController.class, CarModel.class);
        this.carModelMapper = carModelMapper;
        this.linkUtils = linkUtils;
    }

    @NotNull
    @Override
    public CarModel toModel(@NotNull Car entity) {
        CarModel carModel = carModelMapper.toDto(entity);
        carModel.add(linkTo(
                methodOn(CarController.class)
                        .getById(entity.getId()))
                .withSelfRel());

        linkUtils.addBrandLink(entity, carModel);

        return carModel;
    }

    @NotNull
    @Override
    public CollectionModel<CarModel> toCollectionModel(@NotNull Iterable<? extends Car> entities) {
        CollectionModel<CarModel> carModels = super.toCollectionModel(entities);
        carModels.add(linkTo(
                methodOn(CarController.class)
                        .getAll(Pageable.unpaged())
        ).withSelfRel());

        return carModels;
    }

}
