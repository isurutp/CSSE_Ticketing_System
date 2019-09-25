package com.example.demo;

import org.springframework.data.annotation.Id;

public class CreditCard 
{
	

	@Id
	private String name;
	private String cardNumber;
	private String ExpiaryMonth;
	private String ExpiaryYear;
	private String cvvNumber;
	
	
	
	public CreditCard(String name, String cardNumber, String expiaryMonth, String expiaryYear, String cvvNumber) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		ExpiaryMonth = expiaryMonth;
		ExpiaryYear = expiaryYear;
		this.cvvNumber = cvvNumber;
	}
	
	
	
	
	
	
	
	
	
	
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiaryMonth() {
		return ExpiaryMonth;
	}
	public void setExpiaryMonth(String expiaryMonth) {
		ExpiaryMonth = expiaryMonth;
	}
	public String getExpiaryYear() {
		return ExpiaryYear;
	}
	public void setExpiaryYear(String expiaryYear) {
		ExpiaryYear = expiaryYear;
	}
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}










	public String getName() {
		return name;
	}










	public void setName(String name) {
		this.name = name;
	}


}
