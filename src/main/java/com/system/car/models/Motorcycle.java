package com.system.car.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "motorcycles")
@NoArgsConstructor
@Data
public class Motorcycle extends Vehicle {

    public Motorcycle(Long id, Brand brand, String model, Integer year, List<String> images, String info) {
        super(id, brand, model, year, images, info);
    }

}
