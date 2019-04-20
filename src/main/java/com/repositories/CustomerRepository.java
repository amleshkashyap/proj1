package com.repositories;

import com.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query(value="{'authenticationId' : ?0}")
    public Customer findCustomer(String authenticationId);
}