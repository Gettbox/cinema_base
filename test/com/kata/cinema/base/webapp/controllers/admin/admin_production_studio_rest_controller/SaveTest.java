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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
@SpringBootTest(classes = CinemaBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaveTest {

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
    @Sql(scripts = "dataset/save/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void save() throws Exception {
        ProductionStudioRequestDto productionStudioRequestDto = new ProductionStudioRequestDto(
                "Ленфильм#TEST_NAME", "Описание Ленфильма", "1914 г."
        );

        mockMvc.perform(post(createURL("/api/admin/studios"))
                        .content(objectMapper.writeValueAsString(productionStudioRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ленфильм#TEST_NAME"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Описание Ленфильма"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateFoundation").value("1914 г."));
    }
}