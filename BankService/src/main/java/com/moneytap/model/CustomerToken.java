package com.moneytap.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerToken {
    @Id
    private String customerId;
    private String token;

    public CustomerToken() {
    }

    public CustomerToken(String customerId, String token) {
        this.customerId = customerId;
        this.token = token;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CustomerToken{" +
                "mobile='" + customerId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
