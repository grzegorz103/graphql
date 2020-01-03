package com.system.car.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.system.car.models.Brand;
import com.system.car.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandMutation implements GraphQLMutationResolver {

    private final BrandService brandService;

    @Autowired
    public BrandMutation(BrandService brandService) {
        this.brandService = brandService;
    }

    public Brand createBrand(String name) {
        return brandService.create(name);
    }

    public Brand updateBrand(Long id, String name) {
        return brandService.update(id, name);
    }

    public Long deleteBrand(Long id) {
        return brandService.delete(id);
    }
}
