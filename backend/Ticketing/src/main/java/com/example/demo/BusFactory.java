package com.example.demo;

import com.example.demo.controller.Bus;

//Simple Factory Pattern
public class BusFactory
{
	public static Bus makeBus(String busId, int noOfSeats, String network)
	{
		return new Bus(busId, noOfSeats, network);
	}

}
