package com.system.car.api.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.car.api.rest.dto.in.BrandIn;
import com.system.car.models.Brand;
import com.system.car.models.Car;
import com.system.car.services.abstr.BrandService;
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
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BrandControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    private final String brandApiURL = "/api/v1/brands";

    @Test
    void getByIdTest() throws Exception {
        when(brandService.getById(anyLong()))
                .thenReturn(mock(Brand.class));
        mockMvc.perform(get(brandApiURL + "/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        when(brandService.getAllPaged(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(mock(Brand.class), mock(Brand.class))));
        mockMvc.perform(get(brandApiURL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        BrandIn brand = new BrandIn("test");
        when(brandService.create(anyString()))
                .thenReturn(mock(Brand.class));
        mockMvc.perform(post(brandApiURL)
                .content(new ObjectMapper().writeValueAsString(brand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/hal+json"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}
