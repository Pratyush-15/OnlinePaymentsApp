package com.moneytap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
    @Id
    private String walletId;
    @JsonIgnore
    private int balance;
    @JsonIgnore
    private String accNo;

    public Wallet() {
    }

    public Wallet(String walletId, int balance, String accNo) {
        this.walletId = walletId;
        this.balance = balance;
        this.accNo = accNo;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId='" + walletId + '\'' +
                ", balance=" + balance +
                ", accNo='" + accNo + '\'' +
                '}';
    }
}
