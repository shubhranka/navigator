package com.shubhlranka.navigator.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SubjectControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldAddSubject() throws Exception {
        mockMvc.perform(post("/subject")
                .contentType("application/json")
                .content("{\"name\": \"Maths\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotAddSubject() throws Exception {
        mockMvc.perform(post("/subject")
                .contentType("application/json")
                .content("{\"name\": \"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnAllSubjects() throws Exception {
        mockMvc.perform(get("/subjects")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnSubjectById() throws Exception {
        mockMvc.perform(get("/subject/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
