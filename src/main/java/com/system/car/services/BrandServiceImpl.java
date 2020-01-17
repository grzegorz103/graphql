package com.system.car.services;

import com.system.car.dao.BrandRepository;
import com.system.car.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand create(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setVehicles(new ArrayList<>());
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Long id, String name) {
        Brand brand = brandRepository.findById(id).get();
        brand.setName(name);
        return brandRepository.save(brand);
    }

    @Override
    public Long delete(Long id) {
        brandRepository.deleteById(id);
        return id;
    }

}
