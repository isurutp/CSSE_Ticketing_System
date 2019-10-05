package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.bson.types.ObjectId;
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
	ObjectId _id;
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
        String token = null;
        while(token == null || checkToken(token) || token.equals("000000"))
        {
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            token = String.format("%06d", number);
        }
		return token ;
	}
	
	public String generateFare() {
		//generate a random number between 10-100
		return " " ;
	}
	
	public String getTime() {
		Date crrDate = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = dateFormat.format(crrDate);
		return strDate;
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
	
	/**
	 * Returns the fare of non complete journey
	 * @param tokenID new id to check if usable.
	 * @return true if token can be used.
	 */
	@RequestMapping(value="/resetTokens")
	public void resetTokens(@RequestParam(value="username")String name) 
	{
		List<FareInfo> FIList = FIRepository.findAllByName(name);
		for(FareInfo fareInfo : FIList)
		{
			if(!fareInfo.token.equals("000000")) 
			{
				FareInfo FIUpdate = FIRepository.findBy_id(fareInfo._id);
				FIUpdate.token = "000000";
				FIRepository.save(FIUpdate);
			}
		}
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
