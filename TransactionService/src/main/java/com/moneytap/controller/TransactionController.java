package com.moneytap.controller;

import com.moneytap.model.Transaction;
import com.moneytap.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/")
    List<Transaction> viewAllTransactions(){
        return transactionService.viewAllTransactions();
    }

    @GetMapping("/date")
    List<Transaction> viewTransactionsByDate(@RequestBody Date date){
        return transactionService.viewTransactionsByDate(date);
    }

    @GetMapping("/type")
    List<Transaction> viewTransactionsByType(@RequestBody String type){
        return transactionService.viewTransactionsByType(type);
    }

    @PostMapping("/")
    void addTransaction(@RequestBody Transaction transaction){
        System.out.println(transaction);
        transactionService.addTransaction(transaction);
    }

}
