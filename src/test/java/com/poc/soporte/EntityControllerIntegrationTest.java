package com.poc.soporte;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.repository.EntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EntityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityRepository entityRepository;

    @Test
    void findAll_shouldReturnListOfEntities() throws Exception {
        entityRepository.deleteAll();
        entityRepository.save(new Entity("Test 1", "Desc 1", LocalDateTime.now()));
        entityRepository.save(new Entity("Test 2", "Desc 2", LocalDateTime.now()));

        mockMvc.perform(get("/api/entities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Test 1")))
                .andExpect(jsonPath("$[1].nombre", is("Test 2")));
    }
}
