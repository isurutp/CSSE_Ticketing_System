package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.controller.Bus;

public interface BusRepository extends MongoRepository<Bus,String>{
	public Bus findBybusId(String busId);
}
