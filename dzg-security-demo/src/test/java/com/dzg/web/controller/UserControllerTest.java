package com.dzg.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: dzg-security
 * @description: User测试类
 * @author: dzg
 * @create: 2019-01-29 15:50
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() {
        try {
            String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                    .param("username", "dzg")
//                    .param("page","2")
//                    .param("size","10")
//                    .param("sort","age,DESC")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                    .andReturn().getResponse().getContentAsString();
            log.info("result:{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGetInfoSuccess() {
        try {
            String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("dzg"))
                    .andReturn().getResponse().getContentAsString();
            log.info("result:{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGetInfoFail() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
