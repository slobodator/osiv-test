package com.slobodator.osivtest.controller;

import com.slobodator.osivtest.OsivTestApplicationTests;
import com.slobodator.osivtest.entity.Parent;
import com.slobodator.osivtest.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ParentControllerTest extends OsivTestApplicationTests {
    @Autowired
    private ParentRepository parentRepository;

    @BeforeEach
    void init() {
        parentRepository.save(
                new Parent("parent")
                        .addChild("child1")
                        .addChild("child2")
                        .addChild("child3")
                        .addChild("child4")
        );
    }

    @Test
    void getParents() throws Exception {
        var response = mockMvc.perform(
                        get("/parents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse();

        System.out.println(response.getContentAsString());
    }
}