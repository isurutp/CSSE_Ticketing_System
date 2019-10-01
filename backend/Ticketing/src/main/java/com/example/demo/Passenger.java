package com.example.demo;

public interface Passenger
{
    public boolean verifyPassenger(String[] details);
    
    public boolean setPassengerData(String[] details);
    
    public boolean setJourney(String[] details);
    
    public void calculateTicketPrice(String[] details);
	
   
    
}
