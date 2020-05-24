package com.system.car.api.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.car.api.rest.dto.in.CarIn;
import com.system.car.models.Brand;
import com.system.car.models.Car;
import com.system.car.services.abstr.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    private final String carApiURL = "/api/v1/cars";

    @Test
    void getById() throws Exception {
        when(carService.getCarById(anyLong())).thenReturn(mock(Car.class));
        mockMvc.perform(get(carApiURL + "/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        when(carService.getCarsPaged(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(mock(Car.class), mock(Car.class))));
        mockMvc.perform(get(carApiURL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        CarIn car = new CarIn(1L, "test", 2000, Collections.emptyList(), "test");
        when(carService.create(anyString(), anyInt(), anyList(), anyString(), anyLong()))
                .thenReturn(mock(Car.class));
        mockMvc.perform(post(carApiURL)
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        CarIn car = new CarIn(1L, "test", 2000, Collections.emptyList(), "test");
        when(carService.update(anyLong(), anyString(), anyInt(), anyLong()))
                .thenReturn(mock(Car.class));
        mockMvc.perform(put(carApiURL + "/1")
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        when(carService.delete(anyLong())).thenReturn(1L);
        mockMvc.perform(delete(carApiURL + "/1"))
                .andExpect(status().isOk());
    }
}
