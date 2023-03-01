package com.kata.cinema.base.webapp.controllers.admin.admin_production_studio_rest_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import com.kata.cinema.base.webapp.CinemaBaseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
@SpringBootTest(classes = CinemaBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private String createURL(String url) {
        return "http://localhost:" + port + url;
    }

    @Test
    @Sql(scripts = "dataset/update/init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "dataset/update/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void updateStudioTest() throws Exception {
        ProductionStudioRequestDto productionStudioRequestDto = new ProductionStudioRequestDto(
                "Амедиа", "DESCRIPTION UPDATE", "2002 г."
        );

        mockMvc.perform(put(createURL("/api/admin/studios/100"))
                        .content(objectMapper.writeValueAsString(productionStudioRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Амедиа"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("DESCRIPTION UPDATE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateFoundation").value("2002 г."));
    }
}