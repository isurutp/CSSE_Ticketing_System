package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Passenger;
import com.example.demo.PassengerFactory;
import com.example.demo.repository.LocalPassengerRepository;

@RestController
public class LocalPassenger implements Passenger
{

	private String name;
    private String NIC;
//    private String tokenId;
//    private float amount;
    private String address;
    private int password;
    private String dob;    
    
    @Autowired
    private LocalPassengerRepository LPRepository;
    
    public LocalPassenger() {}
    
    public LocalPassenger(String name, String NIC, /*String tokenID, float amount, */String address, String dob, String password)
    {
		this.name = name;
		this.NIC = NIC;
//		this.tokenId = tokenID;
//		this.amount = amount;
		this.address = address;
		this.dob = dob;
		this.setPassword(password.hashCode());	//Avoid storing plain text password
	}

    
    /**
     * Capturing data sent from RegisterPage.js when the registerUser function is called
     * @param details is an array of the user's details.
     * 					details[0]	-> User name
     * 					details[1]	-> NIC
     * 					details[2]	-> Address
     * 					details[3]	-> date of Birth
     * 					details[4]	-> password
     */
    @Override
    @RequestMapping(value="/register")
    public boolean setPassengerData(@RequestParam(value="userDetails") String[] details) {
    	
    	LocalPassenger localPassenger = PassengerFactory.makeLocalPassenger(details[0], details[1], details[2], details[3], details[4]);
        
    	LPRepository.save(localPassenger);
    	
    	if(LPRepository.findByName(localPassenger.name) == null)
    	{
    		return false;
    	}
    	
    	return true;
        
    }
    
    
    /**
     * Capturing data sent from LoginPage.js when the login function is called
     * @param details is an array of the user's details.
     * 					details[0]	-> User name
     * 					details[1]	-> Password
     */
    @RequestMapping(value="/login")
    public boolean loginUser(@RequestParam(value="userDetails") String[] details) {
    	
    	if(LPRepository.findByName(details[0]) != null && 
    			LPRepository.findByPassword(details[1].hashCode()) != null)
    	{
    		return true;
    	}
    	
		return false;
        
    }
    
    
    
    public void showDetails()
    {
       
    }
    
    public void addCredit()
    {}
    
    
    /**
     * Capturing data sent from AddCard.js when the addCard function is called
     * @param details is an array of the Card's details.
     * 					details[0]	-> Card number
     * 					details[1]	-> Expire month
     * 					details[2]	-> Expire Year
     * 					details[3]	-> CVV number
     */
    @RequestMapping(value="/addCreditCard")
    public void addCreditCard(@RequestParam(value="cardDetails") String[] details) {
        System.out.println(details[0]);
        System.out.println(details[1]);
        System.out.println(details[2]);
        System.out.println(details[3]);
    }
    
    
    public void searchJourneysTaken()
    {}
    
    public void searchFaresPaid()
    {}
    
    
	@Override
	public void verifyPassenger() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setJourney() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void calculateTicketPrice() {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
    
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************
    
    public String getNIC()
    {
        return NIC;
    }

    public void setNIC(String NIC)
    {
        this.NIC = NIC;
    }

//    public String getTokenId()
//    {
//        return tokenId;
//    }
//
//    public void setTokenId(String tokenId)
//    {
//        this.tokenId = tokenId;
//    }

//    public float getAmount()
//    {
//        return amount;
//    }
//
//    public void setAmount(float amount)
//    {
//        this.amount = amount;
//    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

}
