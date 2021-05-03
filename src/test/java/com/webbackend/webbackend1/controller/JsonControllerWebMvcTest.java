package com.webbackend.webbackend1.controller;

import com.webbackend.webbackend1.Service.CustomerService;
import com.webbackend.webbackend1.entity.Customer;
import com.webbackend.webbackend1.entity.SecondCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JsonController.class)
class JsonControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach......");
        given(this.customerService.getCustomerById(1))
                .willReturn(new SecondCustomer("111@126.com", "123123", 66));
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach......");
    }

    @Test
    void publicView() throws Exception {
        this.mockMvc.perform(get("/public").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.follower").value(66))
                .andExpect(jsonPath("$.email").doesNotExist())
                .andExpect(jsonPath("$.password").doesNotExist());
    }

    @Test
    void internalView() throws Exception {
        this.mockMvc.perform(get("/internal").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.follower").value(66))
                .andExpect(jsonPath("$.email").value("111@126.com"))
                .andExpect(jsonPath("$.password").value("123123"));
    }

}
