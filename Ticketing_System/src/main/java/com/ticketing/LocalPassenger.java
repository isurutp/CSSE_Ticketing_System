/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticketing;

import java.util.Date;

/**
 *
 * @author Shehan
 */
public class LocalPassenger extends Passenger
{
    private String NIC;
    private String tokenId;
    private float amount;
    private String name;
    private String address;
    private Date dob;

    public LocalPassenger(String NIC, String tokenId, float amount, String name, String address, Date dob)
    {
        this.NIC = NIC;
        this.tokenId = tokenId;
        this.amount = amount;
        this.name = name;
        this.address = address;
        this.dob = dob;
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
