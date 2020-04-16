package com.system.car.api.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.car.models.Brand;
import com.system.car.models.Car;
import com.system.car.services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
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
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void getById() throws Exception {
        when(carService.getCarById(anyLong())).thenReturn(mock(Car.class));
        mockMvc.perform(get("/api/v1/cars/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        when(carService.getCarsPaged(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(mock(Car.class), mock(Car.class))));
        mockMvc.perform(get("/api/v1/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        Car car = new Car(1L, new Brand(1L, null, "test"), "test", 1, Collections.emptyList(), "test");
        when(carService.create(anyString(), anyInt(), anyList(), anyString(), anyLong()))
                .thenReturn(mock(Car.class));
        mockMvc.perform(post("/api/v1/cars")
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        Car car = new Car(1L, new Brand(1L, null, "test"), "test", 1, Collections.emptyList(), "test");
        when(carService.update(anyLong(), anyString(), anyInt(), anyLong()))
                .thenReturn(mock(Car.class));
        mockMvc.perform(put("/api/v1/cars/1")
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        when(carService.delete(anyLong())).thenReturn(1L);
        mockMvc.perform(delete("/api/v1/cars/1"))
                .andExpect(status().isOk());
    }
}
