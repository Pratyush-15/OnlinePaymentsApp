package com.moneytap.repository;

import com.moneytap.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount,String> {
    BankAccount findByWalletId(String id);
}
