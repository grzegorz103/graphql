package com.system.car.api.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.car.dao.BrandRepository;
import com.system.car.dao.CarRepository;
import com.system.car.models.Brand;
import com.system.car.models.Motorcycle;
import com.system.car.models.Motorcycle;
import com.system.car.services.abstr.CarService;
import com.system.car.services.abstr.MotorcycleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
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
class MotorcycleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MotorcycleService motorcycleService;

    private final String motorcycleApiURL = "/api/v1/motorcycles";

    @Test
    void getById() throws Exception {
        when(motorcycleService.getById(anyLong())).thenReturn(mock(Motorcycle.class));
        mockMvc.perform(get(motorcycleApiURL + "/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        when(motorcycleService.getAllPaged(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(mock(Motorcycle.class), mock(Motorcycle.class))));
        mockMvc.perform(get(motorcycleApiURL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        Motorcycle car = new Motorcycle(1L, new Brand(1L, null, "test"), "test", 1, Collections.emptyList(), "test");
        when(motorcycleService.create(anyString(), anyInt(), anyList(), anyString(), anyLong()))
                .thenReturn(mock(Motorcycle.class));
        mockMvc.perform(post(motorcycleApiURL)
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        Motorcycle car = new Motorcycle(1L, new Brand(1L, null, "test"), "test", 1, Collections.emptyList(), "test");
        when(motorcycleService.update(anyLong(), anyString(), anyInt(), anyLong()))
                .thenReturn(mock(Motorcycle.class));
        mockMvc.perform(put(motorcycleApiURL + "/1")
                .content(new ObjectMapper().writeValueAsString(car))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        when(motorcycleService.delete(anyLong())).thenReturn(1L);
        mockMvc.perform(delete(motorcycleApiURL + "/1"))
                .andExpect(status().isOk());
    }
}
