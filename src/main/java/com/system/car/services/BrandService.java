package com.system.car.services;

import com.system.car.models.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getById(Long id);

    Brand create(String name);

    Brand update(Long id, String name);

    Long delete(Long id);
}
