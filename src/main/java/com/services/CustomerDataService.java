package com.services;

import com.models.Customer;

public interface CustomerDataService {

    public String addCustomer(Customer customer);
    public String updateCustomer(Customer customer);
    public Customer findCustomer(String authenticationId);
}