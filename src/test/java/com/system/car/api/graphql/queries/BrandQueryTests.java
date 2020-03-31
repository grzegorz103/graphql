package com.system.car.api.graphql.queries;

import com.system.car.models.Brand;
import com.system.car.services.BrandService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BrandQueryTests {

    @Mock
    private BrandService brandService;

    @InjectMocks
    private BrandQuery brandQuery;

    private List<Brand> brands;

    @Before
    public void setup(){
        brands = Arrays.asList(mock(Brand.class), mock(Brand.class));
        when(brandService.getAll()).thenReturn(brands);
    }

    @Test
    public void getAllTest(){
        assertThat(brandQuery.getBrands()).isEqualTo(brands);
        assertThat(brandQuery.getBrands().size()).isEqualTo(brands.size());
    }

}
