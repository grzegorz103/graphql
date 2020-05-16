package com.system.car.services.impl;

import com.system.car.api.rest.exception.ExceptionFactory;
import com.system.car.api.rest.exception.ExceptionType;
import com.system.car.dao.BrandRepository;
import com.system.car.models.Brand;
import com.system.car.services.abstr.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return brandRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Brand.class.getSimpleName(), id));
    }

    @Override
    @Transactional
    public Brand create(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setVehicles(new ArrayList<>());
        return brandRepository.save(brand);
    }

    @Override
    @Transactional
    public Brand update(Long id, String name) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Brand.class.getSimpleName(), id));
        brand.setName(name);
        return brandRepository.save(brand);
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        if (!brandRepository.existsById(id))
            throw ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Brand.class.getSimpleName(), id);

        brandRepository.deleteById(id);
        return id;
    }

    @Override
    public Page<Brand> getAllPaged(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

}
