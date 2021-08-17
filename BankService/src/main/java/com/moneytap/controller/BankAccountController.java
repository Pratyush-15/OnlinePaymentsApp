package com.moneytap.controller;

import com.moneytap.model.BankAccount;
import com.moneytap.model.Wallet;
import com.moneytap.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankAccountController {


    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    RestTemplate restTemplate;

    public static final String walletServiceURL = "http://wallet-service/";
    public static final String transactionServiceURL = "http://transaction-service/transactions/";


    @GetMapping("/")
    List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @PostMapping("/")
    void addBankAccount(@RequestBody BankAccount bankAccount,@RequestHeader("Authorization") String token) {
        bankAccountService.addBankAccount(bankAccount);
        Wallet wallet = new Wallet(bankAccount.getWalletId(),0,bankAccount.getAccNo());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        HttpEntity<Wallet> request = new HttpEntity<>(wallet,headers);
        restTemplate.postForObject(walletServiceURL + "create",request,Void.class);
    }

    @DeleteMapping("/{id}")
    void removeBankAccount(@PathVariable String id) {
        bankAccountService.removeBankAccount(id);
    }

    @PostMapping("/{walletId}/withdraw")
    void withdraw(@PathVariable String walletId, @RequestBody int amount) {
        bankAccountService.withdraw(walletId, amount);
    }

    @PostMapping("/{walletId}/deposit")
    void deposit(@PathVariable String walletId, @RequestBody int amount) {
        bankAccountService.deposit(walletId, amount);
    }
}
