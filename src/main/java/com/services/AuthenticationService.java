package com.services;

import com.models.Authentication;

public interface AuthenticationService {
    public String addCustomer(Authentication authentication);
    public String getId(Authentication authentication);
}
