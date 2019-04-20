package com.repositories;

import com.models.Authentication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AuthenticationRepository extends MongoRepository<Authentication, String> {
    @Query(value="{'emailId' : ?0, 'password' : ?1}")
    public Authentication findCustomer(String emailId, String password);
}