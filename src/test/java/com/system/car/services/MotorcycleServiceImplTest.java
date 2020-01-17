package com.system.car.services;

import com.system.car.dao.MotorcycleRepository;
import com.system.car.models.Motorcycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MotorcycleServiceImplTest {

    @Mock
    private MotorcycleRepository motorcycleRepository;

    @InjectMocks
    private MotorcycleServiceImpl motorcycleService;

    @Test
    public void getAllTest() {
        List<Motorcycle> list = Arrays.asList(mock(Motorcycle.class), mock(Motorcycle.class));
        when(motorcycleRepository.findAll()).thenReturn(list);

        assertThat(motorcycleService.getAll()).isEqualTo(list);
        verify(motorcycleRepository, times(1)).findAll();
    }

    @Test
    public void createTest() {
        Motorcycle mocked = mock(Motorcycle.class);
        when(motorcycleRepository.save(any(Motorcycle.class))).thenReturn(mocked);

        assertThat(motorcycleService.create(mocked.getModel(), mocked.getYear())).isEqualTo(mocked);
        verify(motorcycleRepository, times(1)).save(any(Motorcycle.class));
    }

    @Test
    public void updateTest() {
        Motorcycle mocked = mock(Motorcycle.class);
        when(motorcycleRepository.save(any(Motorcycle.class))).thenReturn(mocked);
        when(motorcycleRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(mocked));

        assertThat(motorcycleService.update(mocked.getId(), mocked.getModel(), mocked.getYear())).isEqualTo(mocked);
        verify(motorcycleRepository, times(1)).save(any(Motorcycle.class));
    }

    @Test
    public void deleteTest() {
        Motorcycle motorcycle = mock(Motorcycle.class);
        when(motorcycleRepository.existsById(anyLong())).thenReturn(true);

        assertThat(motorcycleService.delete(motorcycle.getId())).isEqualTo(motorcycle.getId());
        verify(motorcycleRepository, times(1)).deleteById(motorcycle.getId());
    }
}