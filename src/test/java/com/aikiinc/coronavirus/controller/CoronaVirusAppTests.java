package com.aikiinc.coronavirus.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;

@SpringBootTest
@AutoConfigureMockMvc
class CoronaVirusAppTests {
	private static Logger LOG = LoggerFactory.getLogger(CoronaVirusAppTests.class);

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andReturn();

		// LOG.info("result: " + result.getResponse().getContentAsString());

		Assert.assertEquals("Corona Virus and Spring Boot!", result.getResponse().getContentAsString());
	}
}
