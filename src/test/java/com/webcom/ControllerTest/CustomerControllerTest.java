package com.webcom.ControllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.webcom.controller.CustomerController;
import com.webcom.service.RewardService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = CustomerController.class) 
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	
	private CustomerController customerController;

	@Mock
	private RewardService rewardService;

	@Test
	public void testGetTotalPoints() throws Exception {
		Long customerId = 1L;
		
		Mockito.when(rewardService.calculateTotalPoints(customerId)).thenReturn(150);
		mockMvc.perform(get("/api/rewards/customer/{customerId}/total", customerId)).
				andExpect(status().isOk()).andExpect(content().string(is("150")));

	}
}
