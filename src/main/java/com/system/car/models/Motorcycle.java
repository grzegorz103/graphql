package com.system.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
