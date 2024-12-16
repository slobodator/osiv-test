package com.slobodator.osivtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.slobodator.osivtest.OsivTestApplicationTests;
import com.slobodator.osivtest.dto.ParentDto;
import com.slobodator.osivtest.entity.Parent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ParentControllerTest extends OsivTestApplicationTests {
  private final CountDownLatch startGate = new CountDownLatch(1);

  @BeforeEach
  void init() {
    parentRepository.save(
        new Parent("parent")
            .addChild("child1")
            .addChild("child2")
    );
  }

  @Test
  void getParents() throws Exception {
    var getParentsThread = new Thread(
        () -> {
          try {
            startGate.await();
            List<ParentDto> response = objectMapper.readValue(
                mockMvc.perform(
                        get("/parents"))
                    .andExpect(status().isOk())
                    .andReturn().getResponse()
                    .getContentAsString(),
                new TypeReference<>() {
                }
            );
            System.out.println("SLOW thread " + response.getFirst().getChildren());
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
    );

    var getParentThread = new Thread(
        () -> {
          try {
            startGate.await();
            ParentDto parent = objectMapper.readValue(
                mockMvc.perform(
                        get("/parents/1"))
                    .andExpect(status().isOk())
                    .andReturn().getResponse()
                    .getContentAsString(),
                new TypeReference<>() {
                }
            );
            System.out.println("QUICK thread = " + parent.getChildren());
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
    );

    getParentsThread.start();
    getParentThread.start();
    startGate.countDown();
    getParentsThread.join();
    getParentThread.join();
  }
}