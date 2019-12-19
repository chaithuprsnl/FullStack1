package com.home.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,
webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerWebIntegrationTest {
	
	@Autowired
	private TestRestTemplate template;
	
	@LocalServerPort
	private int port;

	//@Sql({"/src/main/resources/schema.sql", "/src/main/resources/data.sql"})
	@Test
	public void testGet() throws JsonMappingException, JsonProcessingException {
		
		ResponseEntity<String> resp = this.template.getForEntity("http://localhost:"+port+"/addr/v1/list", String.class);
		assertThat(resp.getStatusCode(), is(HttpStatus.OK));
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonresp = mapper.readTree(resp.getBody());
		
		assertThat(jsonresp.asText(), is(""));
	}
}
