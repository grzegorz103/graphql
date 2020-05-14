package com.system.car.services;

import com.system.car.api.rest.exception.ExceptionFactory;
import com.system.car.api.rest.exception.ExceptionType;
import com.system.car.dao.MotorcycleRepository;
import com.system.car.models.Motorcycle;
import com.system.car.services.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    private final BrandService brandService;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository,
                                 BrandService brandService) {
        this.motorcycleRepository = motorcycleRepository;
        this.brandService = brandService;
    }


    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = Constants.MOTORCYCLE_CACHE_NAME, allEntries = true)
    public Motorcycle create(String model, int year, List<String> images, String info, Long brandId) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setModel(model);
        motorcycle.setYear(year);
        motorcycle.setInfo(info);
        motorcycle.setImages(images.stream().filter(e -> !StringUtils.isBlank(e)).collect(Collectors.toList()));
        motorcycle.setBrand(brandService.getById(brandId));
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = Constants.MOTORCYCLE_CACHE_NAME, allEntries = true)
    public Motorcycle update(Long id, String model, int year, Long brandId) {
        Motorcycle motorcycle = motorcycleRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Motorcycle.class.getSimpleName(), id));
        motorcycle.setYear(year);
        motorcycle.setModel(model);
        motorcycle.setBrand(brandService.getById(brandId));

        return motorcycleRepository.save(motorcycle);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = Constants.MOTORCYCLE_CACHE_NAME, allEntries = true)
    public Long delete(Long id) {
        if (motorcycleRepository.existsById(id)) {
            motorcycleRepository.deleteById(id);
            return id;
        } else {
            throw ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Motorcycle.class.getSimpleName(), id);
        }
    }

    @Override
    @Cacheable(cacheNames = Constants.MOTORCYCLE_CACHE_NAME, key = "#id")
    public Motorcycle getById(Long id) {
        return motorcycleRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.create(ExceptionType.HTTP_NOT_FOUND, Motorcycle.class.getSimpleName(), id));
    }

    @Override
    @Cacheable(cacheNames = Constants.MOTORCYCLE_CACHE_NAME)
    public Page<Motorcycle> getAllPaged(Pageable pageable) {
        return motorcycleRepository.findAll(pageable);
    }
}
