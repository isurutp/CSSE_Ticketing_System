package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UnauthorizedTravelsRepository;

@RestController
public class UnauthorizedTravels {
	@Id
	private String id ;
	private String name ;
	private Date date ;
	private String route ;
	private double fare ;
	
	@Autowired
	private UnauthorizedTravelsRepository unTravels ;
	
	public UnauthorizedTravels() {} ;
	
	public UnauthorizedTravels(String name,String route, double fare) {
		this.name = name ;
		this.date = Calendar.getInstance().getTime();
		this.route = route ;
		this.fare = fare ;
	}

	@RequestMapping(value="/addNewUnauthorizedTravels")
	public boolean addNewUnauthorizedTravels(@RequestParam String name, @RequestParam String route, @RequestParam double fare) {
		try {
			UnauthorizedTravels nut = new UnauthorizedTravels(name, route, fare);
			unTravels.save(nut);
			return true ;
		}catch (NullPointerException e){
			return false ;
		}
	}
	
	@RequestMapping(value="/getAllUnauthorizedTravels")
    public String[][] getAllUnauthorizedTravels() {
    	List<UnauthorizedTravels> ut = unTravels.findAll();
    	int i=0;
    	int size = ut.size() ;
    	String[][] travDet = new String[size][4];
    	for (String[] row : travDet) {
    	    Arrays.fill(row, "");
    	}
    		
    	for(UnauthorizedTravels travInfo: ut) {
    		travDet[i][0] = travInfo.getName();
    		travDet[i][1] = travInfo.getDateToString();
    		travDet[i][2] = travInfo.getRoute();
    		travDet[i][3] = Double.toString(travInfo.getFare());
			
			i++;
    	}
		return travDet;
	}
	
	@RequestMapping(value="/deleteAllUnauthorizedTravels")
	public String deleteAll() {
		try{
			unTravels.deleteAll();
			return "Deleted all" ;
		}catch(Exception e){
			return e.getMessage() ;
		}
	}
	
	//========================================Getters and Setters=========================================
	
	public String getDateToString() {
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String strDate = dateFormat.format(this.date);
		return strDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	};
	
}
