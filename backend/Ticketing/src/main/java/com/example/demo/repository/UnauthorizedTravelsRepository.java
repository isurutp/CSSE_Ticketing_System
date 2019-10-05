package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.UnauthorizedTravels;

@Repository
public interface UnauthorizedTravelsRepository extends MongoRepository<UnauthorizedTravels,String>{
	public UnauthorizedTravels findByName(String name);
	public List<UnauthorizedTravels> findAllByName(String name);
}
