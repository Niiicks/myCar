package com.neuwirt.mycar.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroControllerTest {

	
	@Autowired
	public WebApplicationContext context;
		
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testaRequisicaoPlacaSucesso() throws Exception {
		String url = "/carros/abc-1515";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("modelo", equalTo("corsa")));
	}
	
	@Test
	public void testaRequisicaoPlacaFalha() throws Exception {
		String url = "/carros/abc-1454";
		this.mvc.perform(get(url))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void testaRequisicaoMarcaSucesso() throws Exception {
		String url = "/carros/marca/fiat";
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	//(`abc-1515`,`2011`,`preto`,`chevrolet`,`corsa`,`26000`);
	@Test
	public void testaRequisicaoMarcaFalha() throws Exception {
		String url = "/carros/marca/bmw";
		this.mvc.perform(get(url))
		.andExpect(status().isNotFound());
	}
	

	
}

