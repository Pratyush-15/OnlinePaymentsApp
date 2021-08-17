package com.moneytap.repository;

import com.moneytap.model.BeneficiaryDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryDetailsRepository extends CrudRepository<BeneficiaryDetails,String> {
}
