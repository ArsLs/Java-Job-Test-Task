package com.example.testovoezadanierestservicestringcounter.integration;

import com.example.testovoezadanierestservicestringcounter.controllers.MainController;
import com.example.testovoezadanierestservicestringcounter.services.MainService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.ResultActions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTests {
    private MainService mainService;
    private MockMvc mockMvc;

    @Autowired
    public IntegrationTests(MainService mainService) {
        this.mainService = mainService;
    }

    @BeforeAll
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MainController(mainService)).build();
    }

    @Test
    public void testResponseContentTypeAndStatus() throws Exception {
        this.mockMvc
                .perform(get("http://localhost:8080/?string=abcdefg"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testNoInputString() throws Exception {
        this.mockMvc
                .perform(get("http://localhost:8080/"))
                .andExpectAll(
                        status().isBadRequest());
    }
}
