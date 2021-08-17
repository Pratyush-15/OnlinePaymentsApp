package com.moneytap.service;

import com.moneytap.model.CustomerToken;
import com.moneytap.repository.CustomerTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTokenServiceImpl implements CustomerTokenService{

    @Autowired
    CustomerTokenRepository customerTokenRepository;

    @Override
    public Boolean isToken(String token) {
        return customerTokenRepository.existsById(token);
    }

    @Override
    public void addToken(CustomerToken token) {
        customerTokenRepository.save(token);
    }

    @Override
    public void deleteToken(String token) {
        customerTokenRepository.deleteById(token);
    }
}
