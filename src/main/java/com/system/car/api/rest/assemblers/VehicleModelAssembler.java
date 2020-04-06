package com.system.car.api.rest.assemblers;

import com.system.car.api.rest.controllers.VehicleController;
import com.system.car.api.rest.mappers.VehicleModelMapper;
import com.system.car.api.rest.resources.CarModel;
import com.system.car.api.rest.resources.VehicleModel;
import com.system.car.api.rest.utils.LinkUtils;
import com.system.car.models.Car;
import com.system.car.models.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class VehicleModelAssembler extends RepresentationModelAssemblerSupport<Vehicle, VehicleModel> {

    private final VehicleModelMapper vehicleModelMapper;

    private final LinkUtils linkUtils;

    public VehicleModelAssembler(VehicleModelMapper vehicleModelMapper,
                                 LinkUtils linkUtils) {
        super(VehicleController.class, VehicleModel.class);
        this.vehicleModelMapper = vehicleModelMapper;
        this.linkUtils = linkUtils;
    }

    @NotNull
    @Override
    public VehicleModel toModel(@NotNull Vehicle entity) {
        VehicleModel vehicleModel = vehicleModelMapper.toDto(entity);

        vehicleModel.add(
                linkTo(methodOn(VehicleController.class).getById(entity.getId())).withSelfRel()
        );

        linkUtils.addBrandLink(entity, vehicleModel);

        return vehicleModel;
    }

    @NotNull
    @Override
    public CollectionModel<VehicleModel> toCollectionModel(@NotNull Iterable<? extends Vehicle> entities) {
        CollectionModel<VehicleModel> vehicleModels = super.toCollectionModel(entities);
        vehicleModels.add(
                linkTo(methodOn(VehicleController.class).getAll(Pageable.unpaged())).withSelfRel()
        );

        return vehicleModels;
    }
}
