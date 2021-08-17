package com.moneytap.service;

import com.moneytap.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    List<Transaction> viewAllTransactions();
    List<Transaction> viewTransactionsByDate(Date date);
    List<Transaction> viewTransactionsByType(String type);
    void addTransaction(Transaction transaction);
}
