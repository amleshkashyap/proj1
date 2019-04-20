package com.controller;

import com.models.Authentication;
import com.models.Customer;
import com.services.AuthenticationService;
import com.services.CustomerDataService;
import com.utils.AuthenticationUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class ServerController {

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private AuthenticationService authenticationService;

    public String home() {

        return "Spring boot is working!";

    }

    @PostMapping("/register")
    public String registerCustomer(@RequestBody String customerDataBody) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(customerDataBody);
        String emailId = (String) jsonObject.get("emailId");
        String password = (String) jsonObject.get("password");
        Authentication authentication = new Authentication(emailId, password);
        try {
            String authenticationResult = authenticationService.addCustomer(authentication);
        } catch (Exception e) {
            return "User Exists or Server Down";
        }
        String id = authenticationService.getId(authentication);
        String dob = (String) jsonObject.get("dob");
        Customer customer = new Customer(id, (String) jsonObject.get("city"), (String) jsonObject.get("name"),
                LocalDate.parse(dob));
        String additionResult = customerDataService.addCustomer(customer);
        return additionResult;
    }

    @PatchMapping("/bigUpdate")
    public String bigUpdateCustomer(@RequestBody Customer customerDataBody) throws IOException {
        String additionResult = customerDataService.updateCustomer(customerDataBody);
        return additionResult;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestHeader String Authorization, @RequestBody Customer customerDataBody) throws IOException {
        String customerId = AuthenticationUtil.checkAuthentication(Authorization, authenticationService);
        Customer customer = customerDataService.findCustomer(customerId);
        customerDataBody.id = customer.id;
        String additionResult = customerDataService.updateCustomer(customerDataBody);
        return additionResult;
    }

    @GetMapping("/login")
    public String findCustomer(@RequestHeader String Authorization) {
        try {
            String customerId = AuthenticationUtil.checkAuthentication(Authorization, authenticationService);
            Customer queryResult = customerDataService.findCustomer(customerId);
            String userData = String.format("%s : %s : %s : %s", queryResult.id, queryResult.getCity(),
                     queryResult.getName(), queryResult.getAge());
            return userData;
        } catch (Exception e) {
            return "User Not Found";
        }
    }
}