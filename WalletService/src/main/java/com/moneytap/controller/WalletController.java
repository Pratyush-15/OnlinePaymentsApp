package com.moneytap.controller;

import com.moneytap.exceptions.DuplicateWalletException;
import com.moneytap.exceptions.WalletNotFoundException;
import com.moneytap.model.Transaction;
import com.moneytap.model.Wallet;
import com.moneytap.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class WalletController {

    public static final String bankServiceURL = "http://bank-service/account/";
    public static final String transactionServiceURL = "http://transaction-service/transactions/";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WalletService walletService;

    @PostMapping("/create")
    void createWallet(@RequestBody Wallet wallet){
        try {
            walletService.createWallet(wallet);
        } catch (DuplicateWalletException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{walletId}/balance")
    int getBalance(@PathVariable String walletId){
        return walletService.getBalance(walletId);
    }

    @PostMapping("/{walletId}/add")
    void addMoney(@PathVariable String walletId, @RequestParam int amount,@RequestHeader("Authorization") String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        walletService.addMoney(walletId,amount);
        HttpEntity<Integer> withdrawalRequest = new HttpEntity<>(amount,headers);
        restTemplate.postForObject(bankServiceURL+walletId+"/withdraw",withdrawalRequest,Void.class);
        Transaction transaction = null;
        try {
            transaction = new Transaction(
                    Long.toString(System.currentTimeMillis()),
                    "UPI", new Date(System.currentTimeMillis()),
                    amount,"Bank to Wallet",walletService.getWalletById(walletId));
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        HttpEntity<Transaction> transactionRequest = new HttpEntity<>(transaction,headers);
        System.out.println(transaction);
        restTemplate.postForObject(transactionServiceURL,transactionRequest,Void.class);


    }

    @PostMapping("/{walletId}/transfer")
    void fundTransfer(@PathVariable String walletId, @RequestParam String walletId2,
                      @RequestParam int amount,@RequestHeader("Authorization") String token){
        walletService.fundTransfer(walletId,walletId2,amount);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        Transaction transaction = null;
        try {
            transaction = new Transaction(
                    Long.toString(System.currentTimeMillis()),
                    "UPI", new Date(System.currentTimeMillis()),
                    -amount,"Fund Transfer",walletService.getWalletById(walletId));
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        HttpEntity<Transaction> withdrawalRequest = new HttpEntity<>(transaction,headers);
        restTemplate.postForObject(transactionServiceURL,withdrawalRequest,Void.class);
        transaction.setAmount(amount);
        try {
            transaction.setWallet(walletService.getWalletById(walletId2));
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        HttpEntity<Transaction> depositRequest = new HttpEntity<>(transaction,headers);
        restTemplate.postForObject(transactionServiceURL,depositRequest,Void.class);
    }

    @PostMapping("/{walletId}/deposit")
    void depositAmount(@PathVariable String walletId, @RequestParam int amount,
                       @RequestHeader("Authorization") String token){
        try {
            walletService.depositAmount(walletId,amount);
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        HttpEntity<Integer> depositRequest = new HttpEntity<>(amount,headers);
        restTemplate.postForObject(bankServiceURL+walletId+"/deposit",depositRequest,Void.class);
        Transaction transaction = null;
        try {
            transaction = new Transaction(
                    Long.toString(System.currentTimeMillis()),
                    "UPI", new Date(System.currentTimeMillis()),
                    -amount,"Wallet to Bank",walletService.getWalletById(walletId));
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        HttpEntity<Transaction> transactionRequest = new HttpEntity<>(transaction,headers);
        restTemplate.postForObject(transactionServiceURL,transactionRequest,Void.class);
    }
}
