package com.system.car.services.abstr;

import com.system.car.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getById(Long id);

    Brand create(String name);

    Brand update(Long id, String name);

    Long delete(Long id);

    Page<Brand> getAllPaged(Pageable pageable);
}
