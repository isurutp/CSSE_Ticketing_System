package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Token;
import com.example.demo.repository.ForeignPassengerRepository;
import com.example.demo.PassengerFactory;



@RestController
public class ForeignPassenger {
	
	private Token temporaryToken;
	
	@Autowired
    private ForeignPassengerRepository repository;
	
	 public ForeignPassenger() {}
	    
	 public ForeignPassenger(Token temp) {
		this.temporaryToken = temp;
	 }

	
    
	
	@RequestMapping(value="/checkTemp")
	public boolean verifyPassenger(@RequestParam(value="userDetails") String[] details) {
		if(repository.findByTemporaryToken(new Token(Integer.parseInt(details[0]),details[1])) != null) {
    		return true;
    	}
    	
		return false;
	}
	

	@RequestMapping(value="/setTemp")
	public boolean setPassengerData(@RequestParam(value="userDetails") String[] details) {
		ForeignPassenger passenger = PassengerFactory.makePassenger(new Token(Integer.parseInt(details[0]),details[1]));
    	if(repository.findByTemporaryToken(passenger.temporaryToken) != null) {
    		return false;
    	}
        
    	repository.save(passenger);    	
    	return true;
	}


	public boolean setJourney(String[] details) {
		return false;
		// TODO Auto-generated method stub
		
	}


	public void calculateTicketPrice(String[] details) {
		// TODO Auto-generated method stub
		
	}
    
    

}

