package com.system.car.services;

import com.system.car.dao.VehicleRepository;
import com.system.car.models.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void getAllTest() {
        when(vehicleRepository.findAll()).thenReturn(Arrays.asList(mock(Vehicle.class), mock(Vehicle.class)));

        assertThat(vehicleService.getAll()).isEqualTo(vehicleRepository.findAll());
    }
}