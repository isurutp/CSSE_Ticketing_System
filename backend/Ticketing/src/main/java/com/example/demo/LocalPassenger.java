package com.example.demo;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.beans.factory.annotation.Autowired;


@Document
public class LocalPassenger extends Passenger
{
	@Id
	private ObjectId id;
	private String name;
    private String NIC;
    private String tokenId;
    private float amount;
    private String address;
    private Date dob;

    private LocalPassengerRepository localPassengerRepository;
    
    public LocalPassenger(String name, String NIC, String tokenId, float amount, String address, Date dob)
    {
    	this.name = name;
        this.NIC = NIC;
        this.tokenId = tokenId;
        this.amount = amount;
        this.address = address;
        this.dob = dob;
    }
    
    public void addUser()
    {
    	localPassengerRepository.save(this);
    }

    
    public void showDetails()
    {
       
    }
    
    public void addCredit()
    {}
    
    public void searchJourneysTaken()
    {}
    
    public void searchFaresPaid()
    {}
    
    
    
    
    
    
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    } 
    
    public String getNIC()
    {
        return NIC;
    }

    public void setNIC(String NIC)
    {
        this.NIC = NIC;
    }

    public String getTokenId()
    {
        return tokenId;
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

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

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

}
