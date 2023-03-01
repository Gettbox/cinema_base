package com.kata.cinema.base.webapp.controllers.studio.production_studio_rest_controller;

import com.kata.cinema.base.webapp.CinemaBaseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
@SpringBootTest(classes = CinemaBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetByIdTest {

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private String createURLWithPort(String url) {
        return "http://localhost:" + port + url;
    }

    @Test
    @Sql(scripts = "dataset/init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "dataset/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getById() throws Exception {

        mockMvc.perform(get(createURLWithPort("/api/movies/100/studios")))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("100"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Аватар"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studioPerformance.id").value("100"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studioPerformance.name").value("PERFORM_NAME"));
    }
}