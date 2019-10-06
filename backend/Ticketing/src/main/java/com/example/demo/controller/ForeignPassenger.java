package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Token;
import com.example.demo.repository.ForeignPassengerRepository;
import com.example.demo.Passenger;
import com.example.demo.PassengerFactory;



@RestController
public class ForeignPassenger implements Passenger {
	
	private Token temporaryToken;
	
	@Autowired
    private ForeignPassengerRepository repository;
	
	 public ForeignPassenger() {}
	    
	 public ForeignPassenger(Token temp) {
		this.temporaryToken = temp;
	 }

	
    
	
	@RequestMapping(value="/checkTemp")
	@Override
	public boolean verifyPassenger(@RequestParam(value="token") String[] details) {
		List<ForeignPassenger> passengers = repository.findAll();
 
		for( ForeignPassenger passenger : passengers) {
			if(passenger.getTemporaryToken().getTokenId().equals(details[0])) {
				return true; 
			}
		}
    	
		return false;
	}
	
	
	

	@RequestMapping(value="/setTemp")
	@Override
	public boolean setPassengerData(@RequestParam(value="token") String[] details) {
		ForeignPassenger passenger = PassengerFactory.makePassenger(new Token(generateBarcode(),details[0]));
    	if(repository.findByTemporaryToken(passenger.temporaryToken) != null) {
    		return false;
    	}
        
    	repository.save(passenger);    	
    	return true;
	}

	@Override
	public boolean setJourney(String[] details) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateTicketPrice(String[] details) {
		// TODO Auto-generated method stub
	}
	
	
	public int generateBarcode() {
		List<ForeignPassenger> passengers = repository.findAll();
		
		int barCode = 0; 
		
		for( ForeignPassenger passenger : passengers) {
			barCode = passenger.getTemporaryToken().getBarCode() >= barCode?
					passenger.getTemporaryToken().getBarCode()+1:barCode;
		}
		
		return barCode;
	}

	public Token getTemporaryToken() {
		return temporaryToken;
	}

	public void setTemporaryToken(Token temporaryToken) {
		this.temporaryToken = temporaryToken;
	}

}

