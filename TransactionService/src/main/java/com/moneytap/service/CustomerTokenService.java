package com.moneytap.service;

import com.moneytap.model.CustomerToken;

public interface CustomerTokenService {
    Boolean isToken(String token);
    void addToken(CustomerToken token);
    void deleteToken(String token);
}
