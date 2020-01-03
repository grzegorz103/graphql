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
}
