package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.FareInfo;
import com.example.demo.controller.LocalPassenger;

@Repository
public interface FareInfoRepository extends MongoRepository<FareInfo, String>
{
		public FareInfo findByName(String name);
		public FareInfo findByToken(String token);
}


