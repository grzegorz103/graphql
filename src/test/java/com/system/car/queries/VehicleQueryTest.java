package com.system.car.queries;

import com.system.car.models.Vehicle;
import com.system.car.services.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VehicleQueryTest {

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleQuery vehicleQuery;

    @Test
    public void getVehiclesTest() {
        when(vehicleService.getAll()).thenReturn(Arrays.asList(mock(Vehicle.class), mock(Vehicle.class)));

        assertThat(vehicleQuery.getVehicles()).isEqualTo(vehicleService.getAll());
    }
}