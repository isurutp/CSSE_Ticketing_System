package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.BusRepository;
import com.example.demo.repository.CurrentJourneyRepository;

@RestController
public class CurrentJourney {
	@Id
	private String id;
	private String busId;
	private String username;
	private String paymentType;
	private Date startTime ;
	
	@Autowired
	private BusRepository bsRepo ;
	
	@Autowired
	private CurrentJourneyRepository cjRepo ;
	
	public CurrentJourney() {} ;
	
	public CurrentJourney(String busId, String username, String paymentType) {
		this.busId = busId ;
		this.username = username;
		this.paymentType = paymentType;
		this.startTime = Calendar.getInstance().getTime();
	}
	
	//method to start a journey for a particular passenger
	@RequestMapping(value="/addNewUserToJourney")
	public boolean addNewUserToJourney(@RequestParam String busId, @RequestParam String username, @RequestParam String payment) {
		try {
			CurrentJourney oj = cjRepo.findByusername(username);
			if (oj == null) {
				CurrentJourney j = new CurrentJourney(busId, username, payment);
				cjRepo.save(j);
				return true ;
			}
			return false ;
		}catch (NullPointerException e){
			return false ;
		}
	}
	
	//method will return the journey details of a particular bus
	@RequestMapping(value="/getCurrentJourneyDetails")
    public String[][] getCurrentJourneyDetails(@RequestParam String busId)
    {
    	List<CurrentJourney> bs = cjRepo.findAllBybusId(busId);
    	int size = bs.size();
    	
    	Bus currentBus = bsRepo.findBybusId(busId) ;
    	currentBus.setPassengerCount(size);
    	bsRepo.save(currentBus);
    	System.out.println("=========================================================================");
    	System.out.println("Number of passengers on " + busId + " : "+ currentBus.getPassengerCount());
    	System.out.println("Number of seats on "+ busId + " : " + currentBus.getNoOfSeats());
    	
    	int i=0;
    	String[][] cjDet = new String[size][4];
    	for (String[] row : cjDet) {
    	    Arrays.fill(row, "");
    	}
    		
    	for(CurrentJourney cjInfo: bs)
    	{
    		cjDet[i][0] = cjInfo.getBusId();
    		cjDet[i][1] = cjInfo.getUsername();
    		cjDet[i][2] = cjInfo.getPaymentType();
    		cjDet[i][3] = cjInfo.getStartTimeToString();
			
			i++;
    	}
		return cjDet;
	}
	
	//remove an user from the journey
	@RequestMapping(value="/deleteOneCurrentJourney")
	public boolean deleteOneJourney(@RequestParam String username) {
		try {
			CurrentJourney j = cjRepo.findByusername(username);
			if (j != null) {
				cjRepo.delete(j);
				return true ;
			}
			return false ;
		}catch (Exception e) {
			return false ;
		}
	}
	
	//delete all from the current journey repository
	@RequestMapping(value="/deleteAllCurrentJourney")
	public String deleteAll() {
		try{
			cjRepo.deleteAll();
			return "Deleted all" ;
		}catch(Exception e){
			return e.getMessage() ;
		}
	}
	
	//check if a particular user is already in a bus
	@RequestMapping(value="/checkUserInBus")
	public String checkUserInBus(@RequestParam(value="username") String username) 
	{
		CurrentJourney currentJourney = cjRepo.findByusername(username);
		if(currentJourney != null)
		{
			return currentJourney.busId;
		}
		return "none";
	}
	
	@RequestMapping(value="/checkTime")
	public String checkTime(@RequestParam(value="username") String username) 
	{
		CurrentJourney currentJourney = cjRepo.findByusername(username);
		if(currentJourney != null)
		{
			return currentJourney.startTime.toString();
		}
		return "none";
	}
	
	
	
	//=========================================Getters and Setters=========================================================
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getStartTime() {
		return startTime;
	}
	
	public String getStartTimeToString() {
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = dateFormat.format(this.startTime);
		return strDate;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	} ;
}
