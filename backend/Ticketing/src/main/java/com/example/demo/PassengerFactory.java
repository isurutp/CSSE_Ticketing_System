package com.example.demo;

import java.util.Date;

//Simple Factory Pattern
public class PassengerFactory 
{
	public static LocalPassenger makeLocalPassenger(String name, String NIC, /*String tokenID,*/ float amount, String address, Date dob)
	{
		return new LocalPassenger(name, NIC, /*String tokenID,*/ amount, address, dob);
	}

}
