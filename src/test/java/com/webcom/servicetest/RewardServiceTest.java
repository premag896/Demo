package com.webcom.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.webcom.service.RewardService;

public class RewardServiceTest {
	
	private final RewardService rewardService = new RewardService();
	
	@Test
	public void testCalculatePoints_under50()
	{
		//Case where amount is under $50
		double amount = 40.0;
		int points = rewardService.calculatePoints(amount);
		assertEquals(0, points,"Point should be 0 for amounts under $50");
	}
@Test
public void testCalculatePoints_between50And100()
{
	// Case where amount is between $50 and $100
	double amount = 75.0;
	int points = rewardService.calculatePoints(amount);
	assertEquals(25, points, "Points should be 20 for $75 purchase");
	
	
}
@Test 
public void testCalculatePoints_over100()
{
	//Case where amount is over $100
	double amount = 120.0;
	int points = rewardService.calculatePoints(amount);
	assertEquals(90,points, "Points should be 90 for $120 purchase");
	
}
}

