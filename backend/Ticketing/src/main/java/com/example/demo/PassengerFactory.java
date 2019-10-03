package com.example.demo;

import com.example.demo.controller.LocalPassenger;

//Simple Factory Pattern
public class PassengerFactory 
{
	public static LocalPassenger makeLocalPassenger(String name, String NIC, double amount,String address, String dob, String password, String email)
	{
		return new LocalPassenger(name, NIC, amount, address, dob, password, email);
	}

}
