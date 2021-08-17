package com.moneytap.service;

import com.moneytap.model.BeneficiaryDetails;
import com.moneytap.repository.BeneficiaryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryDetailsServiceImpl implements BeneficiaryDetailsService{

    @Autowired
    BeneficiaryDetailsRepository beneficiaryDetailsRepository;

    @Override
    public List<BeneficiaryDetails> getAllBeneficiaries() {
        List<BeneficiaryDetails> beneficiaryDetailsList = new ArrayList<>();
        beneficiaryDetailsRepository.findAll().forEach(beneficiaryDetailsList::add);
        return beneficiaryDetailsList;
    }

    @Override
    public void addBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails) {
        beneficiaryDetailsRepository.save(beneficiaryDetails);
    }

    @Override
    public BeneficiaryDetails viewBeneficiaryDetails(String id) {
        return beneficiaryDetailsRepository.findById(id).get();
    }

    @Override
    public void deleteBeneficiaryDetails(String id) {
        beneficiaryDetailsRepository.deleteById(id);
    }
}
