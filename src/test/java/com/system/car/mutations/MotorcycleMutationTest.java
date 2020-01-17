package com.system.car.mutations;

import com.system.car.services.MotorcycleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class MotorcycleMutationTest {

    @Mock
    private MotorcycleService motorcycleService;

    @InjectMocks
    private MotorcycleMutation motorcycleMutation;

    @Test
    public void createTest(){

        //assertThat(motorcycleMutation.create("model", 1999)).isEqualTo()
    }

}