package com.webbackend.webbackend1.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JsonControllerSpringbootTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach......");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach......");
    }

    @Test
    void publicView() throws Exception {
        //使用mockMvc发起请求
        this.mockMvc
                .perform(get("/public")
                        .accept(MediaType.APPLICATION_JSON))
                //断言，通过的条件1:状态码为200
                .andExpect(status().isOk())
                //断言，通过的条件2:返回的JSON中的follower值为"66"
                .andExpect(jsonPath("$.follower")
                        .value(66))
                //断言，通过的条件3:返回的JSON中没有email password
                .andExpect(jsonPath("$.email")
                        .doesNotExist())
                .andExpect(jsonPath("$.password")
                        .doesNotExist());
    }

    @Test
    void internalView() throws Exception {
        //使用mockMvc发起请求
        this.mockMvc
                .perform(get("/internal")
                        .accept(MediaType.APPLICATION_JSON))
                //断言，通过的条件1:状态码为200
                .andExpect(status().isOk())
                //断言，通过的条件2:返回的JSON中的follower值为"66"
                .andExpect(jsonPath("$.follower")
                        .value(66))
                //断言，通过的条件2:返回的JSON中的email值为"111@126.com"
                .andExpect(jsonPath("$.email")
                        .value("111@126.com"))
                //断言，通过的条件2:返回的JSON中的password值为"123123"
                .andExpect(jsonPath("$.password")
                        .value("123123"));
        //断言，通过的条件3:返回的JSON中没有email password
    }

}
