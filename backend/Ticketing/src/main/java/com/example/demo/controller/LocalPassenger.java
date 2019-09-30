package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Passenger;
import com.example.demo.PassengerFactory;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.repository.FareInfoRepository;
import com.example.demo.repository.LocalPassengerRepository;

@RestController
public class LocalPassenger implements Passenger
{

	@Id
	private String name;
	private String email;
    private String NIC;
//    private String tokenId;
    private double amount;
    private String address;
    private int password;
    private String dob;    
    
    @Autowired
    private LocalPassengerRepository LPRepository;
    
    @Autowired
    private CreditCardRepository CCRepository;
    
    @Autowired
    private FareInfoRepository FIRepository;
    
    public LocalPassenger() {}
    
    public LocalPassenger(String name, String NIC, /*String tokenID,*/ double amount,String address, String dob, String password, String email)
    {
		this.name = name;
		this.NIC = NIC;
//		this.tokenId = tokenID;
		this.amount = amount;
		this.email = email;
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
     * 					details[5]	-> email
     */
    @Override
    @RequestMapping(value="/register")
    public boolean setPassengerData(@RequestParam(value="userDetails") String[] details) {
    	
    	LocalPassenger localPassenger = PassengerFactory.makeLocalPassenger(details[0], details[1], 0.0, details[2], details[3], details[4], details[5]);
        
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
    
    /**
     * Capturing data sent from TransferCredit.js when the TransferMoney function is called
     * @param details is an array of the transfer details.
     * 					details[0]	-> User name
     * 					details[1]	-> amount
     */
    @RequestMapping(value="/transferCredit")
    public boolean addCredit(@RequestParam(value="amountDetails") String[] details)
    {
    	LocalPassenger localPassenger = LPRepository.findByName(details[0]);
    	localPassenger.amount += Double.valueOf(details[1]);
		LPRepository.save(localPassenger);
    	
 		return true;
    	
    }
    
    
    /**
     * Reduce Fare charges from balance
     * @param details is an array of the transfer details.
     * 					details[0]	-> User name
     * 					details[1]	-> amount
     */
    @RequestMapping(value="/ReduceFare")
    public boolean ReduceFare(@RequestParam(value="fareDetails") String[] details)
    {
    	LocalPassenger localPassenger = LPRepository.findByName(details[0]);
    	localPassenger.amount -= Double.valueOf(details[1]);
		LPRepository.save(localPassenger);
    	
 		return true;
    	
    }
    
    
    /**
     * Capturing data sent from AddCard.js when the addCard function is called
     * @param details is an array of the Card's details.
     *					details[0]	-> User name
     * 					details[1]	-> Card number
     * 					details[2]	-> Expire month
     * 					details[3]	-> Expire Year
     * 					details[4]	-> CVV number
     */
    @RequestMapping(value="/addCreditCard")
    public boolean addCreditCard(@RequestParam(value="cardDetails") String[] details) {
    	
    	CreditCard creditCard;
    	if(CCRepository.findByName(details[0]) == null)
    	{
    		creditCard = new CreditCard(details[0], details[1], details[2], details[3], details[4]);
    	}
    	else
    	{
    		creditCard = CCRepository.findByName(details[0]);
    		creditCard.setCardNumber(details[1]);
    		creditCard.setExpiaryMonth(details[2]);
    		creditCard.setExpiaryYear(details[3]);
    		creditCard.setCvvNumber(details[4]);
    	}
    	
    	
    	CCRepository.save(creditCard);
    	
    	if(CCRepository.findByName(creditCard.getName()) == null)
    	{
    		return false;
    	}
    	
    	return true;
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
    /**
     * Capturing data sent Android app when journey is requested
     * @param details is an array of the journey details.
     *					details[0]	-> User name
     *					details[1]	-> Starting Location
     *					details[2]	-> Ending Location
     *					details[3]	-> Fare
     *					details[4]	-> tokenID
     */
    @RequestMapping(value="/setJourney")
	public boolean setJourney(@RequestParam(value="journeyDetails") String[] details) {
		
    	FareInfo fareInfo;
    	if(FIRepository.findByName(details[0]) == null)
    	{
    		fareInfo = new FareInfo(details[0], details[1], details[2], details[3], details[4]);
    	}
    	else
    	{
    		fareInfo = FIRepository.findByName(details[0]);
    		fareInfo.setStartingLocation(details[1]);
    		fareInfo.setEndingLocation(details[2]);
    		fareInfo.setFare(details[3]);
    		fareInfo.setTokenID(details[4]);
    	}
    	
    	
    	FIRepository.save(fareInfo);
    	
    	if(FIRepository.findByName(fareInfo.getName()) == null)
    	{
    		return false;
    	}
    	
    	return true;
		
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

    @RequestMapping(value="/getAmount")
    public double getAmount(@RequestParam(value="username")String name)
    {
    	return LPRepository.findByName(name).amount;
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

    @RequestMapping(value="/getAddress")
    public String getAddress(@RequestParam(value="username")String name)
    {
    	return LPRepository.findByName(name).address;
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
