package com.webcom.entity;

import java.time.LocalDate;

public class Transaction {
	private Long id;
	private String name;
	private Long customerId;
	private LocalDate date;
	private Double amount;
	public Transaction(Long id, Long customerId, LocalDate date, Double amount) {
		this.id =id;
		this.customerId = customerId;
		this.date = date;
		this.amount = amount;
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCustomerId() {
		// TODO Auto-generated method stub
		return customerId;
	}
	public Double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	public LocalDate getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
	


}
