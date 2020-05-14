package com.system.car.services;

import com.system.car.dao.BrandRepository;
import com.system.car.models.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceImplTest {

    @InjectMocks
    private BrandServiceImpl brandService;

    @Mock
    private BrandRepository brandRepository;

    @Test
    public void createTest() {
        Brand mocked = mock(Brand.class);
        when(brandRepository.save(any(Brand.class))).thenReturn(mocked);
        assertThat(brandService.create(anyString())).isEqualTo(mocked);
        verify(brandRepository, times(1)).save(any());
    }

    @Test
    public void getAllTest() {
        List<Brand> mocked = Arrays.asList(mock(Brand.class), mock(Brand.class));
        when(brandRepository.findAll()).thenReturn(mocked);
        assertThat(brandService.getAll()).isEqualTo(mocked);
        verify(brandRepository, times(1)).findAll();
    }

    @Test
    public void getByIdTest() {
        Brand mocked = mock(Brand.class);
        when(brandRepository.findById(anyLong())).thenReturn(Optional.of(mocked));
        assertThat(brandService.getById(1L)).isEqualTo(mocked);
        verify(brandRepository, times(1)).findById(anyLong());
    }

    @Test
    public void updateTest() {
        Brand mocked = mock(Brand.class);
        when(brandRepository.findById(anyLong())).thenReturn(Optional.ofNullable(mocked));
        when(brandRepository.save(any(Brand.class))).thenReturn(mocked);
        assertThat(brandService.update(mocked.getId(), mocked.getName())).isEqualTo(mocked);
        verify(brandRepository, times(1)).save(any());
    }

    @Test
    public void deleteTest(){
        Brand mocked = mock(Brand.class);
        when(brandRepository.existsById(anyLong())).thenReturn(true);
        assertThat(brandService.delete(mocked.getId())).isEqualTo(mocked.getId());
        verify(brandRepository, times(1)).deleteById(mocked.getId());
    }

}
