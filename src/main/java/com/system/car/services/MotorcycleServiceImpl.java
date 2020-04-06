package com.system.car.services;

import com.system.car.dao.MotorcycleRepository;
import com.system.car.models.Motorcycle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Motorcycle update(Long id, String model, int year, Long brandId) {
        Motorcycle motorcycle = motorcycleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        motorcycle.setYear(year);
        motorcycle.setModel(model);
        motorcycle.setBrand(brandService.getById(brandId));

        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public Long delete(Long id) {
        if (motorcycleRepository.existsById(id)) {
            motorcycleRepository.deleteById(id);
            return id;
        } else {
            throw new RuntimeException("Not found");
        }
    }

    @Override
    public Motorcycle getById(Long id) {
        return motorcycleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Page<Motorcycle> getAllPaged(Pageable pageable) {
        return motorcycleRepository.findAll(pageable);
    }
}
