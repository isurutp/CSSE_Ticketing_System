package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalPassengerRepository extends MongoRepository<LocalPassenger, String>
{
		public LocalPassenger findByName(String name);
		

}
