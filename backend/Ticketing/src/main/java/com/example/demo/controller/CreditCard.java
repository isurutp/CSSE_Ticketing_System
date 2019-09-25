package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CreditCardRepository;

@RestController
public class CreditCard 
{
	

	@Id
	private String name;
	private String cardNumber;
	private String ExpiaryMonth;
	private String ExpiaryYear;
	private String cvvNumber;
	
	@Autowired
    private CreditCardRepository CCRepository;
	
	public CreditCard() {}
	
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
	
	@RequestMapping(value="/getCardNumber")
	public String getCardNumber(@RequestParam(value="username")String name) 
	{
		try {
			return CCRepository.findByName(name).cardNumber;
		}catch(NullPointerException ignored)
		{
			return null;
		}
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
