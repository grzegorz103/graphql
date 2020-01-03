package com.system.car.services;

import com.system.car.models.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand create(String name);
}
