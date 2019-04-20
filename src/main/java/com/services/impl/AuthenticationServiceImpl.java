package com.services.impl;


import com.models.Authentication;
import com.repositories.AuthenticationRepository;
import com.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    public AuthenticationRepository authenticationRepository;

    private static Logger logger = LoggerFactory.getLogger(AuthenticationRepository.class);

    @Override
    public String addCustomer(Authentication authentication) {
        try {
            authenticationRepository.insert(authentication);
        } catch (Exception e) {
            return "Error : Not Inserted";
        }
        return "Inserted";
        // serverMainVertx.vertx.deployVerticle();
    }

    @Override
    public String getId(Authentication authentication) {
        try {
            return authenticationRepository.findCustomer(authentication.getEmailId(), authentication.getPassword()).getId();
        } catch (Exception e) {
            return "User Not Found";
        }
    }
}