package com.services.impl;


import com.models.Customer;
import com.repositories.CustomerRepository;
import com.services.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

    @Autowired
    public CustomerRepository basicQueryRepository;

    //@Autowired
    //private ServerMain serverMainVertx;

    @Override
    public String addCustomer(Customer customer) {
        try {
            basicQueryRepository.insert(customer);
        } catch (Exception e) {
            return "Insertion Error - MongoDB Server Not Up or Entry Exists";
        }
        return "Inserted";
        // serverMainVertx.vertx.deployVerticle();
    }

    @Override
    public String updateCustomer(Customer customer) {
        try {
            basicQueryRepository.save(customer);
        } catch (Exception e) {
            return "Insertion Error - MongoDB Server Not Up or Entry Exists";
        }
        return "Inserted";
        // serverMainVertx.vertx.deployVerticle();
    }

    @Override
    public Customer findCustomer(String authenticationId) {
        try {
            Customer customer = basicQueryRepository.findCustomer(authenticationId);
            return customer;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}