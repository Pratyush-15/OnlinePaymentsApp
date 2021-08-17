package com.moneytap.service;

import com.moneytap.model.BeneficiaryDetails;

import java.util.List;

public interface BeneficiaryDetailsService {
    List<BeneficiaryDetails> getAllBeneficiaries();
    void addBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails);
    BeneficiaryDetails viewBeneficiaryDetails(String id);
    void deleteBeneficiaryDetails(String id);

}
