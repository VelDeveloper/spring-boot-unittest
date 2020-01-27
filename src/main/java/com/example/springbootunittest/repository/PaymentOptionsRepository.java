package com.example.springbootunittest.repository;

import com.example.springbootunittest.model.lego.PaymentOptions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentOptionsRepository extends MongoRepository<PaymentOptions, String> {
}
