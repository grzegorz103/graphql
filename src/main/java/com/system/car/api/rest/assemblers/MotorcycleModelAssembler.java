package com.system.car.api.rest.assemblers;

import com.system.car.api.rest.controllers.CarController;
import com.system.car.api.rest.controllers.MotorcycleController;
import com.system.car.api.rest.mappers.MotorcycleModelMapper;
import com.system.car.api.rest.resources.MotorcycleModel;
import com.system.car.api.rest.utils.LinkUtils;
import com.system.car.models.Motorcycle;
import org.jetbrains.annotations.NotNull;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MotorcycleModelAssembler extends RepresentationModelAssemblerSupport<Motorcycle, MotorcycleModel> {

    private final MotorcycleModelMapper motorcycleModelMapper;

    private final LinkUtils linkUtils;

    public MotorcycleModelAssembler(MotorcycleModelMapper motorcycleModelMapper, LinkUtils linkUtils) {
        super(MotorcycleController.class, MotorcycleModel.class);
        this.motorcycleModelMapper = motorcycleModelMapper;
        this.linkUtils = linkUtils;
    }

    @NotNull
    @Override
    public MotorcycleModel toModel(@NotNull Motorcycle entity) {
        MotorcycleModel motorcycleModel = motorcycleModelMapper.toDto(entity);

        motorcycleModel.add(
                linkTo(methodOn(CarController.class)
                        .getById(entity.getId())
                ).withSelfRel()
        );

        linkUtils.addBrandLink(entity, motorcycleModel);

        return motorcycleModel;
    }

}
