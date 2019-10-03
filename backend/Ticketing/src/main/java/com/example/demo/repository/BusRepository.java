package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.Bus;

@Repository
public interface BusRepository extends MongoRepository<Bus,String>{
	public Bus findBybusId(String busId);
	public List<Bus> findAllBybusId(String busId);
}
