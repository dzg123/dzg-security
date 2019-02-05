package com.dzg.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
    public void whenUploadSuccess() {
        try {
            String file = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                    .file(new MockMultipartFile("file", "test.txt",
                            "multipart/form-data", "hello upload".getBytes("UTF-8"))))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            log.info("file:{}",file);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Test
    public void whenCreateSuccess() {
        try {
            Date date = new Date();
            String content = "{\"username\":\"dzg\",\"password\":\"123\",\"birthday\":" + date.getTime() + "}";
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                    .andReturn().getResponse().getContentAsString();
            log.info("date:{},\tresult:{}", date.getTime(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenUpdateSuccess() {
        try {
            Date date = new Date(LocalDateTime.now().atZone(ZoneId.systemDefault()).plusYears(1).toInstant().toEpochMilli());
            String content = "{\"id\":1,\"username\":\"dzg\",\"password\":\"123\",\"birthday\":" + date.getTime() + "}";
            String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                    .andReturn().getResponse().getContentAsString();
            log.info("date:{},\tresult:{}", date.getTime(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDeleteSuccess() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
