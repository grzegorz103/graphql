package com.system.car.api.rest.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "motorcycles")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MotorcycleModel extends VehicleModel{
}
