package com.system.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleOut {
    private Long id;

    private BrandOut brand;

    private String model;

    private Integer year;

    private List<String> images;

    private String subType;
}
