package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.ForeignPassenger;
import com.example.demo.model.Token;

@Repository
public interface ForeignPassengerRepository extends MongoRepository<ForeignPassenger, String> {
	
	public ForeignPassenger findByTemporaryToken(Token temporaryToken);
}


