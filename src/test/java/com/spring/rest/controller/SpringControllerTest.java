package com.spring.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.oosic.webservice.controller.HomeController;

public class SpringControllerTest {

    @Test
    public void json() throws Exception {

        MockMvc mockMvc = standaloneSetup(new HomeController()).build();
        mockMvc.perform(get("/person/Lee").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Lee")).andExpect(jsonPath("$.title").value("你好"));
        mockMvc.perform(post("/p2/haha").param("title", "你好吧")).andExpect(status().is(302))
                .andExpect(view().name("redirect:/hello")).andExpect(model().attribute("title", "你好吧"));
        mockMvc.perform(get("/p2/haha2").param("title", "你好吧").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].fullName").value("宝马-进口-x6"));
    }


}