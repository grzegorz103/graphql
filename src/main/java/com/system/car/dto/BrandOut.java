package com.system.car.dto;

import com.system.car.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandOut {

    private Long id;

    private String name;
}
