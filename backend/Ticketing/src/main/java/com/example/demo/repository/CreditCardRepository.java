package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.CreditCard;


@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String>
{
		public CreditCard findByName(String name);
}
