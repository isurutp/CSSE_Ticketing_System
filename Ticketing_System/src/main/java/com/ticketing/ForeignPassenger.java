/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticketing;

/**
 *
 * @author Shehan
 */
public class ForeignPassenger extends Passenger
{
    private String temporaryTokenID;

    
    
    
    
    
//**********************************************************************************************************
//--------------------------------------- Setters and Getters ----------------------------------------------
//**********************************************************************************************************
    public String getTemporaryTokenID()
    {
        return temporaryTokenID;
    }

    public void setTemporaryTokenID(String temporaryTokenID)
    {
        this.temporaryTokenID = temporaryTokenID;
    }
    
}
