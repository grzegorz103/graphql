package com.system.car.api.rest.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.system.car.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandModel extends RepresentationModel<BrandModel> {

    private Long id;

    public List<Vehicle> vehicles;

    private String name;

}
