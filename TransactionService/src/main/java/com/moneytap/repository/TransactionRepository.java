package com.moneytap.repository;

import com.moneytap.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,String> {
    List<Transaction> findAllByTransactionDate(Date date);
    List<Transaction> findAllByTransactionType(String type);
}
