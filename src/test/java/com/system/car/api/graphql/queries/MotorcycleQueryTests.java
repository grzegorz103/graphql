package com.system.car.api.graphql.queries;

import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MotorcycleQueryTests {

    @Mock
    private MotorcycleService motorcycleService;

    @InjectMocks
    private MotorcycleQuery motorcycleQuery;

    @Test
    public void getAllTest() {
        List<Motorcycle> list = Arrays.asList(mock(Motorcycle.class), mock(Motorcycle.class));
        when(motorcycleService.getAll()).thenReturn(list);

        assertThat(motorcycleQuery.getMotorcycles()).isEqualTo(list);
        verify(motorcycleService, times(1)).getAll();
    }

    @Test
    public void getByIdTest(){
        Motorcycle mocked = mock(Motorcycle.class);

        when(motorcycleService.getById(anyLong())).thenReturn(mocked);
        assertThat(motorcycleQuery.getMotorcycleById(1L)).isEqualTo(mocked);
        verify(motorcycleService, times(1)).getById(anyLong());
    }
}
