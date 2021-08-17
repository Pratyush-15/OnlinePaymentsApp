package com.moneytap.repository;

import com.moneytap.model.CustomerToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTokenRepository extends CrudRepository<CustomerToken, String> {
}
