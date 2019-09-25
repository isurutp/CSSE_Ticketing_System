package com.example.demo;

import com.example.demo.controller.LocalPassenger;

//Simple Factory Pattern
public class PassengerFactory 
{
	public static LocalPassenger makeLocalPassenger(String name, String NIC, /*String tokenID, float amount,*/ String address, String dob, String password)
	{
		return new LocalPassenger(name, NIC, /*String tokenID, amount,*/ address, dob, password);
	}

}
