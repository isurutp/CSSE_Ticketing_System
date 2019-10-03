package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FareInfoRepository;

@RestController
public class FareInfo 
{
	
	private String name;
	private String startingLocation;
	private String endingLocation;
	private String fare;
	private String token;
	private String date;
	
	@Autowired
    private FareInfoRepository FIRepository;
	
	
	public FareInfo() {}
	
	public FareInfo(String name, String startingLocation, String endingLocation, String fare, String token, String date)
	{
		this.name = name;
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.fare = fare;
		this.token = token;
		this.setDate(date);
	}

	
	
	
	
	
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStartingLocation() {
		return startingLocation;
	}


	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}


	public String getEndingLocation() {
		return endingLocation;
	}


	public void setEndingLocation(String endingLocation) {
		this.endingLocation = endingLocation;
	}


	public String getFare() {
		return fare;
	}


	public void setFare(String fare) {
		this.fare = fare;
	}


	public String getToken() {
		return token;
	}
	
	/**
	 * Checks if token ID is usable
	 * @param tokenID new id to check if usable.
	 * @return true if token can be used.
	 */
	@RequestMapping(value="/checkToken")
	public boolean checkToken(@RequestParam(value="token")String token) {
		return FIRepository.findByToken(token) == null;
	}


	public void setToken(String token) {
		this.token = token;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	

}
