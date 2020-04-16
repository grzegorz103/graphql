package com.system.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car extends Vehicle {

    public Car(Long id, Brand brand, String model, Integer year, List<String> images, String info) {
        super(id, brand, model, year, images, info);
    }

}
