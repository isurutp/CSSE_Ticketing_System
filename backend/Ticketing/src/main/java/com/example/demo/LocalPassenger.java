package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LocalPassenger implements Passenger
{

	private String name;
    private String NIC;
//    private String tokenId;
    private float amount;
    private String address;
    private String dob;
    
    @Autowired
    private LocalPassengerRepository LPRepository;
    
    public LocalPassenger() {}
    
    public LocalPassenger(String name, String NIC, /*String tokenID,*/ float amount, String address, String dob)
    {
		this.name = name;
		this.NIC = NIC;
//		this.tokenId = tokenID;
		this.amount = amount;
		this.address = address;
		this.dob = dob;
	}

    
    /**
     * Capturing data sent from RegisterPage.js when the registerUser function is called
     * @param details is an array of the user's details.
     * 					details[0]	-> User name
     * 					details[1]	-> NIC
     * 					details[2]	-> Address
     * 					details[3]	-> date of Birth
     */
    @RequestMapping(value="/register")
    public boolean addUser(@RequestParam(value="userDetails") String[] details) {
    	this.name = details[0];
    	this.NIC = details[1];
    	this.address = details[2];
    	this.dob = details[3];
        
    	LPRepository.save(this);
    	
    	if(LPRepository.findByName(this.name) == null)
    	{
    		return false;
    	}
    	
    	System.out.println("FOUND");
    	return true;
        
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
	public void setPassengerData() {
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

    public float getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }

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

}
