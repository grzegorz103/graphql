package com.system.car.mutations;

import com.system.car.models.Motorcycle;
import com.system.car.services.MotorcycleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MotorcycleMutationTest {

    @Mock
    private MotorcycleService motorcycleService;

    @InjectMocks
    private MotorcycleMutation motorcycleMutation;

    @Test
    public void createTest() {
        Motorcycle mocked = mock(Motorcycle.class);
        when(motorcycleService.create(anyString(), anyInt())).thenReturn(mocked);
        assertThat(motorcycleMutation.createMotorcycle(anyString(), anyInt())).isNotNull();
    }

}