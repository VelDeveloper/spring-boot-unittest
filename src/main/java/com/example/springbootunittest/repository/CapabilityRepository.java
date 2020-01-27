package com.example.springbootunittest.repository;

import com.example.springbootunittest.model.Capability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends MongoRepository<Capability, String> {
}