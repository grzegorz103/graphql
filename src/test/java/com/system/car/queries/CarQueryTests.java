package com.system.car.queries;

import com.system.car.models.Car;
import com.system.car.services.CarService;
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
public class CarQueryTests {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarQuery carQuery;

    private List<Car> cars;

    @Before
    public void setup() {
        cars = Arrays.asList(mock(Car.class), mock(Car.class));
        when(carService.getCars()).thenReturn(cars);
    }

    @Test
    public void getAllTest() {
        assertThat(carQuery.getCars()).isEqualTo(cars);
        assertThat(carQuery.getCars().size()).isEqualTo(cars.size());
    }

}
