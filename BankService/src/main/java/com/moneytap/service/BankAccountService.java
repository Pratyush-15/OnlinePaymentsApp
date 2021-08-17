package com.moneytap.service;

import com.moneytap.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllAccounts();
    void addBankAccount(BankAccount bankAccount);
    void removeBankAccount(String id);
    void withdraw(String id, int amount);
    void deposit(String id, int amount);
}
