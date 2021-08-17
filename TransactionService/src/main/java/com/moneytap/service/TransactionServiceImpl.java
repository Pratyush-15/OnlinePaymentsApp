package com.moneytap.service;

import com.moneytap.model.Transaction;
import com.moneytap.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> viewAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public List<Transaction> viewTransactionsByDate(Date date) {
        return transactionRepository.findAllByTransactionDate(date);
    }

    @Override
    public List<Transaction> viewTransactionsByType(String type) {
        return transactionRepository.findAllByTransactionType(type);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
