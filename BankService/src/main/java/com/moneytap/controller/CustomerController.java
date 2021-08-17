package com.moneytap.controller;

import com.moneytap.model.Customer;
import com.moneytap.model.CustomerToken;
import com.moneytap.model.JwtResponse;
import com.moneytap.service.CustomerService;
import com.moneytap.service.CustomerTokenService;
import com.moneytap.service.UserService;
import com.moneytap.util.JWTUtility;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTokenService customerTokenService;
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    JwtResponse login(@RequestParam String customerId, @RequestParam String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(customerId, password)
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials");
        }

        final UserDetails userDetails = userService.loadUserByUsername(customerId);
        final String token = jwtUtility.generateToken(userDetails);
        CustomerToken customerToken = new CustomerToken(customerId,token);
        customerTokenService.addToken(customerToken);
        return new JwtResponse(token);
    }

    @PostMapping("/customerLogout")
    void customerLogout(@RequestParam String id) {
        customerTokenService.deleteToken(id);
    }

    @GetMapping("/customers")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("change-password")
    void changePassword(@RequestParam String customerId, String password) {
        customerService.changePassword(customerId,password);
    }

    @PostMapping("/customer")
    void addCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String token) {
        customerService.addCustomer(customer);
    }


}
