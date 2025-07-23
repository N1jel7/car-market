package com.n1jel.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CarMarketApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/api/cars")).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
	}

}
