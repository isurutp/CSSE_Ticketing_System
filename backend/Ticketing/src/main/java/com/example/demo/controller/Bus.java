package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.BusRepository;

@RestController
public class Bus {
	@Id
	private String busId;
	private int noOfSeats;
	private String network;
	private int passengerCount;
	
	@Autowired
	private BusRepository bsRepo ;
	
	public Bus() {};
	
	public Bus(String busid, int seats, String route) {
		super();
		this.busId = busid;
		this.noOfSeats = seats;
		this.network = route;
		this.passengerCount = 0 ;
	}
	
	@RequestMapping(value="/getBusDetails")
    public String[][] getBusDetails(@RequestParam String busId)
    {
    	List<Bus> bs = bsRepo.findAllBybusId(busId);
    	int i=0;
    	String[][] busDet = new String[1][4];
    	for (String[] row : busDet) {
    	    Arrays.fill(row, "");
    	}
    		
    	for(Bus busInfo: bs)
    	{
    		busDet[i][0] = busInfo.getBusId();
    		busDet[i][1] = Integer.toString(busInfo.getNoOfSeats());
    		busDet[i][2] = Integer.toString(busInfo.getPassengerCount()) ;
    		busDet[i][3] = busInfo.getNetwork();
			
			i++;
    	}
		return busDet;
	}
	
	@RequestMapping(value="/getBusIsOverCrowded")
	public boolean identifyOvercrowd(@RequestParam String busId) {
		try{
			int seats = bsRepo.findBybusId(busId).getNoOfSeats();
			int passengers = bsRepo.findBybusId(busId).getPassengerCount() ;
			if (seats < passengers) {
				return true ;
			}else {
				return false ;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false ;
		}
	}
	
	@RequestMapping(value="/addNewBus")
	public boolean create(@RequestParam String busId, @RequestParam int noOfSeats, @RequestParam String route) {
		try {
			if(bsRepo.findBybusId(busId)==null) {
				Bus b = new Bus(busId, noOfSeats, route);
				bsRepo.save(b);
				return true ;
			}
			return false;
		}catch (NullPointerException e){
			return false ;
		}
	}
	
	@RequestMapping(value="/getBusId")
	public Boolean getBusId(@RequestParam String busId) {
		try{
			if (bsRepo.findBybusId(busId).getBusId()!=null) {
				return true ;
			}
			return false ;
		}catch (Exception e) {
			return false ;
		}
	}
	
	@RequestMapping(value="/getBusSeats")
	public int getBusSeats(@RequestParam String busId) {
		try{
			return bsRepo.findBybusId(busId).getNoOfSeats() ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return -1 ;
		}
	}
	
	@RequestMapping(value="/getBusPassengerCount")
	public int getBusPassengerCount(@RequestParam String busId) {
		try{
			return bsRepo.findBybusId(busId).getPassengerCount() ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return -1 ;
		}
	}
	
	@RequestMapping(value="/addBusPassengerCount")
	public int addBusPassengerCount(@RequestParam String busId) {
		try{
			Bus b = bsRepo.findBybusId(busId);
			b.setPassengerCount((b.getPassengerCount()+1));
			bsRepo.save(b);
			return b.getPassengerCount() ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return -1 ;
		}
	}
	
	@RequestMapping(value="/getBusRoute")
	public String getBusRoute(@RequestParam String busId) {
		try{
			return bsRepo.findBybusId(busId).getNetwork() ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null ;
		}
	}
	
	@RequestMapping(value="/deleteAllBusses")
	public String deleteAll() {
		try{
			bsRepo.deleteAll();
			return "Deleted all" ;
		}catch(Exception e){
			return e.getMessage() ;
		}
	}
	
	@RequestMapping(value="/deleteOneBus")
	public String deleteOneBus(@RequestParam String busId) {
		Bus b = bsRepo.findBybusId(busId);
		bsRepo.delete(b);
		return "Deleted " + busId;
	}
	
	//==========================================Getters and Setters============================================
	public String getBusId() {
		return this.busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	public String toString() {
		return "Bus ID " + this.busId + " Route " + this.network ;
	}

}
