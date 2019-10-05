package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FareInfoRepository;

@RestController
public class FareInfo 
{
	
	private String name;
	private String startingLocation; 	//start time
	private String endingLocation; 		//end time
	private String network ;   			//bus route
	private String paymentType ;
	private String fare; 				//auto generate number between 10-100
	private String token;
	private String date; 				//end time
	
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
	
	public FareInfo(String name, String startingLocation,String network, String paymentType)
	{
		this.name = name;
		this.startingLocation = startingLocation;
		this.endingLocation = getTime();
		this.network = network ;
		this.paymentType = paymentType ;
		this.fare = generateFare() ;
		this.token = generateToken() ;
		this.date = getTime();
	}
	
	public String generateToken() {
		//generate a random 6 digit number 
		double randomDouble = Math.random();
		randomDouble = randomDouble * 900000 + 100000;
		int randomInt = (int) randomDouble ;
		return Integer.toString(randomInt) ;
	}
	
	public String generateFare() {
		//generate a random number between 10-100
		double randomDouble = Math.random();
		randomDouble = randomDouble * 90 + 10;
		int randomInt = (int) randomDouble ;
		return Integer.toString(randomInt) ;
	}
	
	public String getTime() {
		Date crrDate = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = dateFormat.format(crrDate);
		return strDate;
	}
	
	@RequestMapping(value="/addNewJourney_FairInfo")
	public boolean addNewJourney_FairInfo(@RequestParam String name, @RequestParam String startingLocation, @RequestParam String network, @RequestParam String paymentType) {
		try {
			FareInfo fi = new FareInfo(name, startingLocation, network, paymentType);
			FIRepository.save(fi);
			System.out.println("=========================================================================");
			System.out.println("Adding new Journey...");
			System.out.println("User : " + fi.getName());
			System.out.println("Fare : " + fi.getFare());
			return true ;
		}catch (NullPointerException e){
			return false ;
		}
	}
	
	
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public FareInfoRepository getFIRepository() {
		return FIRepository;
	}

	public void setFIRepository(FareInfoRepository fIRepository) {
		FIRepository = fIRepository;
	}

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

	/**
	 * Returns the fare of non complete journey
	 * @param tokenID new id to check if usable.
	 * @return true if token can be used.
	 */
	@RequestMapping(value="/getFare")
	public String getFare(@RequestParam(value="username")String name) 
	{
		List<FareInfo> FIList = FIRepository.findAllByName(name);
		for(FareInfo fareInfo : FIList)
		{
			if(!fareInfo.token.equals("000000")) 
			{
				return fareInfo.fare;
			}
		}
		return "0";
	}


	public void setFare(String fare) {
		this.fare = fare;
	}
	
	public String getFare() {
		return fare;
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
