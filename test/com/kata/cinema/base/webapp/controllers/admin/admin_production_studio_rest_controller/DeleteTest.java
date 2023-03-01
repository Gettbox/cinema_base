package com.kata.cinema.base.webapp.controllers.admin.admin_production_studio_rest_controller;

import com.kata.cinema.base.webapp.CinemaBaseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
@SpringBootTest(classes = CinemaBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private String createURL(String url) {
        return "http://localhost:" + port + url;
    }

    @Test
    @Sql(scripts = "dataset/delete/init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "dataset/delete/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void delete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(createURL("/api/admin/studios/100"))).andExpect(status().isNoContent());
    }
}