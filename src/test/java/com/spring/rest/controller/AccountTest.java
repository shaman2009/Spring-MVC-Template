package com.spring.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.oosic.webservice.controller.HomeController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:servlet-context.xml" })
public class AccountTest {

    private MockMvc mockMvc;
    @Autowired WebApplicationContext wac; 
    @Before
    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();

    }

	@Test
	public void thatCreateOrderUsesHttpCreated() throws Exception {
		System.out.println(123);
//
//		this.mockMvc
//				.perform(
//						post("/Account/Test").contentType(
//								MediaType.APPLICATION_JSON).accept(
//								MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(status().isCreated());
	}
}
