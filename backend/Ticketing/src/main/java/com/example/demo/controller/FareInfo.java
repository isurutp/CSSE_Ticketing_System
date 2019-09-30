package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FareInfoRepository;

@RestController
public class FareInfo 
{
	
	@Id
	private String name;
	private String startingLocation;
	private String endingLocation;
	private String fare;
	private String token;
	
	@Autowired
    private FareInfoRepository FIRepository;
	
	
	public FareInfo() {}
	
	public FareInfo(String name, String startingLocation, String endingLocation, String fare, String token)
	{
		this.name = name;
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.fare = fare;
		this.token = token;
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


	@RequestMapping(value="/getTokenID")
	public String getTokenID(@RequestParam(value="username")String name) {
		try {
			return FIRepository.findByName(name).token;
		}catch(NullPointerException ignored)
		{
			return null;
		}
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


	public void setTokenID(String token) {
		this.token = token;
	}
	
	
	
	
	

}
