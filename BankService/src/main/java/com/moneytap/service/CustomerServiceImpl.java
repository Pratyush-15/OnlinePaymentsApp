package com.moneytap.service;

import com.moneytap.model.Customer;
import com.moneytap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    @Override
    public void changePassword(String customerId, String password) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
