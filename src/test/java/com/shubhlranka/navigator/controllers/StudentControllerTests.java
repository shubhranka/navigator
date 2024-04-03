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
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddStudent() throws Exception {
        mockMvc.perform(post("/student")
                .contentType("application/json")
                .content("{\"name\": \"Shubham\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotAddStudent() throws Exception {
        mockMvc.perform(post("/student")
                .contentType("application/json")
                .content("{\"name\": \"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnAllStudents() throws Exception {
        mockMvc.perform(get("/students")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnStudentById() throws Exception {
        mockMvc.perform(get("/student/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
