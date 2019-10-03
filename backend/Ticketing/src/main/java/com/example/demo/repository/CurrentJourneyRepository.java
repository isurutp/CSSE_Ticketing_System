package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.CurrentJourney;

@Repository
public interface CurrentJourneyRepository extends MongoRepository<CurrentJourney,String>{
	public CurrentJourney findBybusId(String busId);
	public CurrentJourney findByusername(String username);
	public List<CurrentJourney> findAllBybusId(String busId);
}
