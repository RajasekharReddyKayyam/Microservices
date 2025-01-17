package com.example.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.controller.MessageController;
import com.example.service.MessageService;

@WebMvcTest(controllers=MessageController.class)
public class MessageRestControllerTest {
	@MockBean
	private MessageService msgservice;
	@Autowired
	//it is used to send request to our REST API
	private MockMvc mockmvc;
	@Test
	public void GreetTest() throws Exception {
		//define mock object behaviour 
		when(msgservice.getGreetMessage()).thenReturn("Dummy Text");
		//prepare request
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/greet");
		//send request
		MvcResult mvcResult=mockmvc.perform(requestBuilder).andReturn();
		//get response
		MockHttpServletResponse mvcresponse=mvcResult.getResponse();
		int actualstatuscode=mvcresponse.getStatus();
		int expectedstatuscode=200;
		assertEquals(expectedstatuscode,actualstatuscode);
	}
	@Test
	public void WelcomeTest() throws Exception {
		//define mock object behaviour 
		when(msgservice.getWElcomeMessage()).thenReturn("Dummy Text");
		//prepare request
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get("/welcome");
		//send request
		MvcResult mvcResult=mockmvc.perform(requestBuilder).andReturn();
		//get response
		MockHttpServletResponse mvcresponse=mvcResult.getResponse();
		int actualstatuscode=mvcresponse.getStatus();
		int expectedstatuscode=200;
		assertEquals(expectedstatuscode,actualstatuscode);
	}

}
