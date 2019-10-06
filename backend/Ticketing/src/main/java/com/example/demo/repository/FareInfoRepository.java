package com.example.demo.repository;

import java.util.List;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.FareInfo;

@Repository
public interface FareInfoRepository extends MongoRepository<FareInfo, String>
{
		public FareInfo findByName(String name);
		public FareInfo findBy_id(ObjectId _id);
		public List<FareInfo> findAllByName(String name);
		public List<FareInfo> findAllByNameAndDate(String name,String date);
		public FareInfo findByToken(String token);
}


