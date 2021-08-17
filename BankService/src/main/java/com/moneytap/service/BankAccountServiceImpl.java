package com.moneytap.service;

import com.moneytap.model.BankAccount;
import com.moneytap.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> getAllAccounts() {
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccountList::add);
        return bankAccountList;
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void removeBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public void withdraw(String id, int amount) {
        BankAccount bankAccount = bankAccountRepository.findByWalletId(id);
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void deposit(String id, int amount) {
        BankAccount bankAccount = bankAccountRepository.findByWalletId(id);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        bankAccountRepository.save(bankAccount);
    }
}
