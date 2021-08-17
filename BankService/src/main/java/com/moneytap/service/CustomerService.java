package com.moneytap.service;

import com.moneytap.model.Customer;

import java.util.List;

public interface CustomerService {
    boolean login();
    void logout();
    List<Customer> getCustomers();
    void changePassword(String customerId, String password);
    void addCustomer(Customer customer);
}
