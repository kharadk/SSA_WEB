package com.ssa.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ssa.bo.UserResponse;
import com.ssa.props.AppProperties;
import com.ssa.service.UserService;

@WebMvcTest(value = SSAVerificationController.class)
public class SSAVerificationControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserService userService;
	@MockBean
	private AppProperties props;

	@Test
	public void validateUserTest_01() throws Exception {
		UserResponse response = new UserResponse();
		response.setSsnNo(12345l);
		response.setFirstName("alex");
		response.setLastName("max");
		response.setDob("10/12/1991");
		response.setGender("male");
		response.setStateName("California");

		when(userService.getUserDataBySSN(12345l)).thenReturn(response);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/verify/12345");

		MvcResult mvcResult = mvc.perform(builder).andReturn();

		MockHttpServletResponse mockResponse = mvcResult.getResponse();

		int mockStatus = mockResponse.getStatus();
		assertEquals(200, mockStatus);
	}

}
