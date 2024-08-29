package com.webcom.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webcom.service.ServiceImp;

@Component
@RestController
@RequestMapping("/api/rewards")
class Customer {
	
	@Autowired
	private ServiceImp serviceImp;
	
	
	@GetMapping("/customer/{customerId}")
	
	public ResponseEntity<Integer>getTotalPoints(@PathVariable Long customerId)
	{
		int totalPoints = serviceImp.calculateTotalPoints(customerId);
		return ResponseEntity.ok(totalPoints);
		
	}
	
@GetMapping("/customer/{customerId}/monthly")
	
	public ResponseEntity<Map>getMonthlyPoints(@PathVariable Long customerId)
	{
		Map<String, Integer> monthlyPoints = serviceImp.calculateMonthlyPoints(customerId);
		return ResponseEntity.ok(monthlyPoints);
		
	}
	
}
