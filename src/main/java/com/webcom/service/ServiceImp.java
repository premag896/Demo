package com.webcom.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.webcom.entity.Transaction;

@Service
public class ServiceImp {
	
	private List<Transaction>transactions = List.of( new Transaction(1L,1L,LocalDate.of(2024,Month.JUNE, 10),120.0),
			
			 new Transaction(2L,1L,LocalDate.of(2024,Month.JULY, 5),75.0), 
			 new Transaction(3L,1L,LocalDate.of(2024,Month.AUGUST, 20),200.0));
	
	public int calculatePoints(Double amount)
	{
		int points = 0;
		if(amount > 100)
		{
			points +=(amount - 100)* 2;
			return points+=50;
		}
		if(amount > 50)
		{
			points +=(amount - 50)* 1;
			
		}
		return points;
	}
	
	public int calculateTotalPoints(Long customerId)
	{
		return transactions.stream().filter(t->t.getCustomerId().equals(customerId)).mapToInt(t->calculatePoints(t.getAmount())).sum();
	}
	public Map<String,Integer> calculateMonthlyPoints(Long customeId){
		Map<String, Integer> monthlyPoints = new HashMap<>();
		transactions.stream().filter(t->t.getCustomerId().equals(customeId)).forEach(t-> {String month =  t.getDate().getMonth().name();
		int points = calculatePoints(t.getAmount());
		if(monthlyPoints.containsKey(month))
		{
			monthlyPoints.put(month,monthlyPoints.get(month)+points);
		}
		else
		{
			monthlyPoints.put(month,points);
			
		}
		
		});
		return monthlyPoints;
	}
}

