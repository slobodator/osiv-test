package com.slobodator.osivtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slobodator.osivtest.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class OsivTestApplicationTests {
    @SuppressWarnings("unused")
    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected ParentRepository parentRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    @BeforeEach
    void setupTests() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .build();
    }
}
