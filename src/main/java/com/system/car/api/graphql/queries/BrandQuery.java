package com.system.car.api.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.system.car.models.Brand;
import com.system.car.services.abstr.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandQuery implements GraphQLQueryResolver {

    private final BrandService brandService;

    @Autowired
    public BrandQuery(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Brand> getBrands() {
        return brandService.getAll();
    }

}
