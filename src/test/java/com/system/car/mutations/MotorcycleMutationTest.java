package com.system.car.mutations;

import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MotorcycleMutationTest {

    @Mock
    private MotorcycleService motorcycleService;

    @InjectMocks
    private MotorcycleMutation motorcycleMutation;

    @Test
    public void createTest() {
        Motorcycle mocked = mock(Motorcycle.class);
        when(motorcycleService.create(anyString(), anyInt(), anyList(), anyString(), anyLong())).thenReturn(mocked);
        assertThat(motorcycleMutation.createMotorcycle(anyString(), anyInt(), anyList(), anyString(), anyLong())).isNotNull();
    }

    @Test
    public void updateTest() {
        Motorcycle mocked = mock(Motorcycle.class);
        when(motorcycleService.update(anyLong(), anyString(), anyInt(), anyLong())).thenReturn(mocked);

        assertThat(motorcycleMutation.updateMotorcycle(anyLong(), anyString(), anyInt(), anyLong())).isEqualTo(mocked);
        verify(motorcycleService, times(1)).update(anyLong(), anyString(), anyInt(), anyLong());
    }

    @Test
    public void deleteTest() {
        Motorcycle mocked = mock(Motorcycle.class);

        assertThat(motorcycleMutation.deleteMotorcycle(mocked.getId())).isEqualTo(mocked.getId());
        verify(motorcycleService, times(1)).delete(anyLong());
    }
}
