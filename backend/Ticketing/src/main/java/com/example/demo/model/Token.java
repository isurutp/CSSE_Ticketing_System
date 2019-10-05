package com.example.demo.model;

public class Token {
	
	private int BarCode;
	private String TokenId;
	
	//Default constructor
	public Token() {
		super();
	}
	
	//constructor
	public Token(int barCode, String tokenId) {
		super();
		BarCode = barCode;
		TokenId = tokenId;
	}
	
	
	public int getBarCode() {
		return BarCode;
	}
	public void setBarCode(int barCode) {
		BarCode = barCode;
	}
	public String getTokenId() {
		return TokenId;
	}
	public void setTokenId(String tokenId) {
		TokenId = tokenId;
	}
	
	
}
