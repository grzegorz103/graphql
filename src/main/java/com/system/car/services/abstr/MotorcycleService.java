package com.system.car.services.abstr;

import com.system.car.models.Motorcycle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MotorcycleService {

    List<Motorcycle> getAll();

    Motorcycle create(String model, int year, List<String> images, String info, Long brandId);

    Motorcycle update(Long id, String model, int year, Long brandId);

    Long delete(Long id);

    Motorcycle getById(Long id);

    Page<Motorcycle> getAllPaged(Pageable pageable);
}
