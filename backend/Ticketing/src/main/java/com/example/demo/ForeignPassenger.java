package com.example.demo;

public class ForeignPassenger implements Passenger
{
    private String temporaryTokenID;

    
    
    
	@Override
	public boolean verifyPassenger(String[] details) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setPassengerData(String[] details) {
		return false;
		// TODO Auto-generated method stub
		
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
    
    
    
    
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************
    public String getTemporaryTokenID()
    {
        return temporaryTokenID;
    }

    public void setTemporaryTokenID(String temporaryTokenID)
    {
        this.temporaryTokenID = temporaryTokenID;
    }
    
}
