package com.system.car.api.graphql.mutations;

import com.system.car.models.Brand;
import com.system.car.services.abstr.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BrandMutationTest {

    @Mock
    private BrandService brandService;

    @InjectMocks
    private BrandMutation brandMutation;

    @Test
    public void createBrandTest() {
        Brand mocked = mock(Brand.class);
        when(brandService.create(anyString())).thenReturn(mocked);

        assertThat(brandMutation.createBrand("test")).isEqualTo(mocked);
        verify(brandService, times(1)).create(anyString());
    }

    @Test
    public void updateBrandTest() {
        Brand mocked = mock(Brand.class);
        when(brandService.update(anyLong(), anyString())).thenReturn(mocked);

        assertThat(brandMutation.updateBrand(1L, "test")).isEqualTo(mocked);
        verify(brandService, times(1)).update(1L, "test");
    }

    @Test
    public void deleteBrandTest(){
        long deletedId = 1L;
        when(brandService.delete(anyLong())).thenReturn(deletedId);

        assertThat(brandMutation.deleteBrand(deletedId)).isEqualTo(deletedId);
        verify(brandService, times(1)).delete(deletedId);
    }
}
