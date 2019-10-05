package com.example.demo;

import com.example.demo.controller.LocalPassenger;
import com.example.demo.controller.ForeignPassenger;
import com.example.demo.model.Token;

//Simple Factory Pattern
public class PassengerFactory 
{
	public static LocalPassenger makeLocalPassenger(String name, String NIC, /*String tokenID,*/ double amount,String address, String dob, String password, String email)
	{
		return new LocalPassenger(name, NIC, /*String tokenID,*/ amount, address, dob, password, email);
	}
	
	public static ForeignPassenger makePassenger(Token temporaryTokenID ) {
		return new ForeignPassenger(temporaryTokenID);
	}
	
}
	
