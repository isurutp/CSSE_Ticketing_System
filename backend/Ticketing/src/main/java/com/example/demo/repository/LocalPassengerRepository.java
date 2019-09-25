package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.LocalPassenger;


@Repository
public interface LocalPassengerRepository extends MongoRepository<LocalPassenger, String>
{
		public LocalPassenger findByName(String name);
		public LocalPassenger findByPassword(int password);

}
