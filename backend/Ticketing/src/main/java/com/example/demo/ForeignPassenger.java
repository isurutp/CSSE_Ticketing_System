package com.example.demo;

public class ForeignPassenger implements Passenger
{
    private String temporaryTokenID;

    
    
    
	@Override
	public void verifyPassenger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setPassengerData(String[] details) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJourney(String[] details) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateTicketPrice() {
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
