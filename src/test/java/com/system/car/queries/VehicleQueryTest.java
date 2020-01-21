package com.system.car.queries;

import com.system.car.mappers.BrandMapperImpl;
import com.system.car.mappers.VehicleMapperImpl;
import com.system.car.models.Brand;
import com.system.car.models.Vehicle;
import com.system.car.services.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleQueryTest {

    @MockBean
    private VehicleService vehicleService;

    @Autowired
    private VehicleQuery vehicleQuery;


    @Test
    public void getVehiclesTest() {
        when(vehicleService.getAll()).thenReturn(Arrays.asList(mock(Vehicle.class), mock(Vehicle.class)));

        assertThat(vehicleQuery.getVehicles().size()).isEqualTo(vehicleService.getAll().size());
    }
}